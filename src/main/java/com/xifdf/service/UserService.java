package com.xifdf.service;

import com.github.pagehelper.PageInfo;
import com.xifdf.pojo.User;

import java.util.List;

public interface UserService {
    void userlog();

    List<User> list();
    //ajax分页
    PageInfo<User> getUsers(int pageNum);

    boolean add(User user);

    void update(User user);

    void delete(User user);

    User getUserById(User user);

    List<User> getUserByName(User user);

    void addTwo();
}
