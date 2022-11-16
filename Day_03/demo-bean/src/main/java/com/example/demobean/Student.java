package com.example.demobean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Student {
    private String name;
    private String email;

    @Autowired
    @Qualifier("bike")
    private Vehicle vehicle;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void showVehicle(){
        vehicle.run();
    }

    public void showInfo(){
        System.out.println("Name: " + name + " - Email: " + email);
    }

    public void  hello(){
        System.out.println("Xin chào Student");
    }
}
