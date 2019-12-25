package com.example.demo.user1.Mapper;

import com.example.demo.user1.Entity.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有的用户信息
     * */
    List<User> queryAllUser();

    /**
     * 插入用户
     * */
    Integer insertUser(User user);
}
