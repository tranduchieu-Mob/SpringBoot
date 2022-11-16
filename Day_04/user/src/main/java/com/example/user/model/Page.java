package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Page {
    private List<User> list;
    private int currentPage;
    private int size;
    private int totalPage;
}
