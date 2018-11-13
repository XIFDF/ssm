package com.xifdf.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import com.xifdf.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spittle")
public class SpittleController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/listUser")
    public String listUser(Page page) throws Exception{
        PageHelper.offsetPage(page.getStart(), 8);
        List<User> users = userService.list();
//        int total = (int) new PageInfo<>(users).getTotal();
    //这里使用了jackson来序列化对象，user那边使用的阿里的fastjson
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(users);
        return str;
    }
}
