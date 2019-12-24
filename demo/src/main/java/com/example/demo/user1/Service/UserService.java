package com.example.demo.user1.Service;

import com.example.demo.user1.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 查询所有的用户信息
     * */
    List<User> queryUser();
}
