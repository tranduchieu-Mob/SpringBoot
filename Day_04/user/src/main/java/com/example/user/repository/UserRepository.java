package com.example.user.repository;

import com.example.user.dto.UserDetailDTO;
import com.example.user.exception.BadRequestException;
import com.example.user.exception.NotFoundException;
import com.example.user.fakedb.FakeDB;
import com.example.user.model.Page;
import com.example.user.model.User;
import com.example.user.request.UpsertPasswordRequest;
import com.example.user.request.UpsertUser;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
//    private List<User> users;

    public List<User> findAll(){
        return FakeDB.users;
    }

//    public List<UserDetailDTO> findUserByName(String name) {
//        List<UserDetailDTO> result = new ArrayList<>();
//        for(User user : FakeDB.users){
//            if(findName(user.getName()).equals(name)){
//                UserDetailDTO userDto = new UserDetailDTO(
//                        user.getId(),
//                        user.getName(),
//                        user.getEmail(),
//                        user.getPhone(),
//                        user.getAddress(),
//                        user.getAvatar()
//                );
//                result.add(userDto);
//            }
//        }
//        return result;
//    }
//
//    private String findName(String name){
//        String[] strings = name.split(" ");
//        return strings[strings.length -1].trim().toLowerCase();
//    }
//
//    public Optional<User> findUserById(int id) {
//        return FakeDB.users
//                .stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
//    }
//
//    public User creatUser(UpsertUser request) {
//        Random rd = new Random();
//        int id;
//        do {
//            id = rd.nextInt(200);
//        }while (getAllID().contains(id));
//        User user = new User(
//                id,
//                request.getName(),
//                request.getEmail(),
//                request.getPhone(),
//                request.getAddress(),
//                request.getAvatar(),
//                request.getPassword()
//        );
//        FakeDB.users.add(user);
//        return user;
//    }
//
//    private List<Integer> getAllID(){
//        List<Integer> list = new ArrayList<>();
//        for(User user : FakeDB.users){
//            list.add(user.getId());
//        }
//        return list;
//    }
//
//    public void updateUser(UpsertUser request, int id) {
//        User user = findUserById(id).orElseThrow(()->{
//            throw new NotFoundException("Not found exception with " + id);
//        });
//        user.setName(request.getName());
//        user.setAddress(request.getAddress());
//        user.setPhone(request.getPhone());
//    }
//
//
//    public void deleteById(int id) {
//        FakeDB.users.removeIf(user -> user.getId() == id);
//    }
//
//    public void updateAvatar(UpsertUser request, int id) {
//        if(findUserById(id).isPresent()){
//            for(User user1 : FakeDB.users){
//                if(user1.getId()==id){
//                    user1.setAvatar(request.getAvatar());
//                }
//            }
//        }
//        else throw new NotFoundException("Not found exception with " + id);
//
//    }
//
//    public void updatePassword(UpsertPasswordRequest request, int id) {
//        User user = findUserById(id).orElseThrow(()->{
//            throw new NotFoundException("Not found exception with " + id);
//        });
//        if(!request.getOldPassword().equals(user.getPassword()))
//            throw new NotFoundException("Mật khẩu cũ không chính xác");
//        if (request.getOldPassword().equals(request.getNewPassword()))
//            throw new BadRequestException("Mật khẩu mới giống mật khẩu cũ ");
//        for(User user1 : FakeDB.users){
//            if(user1.getId()==id){
//                user.setPassword(request.getNewPassword());
//            }
//        }
//    }
//    public String fotgotPassword(int id) {
//        User user = findUserById(id).orElseThrow(()->{
//            throw new NotFoundException("Not found exception with " + id);
//        });
//        user.setPassword(user.getPassword()+'1');
//        return user.getPassword();
//    }
//
//    public Page getPage(int page, int limit) {
//        int totalPage = (FakeDB.users.size()/limit) + 1;
//        int size = limit;
//        int currentPage = page;
//        int n = (page-1)*limit;
//        List<User> list = new ArrayList<>();
//        while (n < Math.min(FakeDB.users.size()-(page-1)*limit,limit)){
//            list.add(FakeDB.users.get(n));
//            n++;
//        }
//        return new Page(list,currentPage,size,totalPage);
//    }
public Optional<User> findById(int id) {
    return FakeDB.users
            .stream()
            .filter(user -> user.getId() == id)
            .findFirst();
}

    public Optional<User> findByEmail(String email) {
        return FakeDB.users
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public void deleteById(int id) {
        FakeDB.users.removeIf(user -> user.getId() == id);
    }

    public void save(User user) {
        FakeDB.users.add(user);
    }

}


