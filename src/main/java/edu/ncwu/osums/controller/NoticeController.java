package edu.ncwu.osums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.util.FormatUtil;

@Controller
@RequestMapping("/notice")
@SessionAttributes("user")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/changeContent")
    @ResponseBody
    public String changeContent(@RequestParam(name = "content") String content, @ModelAttribute("user") User userInSession) {
        Notice notice = new Notice(content, FormatUtil.getCurrentDate(), userInSession.getNickname());
        noticeService.changeContent(notice);
        return "success";
    }
}
