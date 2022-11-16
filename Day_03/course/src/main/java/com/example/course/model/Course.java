package com.example.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    private int id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private int userId;
}
