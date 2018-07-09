package com.xifdf.controller;

import com.xifdf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login() throws Exception {
        userService.userlog();
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}