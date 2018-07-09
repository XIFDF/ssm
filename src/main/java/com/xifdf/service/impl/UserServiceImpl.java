package com.xifdf.service.impl;

import com.xifdf.mapper.UserMapper;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public void userlog() {
        System.out.println("denglu");
    }
    @Override
    public boolean insert(User user) {
        return true;
    }
}
