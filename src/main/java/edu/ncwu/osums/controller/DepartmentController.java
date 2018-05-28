package edu.ncwu.osums.controller;

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
import org.springframework.web.servlet.ModelAndView;

import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.exception.ServiceException;
import edu.ncwu.osums.service.DepartmentService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.PlanService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.service.UserService;
import edu.ncwu.osums.util.FormatUtil;

@Controller
@RequestMapping("/department")
@SessionAttributes("user")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "departmentName") String departmentName,
                         @ModelAttribute("user") User userInSession) {
        Department department = new Department(departmentName, null, 0, FormatUtil.getCurrentDate(), userInSession.getNickname(), FormatUtil.getCurrentDate(), userInSession.getNickname());

        try {
            departmentService.create(department);
        } catch (ServiceException serviceException) {
            return serviceException.getServiceErrorMessage();
        }

        return "success";
    }

    @PostMapping("/removeById")
    @ResponseBody
    public String removeById(@RequestParam(name = "id") int id,
                             @RequestParam(name = "departmentName") String departmentName,
                             @ModelAttribute("user") User userInSession) {
        Department department = new Department(departmentName, null, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        department.setId(id);
        departmentService.removeById(department);

        return "success";
    }

    @PostMapping("/changeById")
    @ResponseBody
    public String changeById(@RequestParam(name = "id", defaultValue="0") int id,
                             @RequestParam(name = "introduction") String introduction,
                             @ModelAttribute("user") User userInSession) {
        Department department = new Department(null, introduction, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        department.setId(id);
        departmentService.changeById(department);
        return "success";
    }

    @PostMapping("/findById")
    @ResponseBody
    public Department findById(@RequestParam(name = "id") int id) {
        return departmentService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(@ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("management_department");
        List<Department> departmentList = new ArrayList<Department>();
        departmentList = departmentService.findAll();
        String studentUnion = departmentService.findById(0).getIntroduction();
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("studentUnion", studentUnion);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/findForDiagramByDepartmentName")
    @ResponseBody
    public Object findForDiagramByDepartmentName() {
        List<Object> objectList = new ArrayList<Object>();

        for (Department department : departmentService.findAll()) {
            Object[] objects = {department, planService.findForDiagramByDepartmentName(department.getDepartment_name())};
            objectList.add(objects);
        }

        objectList.add(new Object[]{planService.findCompletedCount("%%", "%%"), userService.findCountByDepartmentName("%%") - 1});
        return objectList;
    }

    @PostMapping("/findForDiagramByPlanType")
    @ResponseBody
    public Object findForDiagramByPlanType() {
        Object[][] objectss = {
                {"学习", planService.findCountByPlanType("学习")},
                {"生活", planService.findCountByPlanType("生活")},
                {"体育", planService.findCountByPlanType("体育")},
                {"宣传", planService.findCountByPlanType("宣传")},
                {"文艺", planService.findCountByPlanType("文艺")},
                {"女生", planService.findCountByPlanType("女生")}};

        return objectss;
    }
}
