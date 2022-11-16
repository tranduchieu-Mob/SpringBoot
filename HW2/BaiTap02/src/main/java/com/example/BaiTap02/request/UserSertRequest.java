package com.example.BaiTap02.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSertRequest {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 4,message = "Length password musst greater4")
    private String password;


//    private String email;
//    private String avatar;
}
