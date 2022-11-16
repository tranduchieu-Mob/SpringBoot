package com.example.course;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
	@Bean
	public Faker faker(){
		return new Faker();
	}
}
