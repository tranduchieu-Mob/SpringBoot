package com.example.BaiTap02.controller;

import com.example.BaiTap02.request.UserSertRequest;
import com.example.BaiTap02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("login")
//    public List<User> getUsers(){
//        return userService.getUsers();
//    }

    @PostMapping("login")
    public String getUser(@RequestBody UserSertRequest request){
        return userService.getUser(request);
    }
}
