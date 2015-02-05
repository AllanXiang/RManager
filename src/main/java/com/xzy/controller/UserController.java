package com.xzy.controller;

import com.xzy.model.Report;
import com.xzy.model.User;
import com.xzy.service.ReportService;
import com.xzy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xzy on 2015-01-08 8:52 PM.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String auth(HttpSession session, @RequestParam("user") String userName, @RequestParam("pw") String userPwd){
        User user = userService.getUser(userName, userPwd);
        int type = -1;
        if(user!=null){
            type = user.getUserType();
        }
        if(type == -1){
            return "loginfail";
        }else if(type == 0){
            session.setAttribute("user", user);
            return "redirect:/dashboard";
        }else{
            session.setAttribute("user", user);
            return "redirect:/guest";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }


    @Resource
    private ReportService reportService;
    @RequestMapping(value = "/statistics")
    public String statistics(Model model){
        List<Report> reports = this.reportService.getReportList();
        model.addAttribute("reports", reports);
        return "statistics";
    }
}
