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

import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.Recruitment;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.DepartmentService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.util.FTPUtil;
import edu.ncwu.osums.util.FormatUtil;
import edu.ncwu.osums.util.StringUtil;

@Controller
@RequestMapping("/recruitment")
@SessionAttributes("user")
public class RecruitmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/signedUp")
    public ModelAndView signedUp() {
        ModelAndView modelAndView = new ModelAndView("recruitment_signed_up");
        List<Department> departmentList = new ArrayList<Department>();
        departmentList = departmentService.findForRecruitment();
        modelAndView.addObject("departmentList", departmentList);
        return modelAndView;
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "nickname") String nickname,
                         @RequestParam(name = "gender") String gender,
                         @RequestParam(name = "birthday") String birthday,
                         @RequestParam(name = "major") String major,
                         @RequestParam(name = "classs") String classs,
                         @RequestParam(name = "nativePlace") String nativePlace,
                         @RequestParam(name = "username") String username,
                         @RequestParam(name = "departmentName") String departmentName,
                         @RequestParam(name = "swap") String swap,
                         @RequestParam(name = "phone") String phone,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "qq") String qq,
                         @RequestParam(name = "hobby") String hobby,
                         @RequestParam(name = "selfAppraisal") String selfAppraisal,
                         @RequestParam(name = "departmentUnderstanding") String departmentUnderstanding,
                         @RequestParam(name = "awardsAndAchievements") String awardsAndAchievements) {
        Recruitment recruitment = new Recruitment(nickname, gender, birthday, major, classs, nativePlace, username, departmentName, swap, phone, email, qq, hobby, selfAppraisal, departmentUnderstanding, awardsAndAchievements, "申请", FormatUtil.getCurrentDate(), nickname, FormatUtil.getCurrentDate(), nickname);

        if (recruitmentService.create(recruitment) < 0) {
            return "不可重复注册！";
        }

        return "success";
    }

    @PostMapping("/removeAll")
    @ResponseBody
    public String removeAll() {
        for (Recruitment recruitment : recruitmentService.findAll()) {
            FTPUtil.deleteFile(recruitment.getUsername() + ".png", "/head portrait/");

            if (!"通过".equals(recruitment.getStatus())) {
                FTPUtil.deleteFile(recruitment.getUsername() + ".jpg", "/head portrait/");
            }
        }

        recruitmentService.removeAll();
        return "success";
    }

    @PostMapping("/changeForDepartmentById")
    @ResponseBody
    public String changeForDepartmentById(@RequestParam(name = "id") int id, @RequestParam(name = "departmentName") String departmentName) {
        if ("软件学院" != departmentName && "主席团" != departmentName) {
            recruitmentService.changeForDepartmentById(id, departmentName);
        }

        return "success";
    }

    @PostMapping("/changeStatusForRemoveById")
    @ResponseBody
    public String changeStatusForRemoveById(@RequestParam(name = "id") int id, @ModelAttribute("user") User userInSession) {
        recruitmentService.changeStatusForRemoveById(id, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @PostMapping("/changeStatusForPassById")
    @ResponseBody
    public String changeStatusForPassById(@RequestParam(name = "id") int id, @ModelAttribute("user") User userInSession) {
        recruitmentService.changeStatusForPassById(id, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @GetMapping("/information/{id}")
    @ResponseBody
    public ModelAndView information(@PathVariable("id") int id,
                                    @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("recruitment_information");
        Recruitment recruitment = recruitmentService.findById(id);
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("recruitment", recruitment);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @GetMapping("/findApplication")
    @ResponseBody
    public ModelAndView findApplication(@RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                        @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("recruitment_application");
        int recordCount = recruitmentService.findCount();
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Recruitment> recruitmentList = new ArrayList<Recruitment>();
        recruitmentList = recruitmentService.findApplication((Integer.valueOf(currentPage) - 1) * 7);
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("recruitmentList", recruitmentList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("headPortrait") MultipartFile headPortrait, @RequestParam("headPortraitUsername") String username) {
        FTPUtil.uploadFile(headPortrait, username + ".png", "/head portrait/");
        FTPUtil.uploadFile(headPortrait, username + ".jpg", "/head portrait/");
        return "redirect:/indexs/rjxy";
    }
}
