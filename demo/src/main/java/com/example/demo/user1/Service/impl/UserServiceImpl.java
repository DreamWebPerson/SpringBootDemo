package com.example.demo.user1.Service.impl;

import com.example.demo.user1.Entity.User;
import com.example.demo.user1.Mapper.UserMapper;
import com.example.demo.user1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        return userMapper.queryAllUser();
    }

    @Transactional
    @Override
    public Integer insertUser(List<User> userList) {
            for(int i=0;i<userList.size();i++){
                userMapper.insertUser(userList.get(i));
                int a = 100/0;
            }
        return 0;
    }
}
