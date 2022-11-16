package com.example.user.controller;

import com.example.user.dto.UserDetailDTO;
import com.example.user.model.Page;
import com.example.user.model.User;
import com.example.user.request.UpsertPasswordRequest;
import com.example.user.request.UpsertUser;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserControlller {
    @Autowired
    private UserService userService;

    //Get ALL
    @GetMapping("users/all")
    public List<User> findAll() {
        return userService.findAll();
    }
    // GET http://localhost:8080/api/v1/users (mặc định page = 1, limit = 10)
    @GetMapping("users")
    public Page getPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return userService.getPage(page,limit);
    }
    //GET http://localhost:8080/api/v1/search?name={nameValue}
    @GetMapping("users/search")
    public List<UserDetailDTO> findUserByName(@RequestParam String name){
        return userService.findUserByName(name);
    }
    //GET http://localhost:8080/api/v1/users/{id}
    @GetMapping("users/{id}")
    public UserDetailDTO findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
    //POST http://localhost:8080/api/v1/users
    @PostMapping("users")
    public UserDetailDTO createUser (@RequestBody UpsertUser request){
        return userService.createUser(request);
    }

    //PUT http://localhost:8080/api/v1/users/{id}
    @PutMapping("users/{id}")
    public UserDetailDTO updateUser (@RequestBody UpsertUser request, @PathVariable int id) {
       return userService.updateUser(request,id);
    }
    //DELETE http://localhost:8080/api/v1/users/{id}
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    //PUT http://localhost:8080/api/v1/users/{id}/update-avatar
    @PutMapping("users/{id}/update-avatar")
    public void updateAvatar(@RequestBody UpsertUser request,@PathVariable int id){
        userService.updateAvatar(request,id);
    }

    //PUT http://localhost:8080/api/v1/users/{id}/update-password
    @PutMapping("users/{id}/update-password")
    public void updatePassword(@RequestBody UpsertPasswordRequest request, @PathVariable int id){
        userService.updatePassword(request,id);
    }
    //POST http://localhost:8080/api/v1/users/{id}/fotgot-password
    @PostMapping("users/{id}/fotgot-password")
    public String fotgotPassword(@PathVariable int id){
        return userService.fotgotPassword(id);
    }
}
