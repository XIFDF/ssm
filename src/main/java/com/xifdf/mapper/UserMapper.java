package com.xifdf.mapper;

import com.xifdf.pojo.User;

import java.util.List;

public interface UserMapper {

//    持久层映射接口
//    @author xifdf

    boolean insert(User user);

    List<User> list();

    int update(User user);

    void delete(int id);
}
