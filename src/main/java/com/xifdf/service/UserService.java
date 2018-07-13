package com.xifdf.service;

import com.xifdf.pojo.User;

import java.util.List;

public interface UserService {
    void userlog();

    List<User> list();

    boolean insert(User user);

    void update(User user);

    void delete(User user);
}
