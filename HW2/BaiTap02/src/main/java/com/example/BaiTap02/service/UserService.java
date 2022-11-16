package com.example.BaiTap02.service;

import com.example.BaiTap02.exception.NotFoundException;
import com.example.BaiTap02.model.User;
import com.example.BaiTap02.repository.UserRepository;
import com.example.BaiTap02.request.UserSertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
//    public List<User> getUsers(){
//        return userRepository.findAll();
//    }

    public String getUser(UserSertRequest request) {
        if (userRepository.findByRequest(request).isEmpty()) throw new NotFoundException("username hoặc password sai");
        User user = userRepository.findByRequest(request).get();
        return "username: " + user.getUsername()
                + "\n email: " + user.getEmail()
                + "\n avatar: " + user.getAvatar();
    }
}
