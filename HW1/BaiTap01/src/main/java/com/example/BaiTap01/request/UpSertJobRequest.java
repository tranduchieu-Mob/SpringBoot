package com.example.BaiTap01.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpSertJobRequest {
    private String title;
    private String description;
    private String location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;
}
