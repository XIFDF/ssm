package com.xifdf.mapper;

import com.xifdf.pojo.User;

import java.util.List;

public interface UserMapper {

    void add(User user);

    List<User> list();

    int update(User user);

    void delete(int id);

    User getUserById(int id);

    List<User> getUserByName(String name);
}
