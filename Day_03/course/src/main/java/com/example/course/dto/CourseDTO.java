package com.example.course.dto;

import com.example.course.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDTO {
    private int id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User userDTO;
}
