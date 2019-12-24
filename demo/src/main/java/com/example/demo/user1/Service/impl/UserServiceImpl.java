package com.example.demo.user1.Service.impl;

import com.example.demo.user1.Entity.User;
import com.example.demo.user1.Mapper.UserMapper;
import com.example.demo.user1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        return userMapper.queryUser();
    }
}
