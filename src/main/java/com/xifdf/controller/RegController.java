package com.xifdf.controller;

import com.xifdf.mapper.UserMapper;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegController {
    @Resource private UserService userService;
//  注册业务
    @RequestMapping(value = "registerprocess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") User user){
        if(userService.add(user)) {
            ModelAndView mav = new ModelAndView("regsuccess");
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("register");
            return mav;
        }
    }
}
