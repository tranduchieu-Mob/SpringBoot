package com.example.course;

import com.example.course.controller.UserController;
import com.example.course.dto.CourseDTO;
import com.example.course.model.Course;
import com.example.course.model.User;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseApplicationTests {
	@Autowired
	private UserRepository userRepository;
	private CourseRepository courseRepository;
	private UserController userController;
	@Test
	void show_users() {
		List<User> userList = userRepository.findAll();
		userList.forEach(System.out::println);
	}
	@Test
	void show_course() {
		List<Course> courseList = courseRepository.findAll();
		courseList.forEach(System.out::println);
	}

	@Test
	void show_CourseDTO() {
		CourseDTO courseDTO = userController.findCourseById(3);
		System.out.println(courseDTO.toString());
	}
}
