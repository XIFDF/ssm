package com.xifdf.controller;

import com.xifdf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class DebugController {
    @Resource
    private UserService userService;

    @RequestMapping("/debug")
    public String login() throws Exception {
        System.out.println("debug");
        return "hello" ;
    }
}
