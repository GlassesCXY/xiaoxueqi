package com.example.xxqback.service.impl;

import com.example.xxqback.entity.User;
import com.example.xxqback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void register(User user) {
        userMapper.insertUser(user);
    }

    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
