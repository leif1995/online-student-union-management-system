package edu.ncwu.osums.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.Plan;
import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.PlanService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.util.FTPUtil;
import edu.ncwu.osums.util.FormatUtil;
import edu.ncwu.osums.util.StringUtil;

@Controller
@RequestMapping("/plan")
@SessionAttributes({"user", "position"})
public class PlanController {
    @Autowired
    private PlanService planService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/readyToCreate")
    public ModelAndView readyToCreate(@ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("plan_create");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "planName") String planName,
                         @RequestParam(name = "planType") String planType,
                         @RequestParam(name = "activityDate") String activityDate,
                         @RequestParam(name = "activityPlace") String activityPlace,
                         @RequestParam(name = "activityBackground") String activityBackground,
                         @RequestParam(name = "activityPurpose") String activityPurpose,
                         @RequestParam(name = "activityTheme") String activityTheme,
                         @RequestParam(name = "activityObject") String activityObject,
                         @ModelAttribute("user") User userInSession,
                         @ModelAttribute("position") Position positionInSession) {
        Plan plan = new Plan(planName, planType, activityDate, activityPlace, activityBackground, activityPurpose, activityTheme, activityObject, null, null, 1, userInSession.getDepartment_name(), userInSession.getUsername(), FormatUtil.getCurrentDate(), userInSession.getNickname(), FormatUtil.getCurrentDate(), userInSession.getNickname());
        planService.create(positionInSession, plan);
        return "success";
    }

    @PostMapping("/removeByIds")
    @ResponseBody
    public String removeByIds(@RequestParam(name = "ids") String ids) {
        ids = "(" + ids.substring(0, ids.length() - 2) + ")";

        for (String id : ids.substring(1, ids.length() - 1).split(", ")) {
            Plan plan = planService.findById(Integer.valueOf(id));

            if (" " != plan.getSuffix()) {
                FTPUtil.deleteFile(id + plan.getSuffix(), "/plan/");
            }
        }

        planService.removeByIds(ids);
        return "success";
    }

    @PostMapping("/changeStatusForRemoveByIds")
    @ResponseBody
    public String changeStatusForRemoveByIds(@RequestParam(name = "ids") String ids, @ModelAttribute("user") User userInSession) {
        ids = "(" + ids.substring(0, ids.length() - 2) + ")";
        planService.changeStatusForRemoveByIds(ids, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @PostMapping("/changeStatusForPassByIds")
    @ResponseBody
    public String changeStatusForPassByIds(@RequestParam(name = "ids") String ids, @ModelAttribute("user") User userInSession) {
        ids = "(" + ids.substring(0, ids.length() - 2) + ")";
        planService.changeStatusForPassByIds(userInSession.getDepartment_name(), ids, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @PostMapping("/changeById")
    @ResponseBody
    public String changeById(@RequestParam(name = "id") int id,
                             @RequestParam(name = "planName") String planName,
                             @RequestParam(name = "planType") String planType,
                             @RequestParam(name = "activityDate") String activityDate,
                             @RequestParam(name = "activityPlace") String activityPlace,
                             @RequestParam(name = "activityBackground") String activityBackground,
                             @RequestParam(name = "activityPurpose") String activityPurpose,
                             @RequestParam(name = "activityTheme") String activityTheme,
                             @RequestParam(name = "activityObject") String activityObject,
                             @ModelAttribute("user") User userInSession) {
        Plan plan = new Plan(planName, planType, activityDate, activityPlace, activityBackground, activityPurpose, activityTheme, activityObject, null, null, 0, null, null, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        plan.setId(id);
        planService.changeById(plan);
        return "success";
    }

    @GetMapping("/information/{flag}/{id}")
    @ResponseBody
    public ModelAndView information(@PathVariable("flag") String flag,
                                    @PathVariable("id") int id,
                                    @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("plan_information");
        Plan plan = planService.findById(id);
        plan.setActivity_date(plan.getActivity_date().substring(0, plan.getActivity_date().indexOf(" ")) + "T" + plan.getActivity_date().substring(plan.getActivity_date().indexOf(" ") + 1));
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("plan", plan);
        modelAndView.addObject("flag", flag);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @GetMapping("/findActive")
    @ResponseBody
    public ModelAndView findActive(@RequestParam(name = "search", defaultValue="") String search,
                                   @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                   @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("plan_active");
        int recordCount = planService.findActiveCount(userInSession.getDepartment_name(), "%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Plan> planList = new ArrayList<Plan>();
        planList = planService.findActive(userInSession.getDepartment_name(), "%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = planService.findActiveCount(userInSession.getDepartment_name(), "%%");
        int recordCompletedCount = planService.findCompletedCount(userInSession.getDepartment_name(), "%%");
        int recordOverdueCount = planService.findOverdueCount(userInSession.getDepartment_name(), "%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("planList", planList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recordActiveCount", recordActiveCount);
        modelAndView.addObject("recordCompletedCount", recordCompletedCount);
        modelAndView.addObject("recordOverdueCount", recordOverdueCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @GetMapping("/findCompleted")
    @ResponseBody
    public ModelAndView findCompleted(@RequestParam(name = "search", defaultValue="") String search,
                                      @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                      @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("plan_completed");
        int recordCount = planService.findCompletedCount(userInSession.getDepartment_name(), "%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Plan> planList = new ArrayList<Plan>();
        planList = planService.findCompleted(userInSession.getDepartment_name(), "%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = planService.findActiveCount(userInSession.getDepartment_name(), "%%");
        int recordCompletedCount = planService.findCompletedCount(userInSession.getDepartment_name(), "%%");
        int recordOverdueCount = planService.findOverdueCount(userInSession.getDepartment_name(), "%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("planList", planList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recordActiveCount", recordActiveCount);
        modelAndView.addObject("recordCompletedCount", recordCompletedCount);
        modelAndView.addObject("recordOverdueCount", recordOverdueCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @GetMapping("/findOverdue")
    @ResponseBody
    public ModelAndView findOverdue(@RequestParam(name = "search", defaultValue="") String search,
                                    @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                    @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("plan_overdue");
        int recordCount = planService.findOverdueCount(userInSession.getDepartment_name(), "%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Plan> planList = new ArrayList<Plan>();
        planList = planService.findOverdue(userInSession.getDepartment_name(), "%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = planService.findActiveCount(userInSession.getDepartment_name(), "%%");
        int recordCompletedCount = planService.findCompletedCount(userInSession.getDepartment_name(), "%%");
        int recordOverdueCount = planService.findOverdueCount(userInSession.getDepartment_name(), "%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("planList", planList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recordActiveCount", recordActiveCount);
        modelAndView.addObject("recordCompletedCount", recordCompletedCount);
        modelAndView.addObject("recordOverdueCount", recordOverdueCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(name = "id", defaultValue="0") int id, @RequestParam("attachment") MultipartFile attachment) {
        id = id == 0 ? planService.findLastId().getId() : id;

        if (attachment.getSize() > 0) {
            planService.changeAttachmentById(id, attachment.getOriginalFilename().substring(0, attachment.getOriginalFilename().lastIndexOf(".")), attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf(".")));
            FTPUtil.uploadFile(attachment, id + attachment.getOriginalFilename().substring(attachment.getOriginalFilename().lastIndexOf(".")), "/plan/");
        } else {
            planService.changeAttachmentById(id, " ", " ");
        }

        return "redirect:/plan/information/active/" + id;
    }
}
