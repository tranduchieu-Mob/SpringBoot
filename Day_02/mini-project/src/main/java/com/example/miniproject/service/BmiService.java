package com.example.miniproject.service;

import com.example.miniproject.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public double calculateBmi(double height, double weight) {
        if(height <= 0 || weight <= 0) {
            throw new BadRequestException("Cân năng hoặc chiều cao phải > 0");
        }
        return weight / (height * height);
    }
}
