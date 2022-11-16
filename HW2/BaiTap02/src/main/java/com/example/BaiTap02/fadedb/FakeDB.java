package com.example.BaiTap02.fadedb;

import com.example.BaiTap02.model.User;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
//private String username;
//private String email;
//private String password;
//private String avatar;
public class FakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"hieu1","1@gmail.com","1234","1"),
            new User(2,"tung","2@gmail.com","2345","2"),
            new User(3,"cong","3@gmail.com","3456","3")
    ));
}
