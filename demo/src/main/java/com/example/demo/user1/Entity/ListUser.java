package com.example.demo.user1.Entity;

import java.io.Serializable;
import java.util.List;

public class ListUser implements Serializable {

    List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
