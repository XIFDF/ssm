package com.xifdf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/spittle")
public class SpittleController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/listUser")
    public String listUser(@RequestParam("currentPage") int currentPage) throws Exception{
        PageInfo<User> userPageInfo =userService.getUsers(currentPage);
        //这里使用了jackson来序列化对象，user那边使用的阿里的fastjson
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(userPageInfo);
        return jsonStr;
    }
}
