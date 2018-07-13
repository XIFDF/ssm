package com.xifdf.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import com.xifdf.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Controller
public class UserController {
    @Resource private UserService userService;

    @RequestMapping("listUser")
    public ModelAndView listUser(Page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),8);
        List<User> users = userService.list();
        int total = (int) new PageInfo<>(users).getTotal();

        page.caculateLast(total);
        //转发参数
        mav.addObject("users", users);
        //jsp路径
        mav.setViewName("listUser");
        return mav;
    }

    @RequestMapping("updateuser")
    public ModelAndView updateuser(User user, HttpServletRequest request){
        userService.update(user);
        String current = "";
        try {
            URL url = new URL(request.getHeader("Referer"));
            current = url.getQuery();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("redirect:/listUser?"+current);
        return mav;
    }
    @RequestMapping("deleteuser")
    public ModelAndView deleteuser(User user){
        userService.delete(user);
        ModelAndView mav = new ModelAndView("redirect:/listUser");
        return mav;
    }
}
