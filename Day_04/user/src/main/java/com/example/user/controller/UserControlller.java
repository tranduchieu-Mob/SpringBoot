package com.example.user.controller;

import com.example.user.dto.UserDetailDTO;
import com.example.user.model.Page;
import com.example.user.model.User;
import com.example.user.request.CreateUserRequest;
import com.example.user.request.UpsertPasswordRequest;
import com.example.user.request.UpsertUser;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.channels.MulticastChannel;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UserControlller {
    @Autowired
    private final UserService userService;

//    //Get ALL
//    @GetMapping("users/all")
//    public List<User> findAll() {
//        return userService.findAll();
//    }
//    // GET http://localhost:8080/api/v1/users (mặc định page = 1, limit = 10)
//    @GetMapping("users")
//    public Page getPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
//        return userService.getPage(page,limit);
//    }
//    //GET http://localhost:8080/api/v1/search?name={nameValue}
//    @GetMapping("users/search")
//    public List<UserDetailDTO> findUserByName(@RequestParam String name){
//        return userService.findUserByName(name);
//    }
//    //GET http://localhost:8080/api/v1/users/{id}
//    @GetMapping("users/{id}")
//    public UserDetailDTO findUserById(@PathVariable int id) {
//        return userService.findUserById(id);
//    }
//    //POST http://localhost:8080/api/v1/users
//    @PostMapping("users")
//    public UserDetailDTO createUser (@RequestBody UpsertUser request){
//        return userService.createUser(request);
//    }
//
//    //PUT http://localhost:8080/api/v1/users/{id}
//    @PutMapping("users/{id}")
//    public UserDetailDTO updateUser (@RequestBody UpsertUser request, @PathVariable int id) {
//       return userService.updateUser(request,id);
//    }
//    //DELETE http://localhost:8080/api/v1/users/{id}
//    @DeleteMapping("users/{id}")
//    public void deleteUser(@PathVariable int id){
//        userService.deleteUser(id);
//    }
//
//    //PUT http://localhost:8080/api/v1/users/{id}/update-avatar
//    @PutMapping("users/{id}/update-avatar")
//    public void updateAvatar(@RequestBody UpsertUser request,@PathVariable int id){
//        userService.updateAvatar(request,id);
//    }
//
//    //PUT http://localhost:8080/api/v1/users/{id}/update-password
//    @PutMapping("users/{id}/update-password")
//    public void updatePassword(@RequestBody UpsertPasswordRequest request, @PathVariable int id){
//        userService.updatePassword(request, id);
//    }
//    //POST http://localhost:8080/api/v1/users/{id}/fotgot-password
//    @PostMapping("users/{id}/fotgot-password")
//    public String fotgotPassword(@PathVariable int id){
//        return userService.forgotPassword(id);
//    }

    // Lấy danh sách user
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<UserDetailDTO> userDtos = userService.getUsers();
        return ResponseEntity.ok(userDtos);
    }

    // Tìm kiếm user theo tên
    @GetMapping("/users/search")
    public ResponseEntity<?> searchUser(@RequestParam String name) {
        List<UserDetailDTO> userDtos = userService.searchUser(name);
        return ResponseEntity.ok(userDtos);
    }

    // Lấy chi tiết user theo id
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDetailDTO userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // Tạo user mới
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {
        UserDetailDTO userDto = userService.createUser(request);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    // Xóa user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Cập nhật thông tin user
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,
                                        @RequestBody UpsertUser request) {
        UserDetailDTO userDto = userService.updateUser(id, request);
        return ResponseEntity.ok(userDto);
    }

    // Cập nhật mật khẩu mới
    @PutMapping("/users/{id}/update-password")
    public ResponseEntity<?> updatePassword(@PathVariable int id,
                                            @RequestBody UpsertPasswordRequest request) {
        userService.updatePassword(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Quên mật khẩu
    @PostMapping("/users/{id}/forgot-password")
    public ResponseEntity<?> updatePassword(@PathVariable int id) {
        String password = userService.forgotPassword(id);
        return ResponseEntity.ok(password);
    }

    //Upload ảnh
    //C1 : Lưu trc tiếp vào database
    //C2 : Lưu ảnh vào 1 folder ở server -> lưu path image vào database
    //Trong trường hợp không có database : lưu ảnh vào 1 folder ở server
    //-> sử dụng userID, file Id để tìm kiếm trong folder

    //uploads
    //1, 2, 3 : folder tương ứng với userID
    //Trong folder userId là các ảnh mà user đó upload

    //Update file
    @PostMapping("users/{id}/files")
    public ResponseEntity<?> uploadFile(@PathVariable int id, @ModelAttribute("file") MultipartFile file){
        String filePath = userService.uploadFile(id, file);
        return ResponseEntity.ok(filePath);
    }

    //xem ảnh
    @GetMapping("users/{id}/files/{fileID}")
    public ResponseEntity<?> readFile(@PathVariable int id, @PathVariable String fileId) {
        byte[] bytes = userService.readFile(id, fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    //Lấy danh sách ảnh
    @GetMapping("users/{id}/files")
    public ResponseEntity<?> getFiles(@PathVariable int id){
        List<String> files = userService.getFiles(id);
        return ResponseEntity.ok(files);//200
    }

    //Xóa ảnh
    @DeleteMapping("users/{id}/files/{fileID}")
    public ResponseEntity<?> deleteFile(@PathVariable int id, @PathVariable String fileId) {
        userService.deleteFile(id, fileId);
        return ResponseEntity.noContent().build();//204
    }
}
