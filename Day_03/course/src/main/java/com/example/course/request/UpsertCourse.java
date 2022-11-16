package com.example.course.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourse {
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 50, message = "Độ dài kí tự > 50")
    private String description;
    @NotBlank
    private String type;
    private List<String> topics;
    private String thumbnail;
    private Integer userId;
}
