package com.example.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UpsertPasswordRequest {
    private String oldPassword;
    private String newPassword;
}
