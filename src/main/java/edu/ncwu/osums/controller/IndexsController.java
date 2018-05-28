package edu.ncwu.osums.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.ncwu.osums.entity.Indexs;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.FeedbackService;
import edu.ncwu.osums.service.IndexsService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.util.FTPUtil;
import edu.ncwu.osums.util.FormatUtil;
import edu.ncwu.osums.util.StringUtil;

@Controller
@RequestMapping("/index")
@SessionAttributes("user")
public class IndexsController {
    @Autowired
    private IndexsService indexsService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    public String create(@RequestParam(name = "indexsName") String indexsName,
                         @RequestParam(name = "content") String content,
                         @RequestParam(name = "type") String type,
                         @RequestParam(name = "attachment") MultipartFile attachment,
                         @ModelAttribute("user") User userInSession) throws IOException {
        Indexs indexs = new Indexs(indexsName, content, type, 1, FormatUtil.getCurrentDate(), userInSession.getNickname(), FormatUtil.getCurrentDate(), userInSession.getNickname());
        indexsService.create(indexs);
        int id = indexsService.findLastId().getId();

        if (attachment.getSize() > 0) {
            if ("新闻中心".equals(type)) {
                indexsService.changeAttachmentById(id, attachment.getOriginalFilename().substring(0, attachment.getOriginalFilename().lastIndexOf(".")), ".jpg");
                FTPUtil.uploadFile(attachment, id + ".jpg", "/index/");
            } else {
                indexsService.changeAttachmentById(id, attachment.getOriginalFilename().substring(0, attachment.getOriginalFilename().lastIndexOf(".")), attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf(".")));
                FTPUtil.uploadFile(attachment, id + attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf(".")), "/index/");
            }
        } else {
            indexsService.changeAttachmentById(id, " ", " ");
        }

        return "redirect:/index/findAll";
    }

    @PostMapping("/removeById")
    @ResponseBody
    public String removeById(@RequestParam(name = "id") int id) {
        Indexs indexs = indexsService.findById(id);
        FTPUtil.deleteFile(id + indexs.getSuffix(), "/index/");
        indexsService.removeById(id);
        return "success";
    }

    @PostMapping("/changeStatusForPassById")
    @ResponseBody
    public String changeStatusForPassById(@RequestParam(name = "id") int id, @ModelAttribute("user") User userInSession) {
        indexsService.changeStatusForPassById(id, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @PostMapping("/findById")
    @ResponseBody
    public Indexs findById(@RequestParam(name = "id") int id) {
        return indexsService.findById(id);
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "search", defaultValue="") String search,
                                @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("management_index");
        int recordCount = indexsService.findAllCount("%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Indexs> indexsList = new ArrayList<Indexs>();
        indexsList = indexsService.findAll("%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("indexsList", indexsList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @GetMapping("/rjxy")
    public ModelAndView rjxy(@RequestParam(name = "newsCenterSearch", defaultValue="") String newsCenterSearch,
                             @RequestParam(name = "organizationStructureSearch", defaultValue="") String organizationStructureSearch,
                             @RequestParam(name = "noticeBoardSearch", defaultValue="") String noticeBoardSearch) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Indexs> newsCenterTopThreeList = new ArrayList<Indexs>();
        newsCenterTopThreeList = indexsService.findNewsCenterTopThree();
        List<Indexs> newsCenterList = new ArrayList<Indexs>();
        newsCenterList = indexsService.findNewsCenter("%" + newsCenterSearch + "%");
        List<Indexs> organizationStructureList = new ArrayList<Indexs>();
        organizationStructureList = indexsService.findOrganizationStructure("%" + organizationStructureSearch + "%");
        List<Indexs> noticeBoardList = new ArrayList<Indexs>();
        noticeBoardList = indexsService.findNoticeBoard("%" + noticeBoardSearch + "%");
        int feedbackCount = feedbackService.findCount();
        Notice notice = noticeService.findContent();
        modelAndView.addObject("newsCenterSearch", newsCenterSearch);
        modelAndView.addObject("organizationStructureSearch", organizationStructureSearch);
        modelAndView.addObject("noticeBoardSearch", noticeBoardSearch);
        modelAndView.addObject("newsCenterTopThreeList", newsCenterTopThreeList);
//        modelAndView.addObject("second", newsCenterTopThreeList.get(1));
//        modelAndView.addObject("third", newsCenterTopThreeList.get(2));
        modelAndView.addObject("newsCenterList", newsCenterList);
        modelAndView.addObject("organizationStructureList", organizationStructureList);
        modelAndView.addObject("noticeBoardList", noticeBoardList);
        modelAndView.addObject("feedbackCount", feedbackCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }
}
