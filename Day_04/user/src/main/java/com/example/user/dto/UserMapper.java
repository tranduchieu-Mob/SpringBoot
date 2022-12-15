package com.example.user.dto;

import com.example.user.model.User;

public class UserMapper {
    public static UserDetailDTO toUserDto(User user) {
        UserDetailDTO userDto = new UserDetailDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setAvatar(user.getAvatar());

        return userDto;
    }
}
