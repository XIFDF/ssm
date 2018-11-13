package com.xifdf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//用于页面之间的跳转
@Controller
public class PageController {

    @RequestMapping("signin")
    public ModelAndView login() throws Exception{
        ModelAndView mav = new ModelAndView("signin");
        return mav;
    }

    @RequestMapping("register")
    public ModelAndView register() throws Exception{
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }

    @RequestMapping("index")
    public ModelAndView toMainview() throws Exception{
        ModelAndView mav = new ModelAndView("testpage");
        return mav;
    }

    @RequestMapping(value = "spittle", method = RequestMethod.GET)
    public String toSpittle() {
        return "spittle";
    }
}
