package edu.ncwu.osums.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.entity.Notice;
import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.exception.ParameterException;
import edu.ncwu.osums.exception.ServiceException;
import edu.ncwu.osums.service.DepartmentService;
import edu.ncwu.osums.service.NoticeService;
import edu.ncwu.osums.service.PositionService;
import edu.ncwu.osums.service.RecruitmentService;
import edu.ncwu.osums.service.UserService;
import edu.ncwu.osums.util.FTPUtil;
import edu.ncwu.osums.util.FormatUtil;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/removeByUsername")
    @ResponseBody
    public String removeByUsername(@RequestParam(name = "username") String username) {
        userService.removeByUsername(username);
        FTPUtil.deleteFile(username + ".jpg", "/head portrait/");
        return "success";
    }

    @PostMapping("/changeByUsername")
    @ResponseBody
    public String changeByUsername(@RequestParam(name = "username") String username,
                                   @RequestParam(name = "nickname") String nickname,
                                   @RequestParam(name = "departmentName") String departmentName,
                                   @RequestParam(name = "positionName") String positionName,
                                   HttpServletRequest request) {
        User userInSession = (User)request.getSession().getAttribute("user");
        User user = new User(username, null, nickname, null, null, null, null, null, departmentName, positionName, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        userService.changeByUsername(user);
        return "success";
    }

    @PostMapping("/changePasswordForResetByUsername")
    @ResponseBody
    public String changePasswordForResetByUsername(@RequestParam(name = "username") String username,
                                                   HttpServletRequest request) {
        User userInSession = (User)request.getSession().getAttribute("user");
        User user = new User(username, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        userService.changePasswordForResetByUsername(user);
        return "success";
    }

    @PostMapping("/changeBasicByUsername")
    @ResponseBody
    public String changeBasicByUsername(@RequestParam(name = "username") String username,
                                        @RequestParam(name = "gender") String gender,
                                        @RequestParam(name = "birthday") String birthday,
                                        @RequestParam(name = "major") String major,
                                        @RequestParam(name = "classs") String classs,
                                        @RequestParam(name = "native_place") String nativePlace,
                                        @RequestParam(name = "phone") String phone,
                                        @RequestParam(name = "email") String email,
                                        @RequestParam(name = "qq") String qq,
                                        @RequestParam(name = "hobby") String hobby,
                                        @RequestParam(name = "self_appraisal") String selfAppraisal,
                                        @RequestParam(name = "awards_and_achievements") String awardsAndAchievements,
                                        HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userInSession = (User)session.getAttribute("user");
        User user = new User(username, null, null, gender, birthday, major, classs, nativePlace, null, null, phone, email, qq, hobby, selfAppraisal, awardsAndAchievements, 0, 0, 0, 0, 0, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());
        userService.changeBasicByUsername(user);
        user = userService.findByUsername(username);
        session.setAttribute("user", user);
        return "success";
    }


    @PostMapping("/changePasswordByUsername")
    @ResponseBody
    public String changePasswordByUsername(@RequestParam(name = "username") String username,
                                           @RequestParam(name = "oldPassword") String oldPassword,
                                           @RequestParam(name = "newPassword") String newPassword,
                                           @RequestParam(name = "newPasswordTwice") String newPasswordTwice,
                                           HttpServletRequest request) {
        User userInSession = (User)request.getSession().getAttribute("user");
        User user = new User(username, newPasswordTwice, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, null, null, FormatUtil.getCurrentDate(), userInSession.getNickname());

        try {
            userService.changePasswordByUsername(user, oldPassword, newPassword);
        } catch (ServiceException serviceException) {
            return serviceException.getServiceErrorMessage();
        }

        return "success";
    }

    @GetMapping("/information")
    public ModelAndView information(HttpServletRequest request) {
        User userInSession = (User)request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("user_information");
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/findByUsername")
    @ResponseBody
    public User findByUsername(@RequestParam(name = "username") String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(HttpServletRequest request) {
        User userInSession = (User)request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("management_user");
        List<User> userList = new ArrayList<User>();
        userList = userService.findAllByDepartmentName("%%");
        List<Department> departmentList = new ArrayList<Department>();
        departmentList = departmentService.findAll();
        List<Position> positionList = new ArrayList<Position>();
        positionList = positionService.findAll();
        int recruitmentApplicationCount = recruitmentService.findApplicationCount(userInSession.getDepartment_name());
        Notice notice = noticeService.findContent();
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("positionList", positionList);
        modelAndView.addObject("recruitmentApplicationCount", recruitmentApplicationCount);
        modelAndView.addObject("notice", notice);
        return modelAndView;
    }

    @PostMapping("/findTopEight")
    @ResponseBody
    public Object findTopEight() {
        return userService.findTopEight();
    }

    @PostMapping("/findTopOneByDepartmentName")
    @ResponseBody
    public Object findTopOneByDepartmentName() {
        return userService.findTopOneByDepartmentName();
    }

    @PostMapping("/findAllByDepartmentName")
    @ResponseBody
    public List<User> findAllByDepartmentName(@RequestParam(name = "departmentName") String departmentName) {
        return userService.findAllByDepartmentName("%" + departmentName + "%");
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "remember") String remember,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        try {
            User user = userService.login(username, password);

            if ("true".equals(remember)) {
                Cookie cookieUsername = new Cookie("cookieUsername", String.valueOf(user.getUsername()));
                cookieUsername.setMaxAge(86400);
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("cookiePassword", user.getPassword());
                cookiePassword.setMaxAge(86400);
                response.addCookie(cookiePassword);
            } else {
                Cookie cookieUsername = new Cookie("cookieUsername", String.valueOf(user.getUsername()));
                cookieUsername.setMaxAge(0);
                response.addCookie(cookieUsername);
                Cookie cookiePassword = new Cookie("cookiePassword", user.getPassword());
                cookiePassword.setMaxAge(0);
                response.addCookie(cookiePassword);
            }

            user.setPassword(null);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Position position = positionService.findByPositionName(user.getPosition_name());
            session.setAttribute("position", position);
        } catch (ParameterException parameterException) {
            return parameterException.getParameterErrorField();
        } catch (ServiceException serviceException) {
            return serviceException.getServiceErrorMessage();
        }

        return "success";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/logout";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("headPortrait") MultipartFile headPortrait, @RequestParam("username") String username) {
        FTPUtil.uploadFile(headPortrait, username + ".jpg", "/head portrait/");
        return "redirect:/information";
    }
}
