package com.example.course.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
}
