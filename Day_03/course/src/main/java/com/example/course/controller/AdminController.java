package com.example.course.controller;

import com.example.course.dto.CourseDTO;
import com.example.course.model.Course;
import com.example.course.request.UpsertCourse;
import com.example.course.service.AdminService;
import com.example.course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    @GetMapping("/courses")
    public List<Course> findAllCourses () {
        return adminService.findAllCourse();
    }

    @GetMapping("/courses/{id}")
    public CourseDTO findDetailCourse(@PathVariable int id) {
        return userService.findByid(id);
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody @Valid UpsertCourse upsertCourse) {
        return adminService.save(upsertCourse);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse (@RequestBody UpsertCourse upsertCourse,
                                @PathVariable int id) {
        return adminService.updateCourse(upsertCourse, id);
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        return adminService.deleteCourse(id);
    }
}
