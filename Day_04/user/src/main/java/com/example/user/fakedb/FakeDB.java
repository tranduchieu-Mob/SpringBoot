package com.example.user.fakedb;

import com.example.user.model.User;

import java.util.ArrayList;
import java.util.List;

//private int id;
//private String name;
//private String email;
//private String phone;
//private String address;
//private String avatar;
public class FakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1, "hieu","123", "hieu.gmail.com", "01","BacNinh",null),
            new User(2, "tung","456", "tung@gmail.com", "02","BacNinh",null),
            new User(3, "tuananh","789", "tuananh@gmail.com", "03","HaiDuong",null)
    ));
}
