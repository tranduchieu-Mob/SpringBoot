package com.example.user.service;

import com.example.user.dto.UserDetailDTO;
import com.example.user.exception.NotFoundException;
import com.example.user.model.Page;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.request.UpsertPasswordRequest;
import com.example.user.request.UpsertUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDetailDTO> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    public UserDetailDTO findUserById(int id) {
        if(userRepository.findUserById(id).isPresent()){
            UserDetailDTO userDto = new UserDetailDTO(
                    userRepository.findUserById(id).get().getId(),
                    userRepository.findUserById(id).get().getName(),
                    userRepository.findUserById(id).get().getEmail(),
                    userRepository.findUserById(id).get().getPhone(),
                    userRepository.findUserById(id).get().getAddress(),
                    userRepository.findUserById(id).get().getAvatar()
            );

            return userDto;
        }
        else throw new NotFoundException("Not found exception with " + id);
    }

    public UserDetailDTO createUser(UpsertUser request) {
        UserDetailDTO userDto = new UserDetailDTO(
                userRepository.creatUser(request).getId(),
                userRepository.creatUser(request).getName(),
                userRepository.creatUser(request).getEmail(),
                userRepository.creatUser(request).getPhone(),
                userRepository.creatUser(request).getAddress(),
                userRepository.creatUser(request).getAvatar()
        );
        return userDto;
    }

    public ResponseEntity<Void> deleteUser(int id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public UserDetailDTO updateUser(UpsertUser request,int id) {
        userRepository.updateUser(request,id);
        return findUserById(id);
    }



    public void updateAvatar(UpsertUser request, int id) {
        userRepository.updateAvatar(request,id);
    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        userRepository.updatePassword(request,id);
    }

    public String fotgotPassword(int id) {
        return userRepository.fotgotPassword(id);
    }

    public Page getPage(int page, int limit) {
        return userRepository.getPage(page,limit);
    }




}
