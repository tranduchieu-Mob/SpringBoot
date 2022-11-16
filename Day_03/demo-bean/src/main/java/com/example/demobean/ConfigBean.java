package com.example.demobean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {
    @Bean("student3")
    public Student createStudent(){
        return new Student("Nguyễn Kim Công","cong@gmail.com");
    }
}
