package com.example.BaiTap02.repository;

import com.example.BaiTap02.fadedb.FakeDB;
import com.example.BaiTap02.model.User;
import com.example.BaiTap02.request.UserSertRequest;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> findAll(){
        return FakeDB.users;
    }
    public Optional<User> findByRequest(UserSertRequest request){
        return FakeDB.users
                .stream()
                .filter(user -> (user.getUsername().equals(request.getUsername())
                        && user.getPassword().equals(request.getPassword())))
                .findFirst();
    }
}
