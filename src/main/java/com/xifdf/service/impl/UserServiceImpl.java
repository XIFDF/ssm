package com.xifdf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xifdf.mapper.UserMapper;
import com.xifdf.pojo.User;
import com.xifdf.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void userlog() {
        System.out.println("denglu");
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public PageInfo<User> getUsers(int pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<User> users = userMapper.list();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
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
        //判断ID是否已经存在
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
    @Override
//    使用事务
    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    public void addTwo(){
        User c1 = new User();
        c1.setName("短的名字");
        c1.setEmail("test");
        c1.setSex("test");
        c1.setTel("test");
        userMapper.add(c1);

        User c2 = new User();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        c2.setEmail("test");
        c2.setSex("test");
        c2.setTel("test");
        userMapper.add(c2);
    }


}
