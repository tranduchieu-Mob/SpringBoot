package com.example.BaiTap02.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSertRequest {
    private String username;
    private String email;
    private String password;
    private String avatar;
}
