package com.example.user.service;

import com.example.user.dto.UserDetailDTO;
import com.example.user.dto.UserMapper;
import com.example.user.exception.BadRequestException;
import com.example.user.exception.NotFoundException;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.request.CreateUserRequest;
import com.example.user.request.UpdateAvatarRequest;
import com.example.user.request.UpsertPasswordRequest;
import com.example.user.request.UpsertUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    private FileService fileService;
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    public List<UserDetailDTO> findUserByName(String name) {
//        return userRepository.findByName(name);
//    }
//
//    public UserDetailDTO findUserById(int id) {
//        if(userRepository.findById(id).isPresent()){
//            UserDetailDTO userDto = new UserDetailDTO(
//                    userRepository.findUserById(id).get().getId(),
//                    userRepository.findUserById(id).get().getName(),
//                    userRepository.findUserById(id).get().getEmail(),
//                    userRepository.findUserById(id).get().getPhone(),
//                    userRepository.findUserById(id).get().getAddress(),
//                    userRepository.findUserById(id).get().getAvatar()
//            );
//
//            return userDto;
//        }
//        else throw new NotFoundException("Not found exception with " + id);
//    }
//
//    public UserDetailDTO createUser(UpsertUser request) {
//        UserDetailDTO userDto = new UserDetailDTO(
//                userRepository.creatUser(request).getId(),
//                userRepository.creatUser(request).getName(),
//                userRepository.creatUser(request).getEmail(),
//                userRepository.creatUser(request).getPhone(),
//                userRepository.creatUser(request).getAddress(),
//                userRepository.creatUser(request).getAvatar()
//        );
//        return userDto;
//    }
//
//    public ResponseEntity<Void> deleteUser(int id) {
//        userRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    public UserDetailDTO updateUser(UpsertUser request,int id) {
//        userRepository.updateUser(request,id);
//        return findUserById(id);
//    }
//
//
//
//    public void updateAvatar(UpsertUser request, int id) {
//        userRepository.updateAvatar(request,id);
//    }
//
//    public void updatePassword(UpsertPasswordRequest request, int id) {
//        userRepository.updatePassword(request,id);
//    }
//
//    public String fotgotPassword(int id) {
//        return userRepository.fotgotPassword(id);
//    }
//
//    public Page getPage(int page, int limit) {
//        return userRepository.getPage(page,limit);
//    }
//
//
//    public String uploadFile(int id, MultipartFile file) {
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NotFoundException("Not found user with id = " + id);
//        });
//
//        return fileService.uploadFile(id, file);
//    }
//
//    public byte[] readFile(int id, String fileId) {
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NotFoundException("Not found user with id = " + id);
//        });
//
//        return fileService.readFile(id, fileId);
//    }
//
//    public List<String> getFiles(int id) {
//        User user = userRepository.findById(id).orElseThrow(() -> {
//            throw new NotFoundException("Not found user with id = " + id);
//        });
//
//        return fileService.GetFiles(id);
//    }
//
//    public void deleteFile(int id, String fileId) {
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NotFoundException("Not found user with id = " + id);
//        });
//
//        fileService.deleteFile(id, fileId);
//    }

    private final UserRepository userRepository;
    private final FileService fileService;

    // L???y danh s??ch user ??? d???ng DTO
    public List<UserDetailDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    // T??m ki???m user theo t??n
    public List<UserDetailDTO> searchUser(String name) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    // L???y th??ng tin c???a user theo id
    public UserDetailDTO getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        return UserMapper.toUserDto(user);
    }

    // X??a user
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        userRepository.deleteById(user.getId());
    }

    // T???o user m???i
    public UserDetailDTO createUser(CreateUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email = " + request.getEmail() + " is existed");
        }

        Random rd = new Random();
        User user = new User();
        user.setId(rd.nextInt(100));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return UserMapper.toUserDto(user);
    }

    // C???p nh???t th??ng tin c???a user
    public UserDetailDTO updateUser(int id, UpsertUser request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        return UserMapper.toUserDto(user);
    }

    // C???p nh???t password m???i
    public void updatePassword(int id, UpsertPasswordRequest request) {
        // Ki???m tra c?? t???n t???i hay kh??ng
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        // Ki???m tra oldPassword c?? ????ng kh??ng
        if (!user.getPassword().equals(request.getOldPassword())) {
            throw new BadRequestException("old password is incorrect!");
        }

        // Ki???m tra oldPassword c?? = newPassword kh??ng
        if (request.getNewPassword().equals(request.getOldPassword())) {
            throw new BadRequestException("old password and new password cannot be the same!");
        }

        // C???p nh???t newPassword cho user t????ng ???ng
        user.setPassword(request.getNewPassword());
    }

    // Qu??n m???t kh???u
    public String forgotPassword(int id) {
        // Ki???m tra user c?? t???n t???i hay kh??ng
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });
        // Random chu???i password m???i cho user (100 -> 999)
        Random rd = new Random();
        String newPassword = String.valueOf(rd.nextInt(900) + 100);

        // L???y th??ng tin c???a user v?? ?????t l???i password m???i cho user
        user.setPassword(newPassword);

        // Tr??? v??? th??ng tin password m???i
        return newPassword;
    }

    public String uploadFile(int id, MultipartFile file) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        return fileService.uploadFile(id, file);
    }

    public byte[] readFile(int id, String fileId) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        return fileService.readFile(id, fileId);
    }

    public List<String> getFiles(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        return fileService.GetFiles(id);
    }

    public void deleteFile(int id, String fileId) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        fileService.deleteFile(id, fileId);
    }

    public void updateAvatar(int id, UpdateAvatarRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with id = " + id);
        });

        user.setAvatar(request.getAvatar());
    }
}
