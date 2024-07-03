package com.example.xxqback.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.xxqback.entity.Result;
import com.example.xxqback.entity.User;
import com.example.xxqback.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return Result.error("Username already exists");
        }
        userService.register(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody JSONObject param) {
        String username = param.getString("username");
        String password = param.getString("password");
        User user = userService.login(username, password);
        if (user == null) {
            return Result.error("Invalid username or password");
        }
        return Result.success();
    }
}