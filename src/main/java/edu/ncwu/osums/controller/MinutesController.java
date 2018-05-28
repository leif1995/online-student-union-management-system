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
import edu.ncwu.osums.entity.Minutes;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.DepartmentService;
import edu.ncwu.osums.service.MinutesService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.util.FormatUtil;
import edu.ncwu.osums.util.StringUtil;

@Controller
@RequestMapping("/minutes")
@SessionAttributes("user")
public class MinutesController {
    @Autowired
    private MinutesService minutesService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "minutesName") String minutesName,
                         @RequestParam(name = "departmentName") String departmentName,
                         @RequestParam(name = "startTime") String startTime,
                         @RequestParam(name = "endTime") String endTime,
                         @RequestParam(name = "place") String place,
                         @RequestParam(name = "host") String host,
                         @RequestParam(name = "attendees") String attendees,
                         @RequestParam(name = "leaver") String leaver,
                         @RequestParam(name = "later") String later,
                         @RequestParam(name = "absenteeismer") String absenteeismer,
                         @RequestParam(name = "content") String content,
                         @ModelAttribute("user") User userInSession) {
        Minutes minutes = new Minutes(minutesName, departmentName, startTime, endTime, place, (host + ";").substring(0, (host + ";").indexOf(";")), attendees, leaver, later, absenteeismer, content, FormatUtil.getCurrentDate(), userInSession.getNickname(), FormatUtil.getCurrentDate(), userInSession.getNickname());
        minutesService.create(minutes);
        return "success";
    }

    @PostMapping("/removeById")
    @ResponseBody
    public String removeById(@RequestParam(name = "id") int id) {
        minutesService.removeById(id);
        return "success";
    }

    @PostMapping("/changeById")
    @ResponseBody
    public String changeById(@RequestParam(name = "id") int id,
                             @RequestParam(name = "minutesName") String minutesName,
                             @RequestParam(name = "startTime") String startTime,
                             @RequestParam(name = "endTime") String endTime,
                             @RequestParam(name = "place") String place,
                             @RequestParam(name = "host") String host,
                             @RequestParam(name = "attendees") String attendees,
                             @RequestParam(name = "leaver") String leaver,
                             @RequestParam(name = "later") String later,
                             @RequestParam(name = "absenteeismer") String absenteeismer,
                             @RequestParam(name = "content") String content,
                             @ModelAttribute("user") User userInSession) {
        Minutes minutes = new Minutes(minutesName, null, startTime, endTime, place, (host + ";").substring(0, (host + ";").indexOf(";")), attendees, leaver, later, absenteeismer, content, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        minutes.setId(id);
        minutesService.changeById(minutes);
        return "success";
    }

    @PostMapping("/findById")
    @ResponseBody
    public Minutes findById(@RequestParam(name = "id") int id) {
        return minutesService.findById(id);
    }

    @GetMapping("/findByDepartmentName")
    @ResponseBody
    public ModelAndView findByDepartmentName(@RequestParam(name = "departmentName", defaultValue="主席团") String departmentName,
                                             @RequestParam(name = "search", defaultValue="") String search,
                                             @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                             @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("minutes_list");
        int recordCount = minutesService.findCountByDepartmentName(departmentName, "%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";
        List<Department> departmentList = new ArrayList<Department>();
        departmentList = departmentService.findAll();
        List<Minutes> minutesList = new ArrayList<Minutes>();
        minutesList = minutesService.findByDepartmentName(departmentName, "%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);

        for (int counter = 0; counter < minutesList.size(); counter++) {
            minutesList.get(counter).setStart_time(minutesList.get(counter).getStart_time().replace("T", " "));
            minutesList.get(counter).setEnd_time(minutesList.get(counter).getEnd_time().replace("T", " "));
        }

        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("departmentName", departmentName);
        modelAndView.addObject("search", search);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("minutesList", minutesList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }
}
