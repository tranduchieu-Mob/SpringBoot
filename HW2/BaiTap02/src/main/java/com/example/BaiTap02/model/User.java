package com.example.BaiTap02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String avatar;
}
