package com.example.user.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDetailDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String avatar;

}
