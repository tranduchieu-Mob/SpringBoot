package com.example.course.controller;

import com.example.course.dto.CourseDTO;
import com.example.course.model.Course;
import com.example.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Course> findAll(
            @Valid @RequestParam(value = "type", required = false) String typeValue,
            @RequestParam(value = "name", required = false) String nameValue,
            @RequestParam(value = "topic", required = false) String topicValue)
    {
        return userService.findAll(typeValue, nameValue, topicValue);
    }

    @GetMapping("/{id}")
    public CourseDTO findCourseById(@PathVariable int id) {
        return userService.findByid(id);
    }
}