package edu.ncwu.osums.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.ncwu.osums.entity.Feedback;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.service.FeedbackService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.util.FormatUtil;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam(name = "feedbackContent") String feedbackContent, @RequestParam(name = "type") String type) {
        Feedback feedback = new Feedback(feedbackContent, type, FormatUtil.getCurrentDate());
        feedbackService.create(feedback);
        return "success";
    }

    @PostMapping("/removeById")
    @ResponseBody
    public String removeById(@RequestParam(name = "id") int id) {
        feedbackService.removeById(id);
        return "success";
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("feedback_list");
        List<Feedback> feedbackList = new ArrayList<Feedback>();
        feedbackList = feedbackService.findAll();
        int feedbackCount = feedbackService.findCount();
        Notice notice = noticeService.findContent();
        modelAndView.addObject("feedbackList", feedbackList);
        modelAndView.addObject("feedbackCount", feedbackCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/findForDiagramByType")
    @ResponseBody
    public Object findForDiagramByType() {
        Object[][] objectss = {
                {"生活", feedbackService.findCountByType("生活")},
                {"活动", feedbackService.findCountByType("活动")},
                {"建议", feedbackService.findCountByType("建议")},
                {"学习", feedbackService.findCountByType("学习")},
                {"其它", feedbackService.findCountByType("其它")}};

        return objectss;
    }
}
