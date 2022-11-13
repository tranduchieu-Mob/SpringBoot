package com.example.miniproject.service;

import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public String bmi(double height, double weight) {
        if(height <= 0 || weight<=0){
            return ("Type không hợp lệ");
        }
        return weight/(height*height);
    }

}

