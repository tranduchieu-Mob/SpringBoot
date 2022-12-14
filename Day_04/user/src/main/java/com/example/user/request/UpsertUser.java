package com.example.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpsertUser {
    private String name;
    private String phone;
    private String address;
}
