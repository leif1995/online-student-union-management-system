package edu.ncwu.osums.controller;

import java.text.ParseException;
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

import edu.ncwu.osums.entity.Activity;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.ActivityService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.util.FormatUtil;
import edu.ncwu.osums.util.StringUtil;

@Controller
@RequestMapping("/activity")
@SessionAttributes("user")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "activityName") String activityName,
                         @RequestParam(name = "activityDate") String activityDate,
                         @RequestParam(name = "activityPlace") String activityPlace,
                         @ModelAttribute("user") User userInSession) {
        Activity activity = new Activity(activityName, activityDate, activityPlace, 1, FormatUtil.getCurrentDate(), userInSession.getNickname(), FormatUtil.getCurrentDate(), userInSession.getNickname());
        activityService.create(activity);
        return "success";
    }

    @PostMapping("/removeByIds")
    @ResponseBody
    public String removeByIds(@RequestParam(name = "ids") String ids) {
        ids = "(" + ids.substring(0, ids.length() - 2) + ")";
        activityService.removeByIds(ids);
        return "success";
    }

    @PostMapping("/changeStatusForRemoveByIds")
    @ResponseBody
    public String changeStatusForRemoveByIds(@RequestParam(name = "ids") String ids, @ModelAttribute("user") User userInSession) {
        ids = "(" + ids.substring(0, ids.length() - 2) + ")";
        activityService.changeStatusForRemoveByIds(ids, FormatUtil.getCurrentDate(), userInSession.getNickname());
        return "success";
    }

    @PostMapping("/changeById")
    @ResponseBody
    public String changeById(@RequestParam(name = "id") int id,
                             @RequestParam(name = "activityName") String activityName,
                             @RequestParam(name = "activityDate") String activityDate,
                             @RequestParam(name = "activityPlace") String activityPlace,
                             @ModelAttribute("user") User userInSession) {
        Activity activity = new Activity(activityName, activityDate, activityPlace, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        activity.setId(id);
        activityService.changeById(activity);
        return "success";
    }

    @GetMapping("/findActive")
    @ResponseBody
    public ModelAndView findActive(@RequestParam(name = "search", defaultValue="") String search,
                                   @RequestParam(name = "currentPage", defaultValue="1") String currentPage,
                                   @ModelAttribute("user") User userInSession) {
        ModelAndView modelAndView = new ModelAndView("activity_active");
        int recordCount = activityService.findActiveCount("%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";

        for (Activity activity : activityService.findActiveForChangeAutomaticallyById()) {
            try {
                if (FormatUtil.getDateFromString(FormatUtil.getCurrentDate()).after(FormatUtil.getDateFromString(activity.getActivity_date()))) {
                    activityService.changeAutomaticallyById(activity.getId());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Activity> activityList = new ArrayList<Activity>();
        activityList = activityService.findActive("%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = activityService.findActiveCount("%%");
        int recordCompletedCount = activityService.findCompletedCount("%%");
        int recordOverdueCount = activityService.findOverdueCount("%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("activityList", activityList);
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
        ModelAndView modelAndView = new ModelAndView("activity_completed");
        int recordCount = activityService.findCompletedCount("%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";

        for (Activity activity : activityService.findActiveForChangeAutomaticallyById()) {
            try {
                if (FormatUtil.getDateFromString(FormatUtil.getCurrentDate()).after(FormatUtil.getDateFromString(activity.getActivity_date()))) {
                    activityService.changeAutomaticallyById(activity.getId());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Activity> activityList = new ArrayList<Activity>();
        activityList = activityService.findCompleted("%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = activityService.findActiveCount("%%");
        int recordCompletedCount = activityService.findCompletedCount("%%");
        int recordOverdueCount = activityService.findOverdueCount("%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("activityList", activityList);
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
        ModelAndView modelAndView = new ModelAndView("activity_overdue");
        int recordCount = activityService.findOverdueCount("%" + search + "%");
        int pageCount = (int)Math.ceil((double)recordCount / 7);
        pageCount = pageCount == 0 ? 1 : pageCount;
        currentPage = StringUtil.isNumeric(currentPage) ? Integer.valueOf(currentPage) > pageCount ? String.valueOf(pageCount) : Integer.valueOf(currentPage) < 1 ? "1" : currentPage : "1";

        for (Activity activity : activityService.findActiveForChangeAutomaticallyById()) {
            try {
                if (FormatUtil.getDateFromString(FormatUtil.getCurrentDate()).after(FormatUtil.getDateFromString(activity.getActivity_date()))) {
                    activityService.changeAutomaticallyById(activity.getId());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Activity> activityList = new ArrayList<Activity>();
        activityList = activityService.findOverdue("%" + search + "%", (Integer.valueOf(currentPage) - 1) * 7);
        int recordActiveCount = activityService.findActiveCount("%%");
        int recordCompletedCount = activityService.findCompletedCount("%%");
        int recordOverdueCount = activityService.findOverdueCount("%%");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("search", search);
        modelAndView.addObject("activityList", activityList);
        modelAndView.addObject("currentPage", currentPage);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("recordActiveCount", recordActiveCount);
        modelAndView.addObject("recordCompletedCount", recordCompletedCount);
        modelAndView.addObject("recordOverdueCount", recordOverdueCount);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }
}
