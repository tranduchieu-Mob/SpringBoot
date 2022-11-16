package com.example.demobean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class DemoBeanApplication {
	//Tạo bean bằng cách dấu anotation lên class :
	//Controller, RestController, Service, Repository, ...
	//-> Tạo ra 1 đối tượng duy nhất (singleton pattern) -> Được đưa vào application context để quản lý
	//-> Khi muốn sử dụng 1bean (inject bean)
	//1. Sử dụng autowired
	//2. Sử dụng contructor (recommened)
	//3. Sử dụng setter


	//Tạo bean bằng cách dấu anotation lên method
	//@Bean -> @Configuration, @SpringBootApplication
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoBeanApplication.class, args);

		User user = context.getBean(User.class);
		user.hello();

//		Student student = context.getBean(Student.class);
//		student.showInfo();

		Student student1 =context.getBean("student1", Student.class);
		student1.showInfo();
		student1.showVehicle();

		Student student2 =context.getBean("student2", Student.class);
		student2.showInfo();

		Student student3 =context.getBean("student3", Student.class);
		student3.showInfo();

		Random random = context.getBean(Random.class);
		System.out.println(random.nextInt(1000));
	}

	@Bean("student1")
	public Student createStudent(){
		return new Student("Trần Đức Hiếu","D.hieu270799@gmail.com");
	}

	@Bean("student2")
	public Student createStudent1(){
		return new Student("Nguyễn Thanh Tùng","thanhtung@gmail.com");
	}

	@Bean
	public Random random(){
		return new Random();
	}

}
