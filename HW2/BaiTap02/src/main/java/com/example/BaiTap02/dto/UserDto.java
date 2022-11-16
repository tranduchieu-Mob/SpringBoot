package com.example.BaiTap02.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String username;
    private String email;
    private String avatar;
}