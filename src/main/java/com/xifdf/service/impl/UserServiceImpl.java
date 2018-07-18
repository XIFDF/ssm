package com.xifdf.service.impl;

import com.xifdf.mapper.UserMapper;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public void userlog() {
        System.out.println("denglu");
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
    @Override
    public void update(User user) {
        userMapper.update(user);
    }
    @Override
    public void delete(User user){
        userMapper.delete(user.getId());
    }
    @Override
    public boolean add(User user) {
        if(userMapper.getUserById(user.getId()) == null){
            userMapper.add(user);
            return true;
        }
        else return false;
    }
    @Override
    public User getUserById(User user) {
        return userMapper.getUserById(user.getId());
    }
    @Override
    public List<User> getUserByName(User user) {
        return userMapper.getUserByName(user.getName());
    }
}
