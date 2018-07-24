package com.xifdf.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import com.xifdf.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
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
    @RequestMapping("adduser")
    public ModelAndView adduser(User user){
        if(userService.add(user)) {
            ModelAndView mav = new ModelAndView("redirect:/listUser");
            return mav;
        }
        else{
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addUserfail");
            return mav;
        }
    }
    @RequestMapping("getuserbyname")
    public ModelAndView getuser(Page page, User user){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 8);
        List<User> users = userService.getUserByName(user);
        int total = (int) new PageInfo<>(users).getTotal();
        page.caculateLast(total);
        mav.addObject("users", users);
        mav.setViewName("listUser");
        return mav;
    }

//    AXAJ
    @ResponseBody
    @RequestMapping("/submitUser")
    public String submitUser(@RequestBody User user) {
        System.out.println("SSM接受到浏览器提交的json，并转换为User对象:" + user);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/getOneUser")
    public String getOneUser() {
        User c = new User();
        c.setId(666);
        c.setName("用户666");
        c.setEmail("用户邮箱test");
        c.setSex("用户性别test");
        c.setTel("用户电话test");
        JSONObject json= new JSONObject();
        json.put("user", JSONObject.toJSON(c));
        return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyUser")
    public String getManyCategory() {
        List<User> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User c = new User();
            c.setId(i);
            c.setName("用户名称:"+i);
            c.setEmail("用户邮箱test"+i);
            c.setSex("用户性别test"+i);
            c.setTel("用户电话test"+i);
            cs.add(c);
        }

        return JSONObject.toJSON(cs).toString();
    }

}
