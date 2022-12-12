package com.example.miniproject.controller;

import com.example.miniproject.request.BmiRequest;
import com.example.miniproject.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {
    @Autowired
    private BmiService bmiService;

    @GetMapping("/bmi-get")
    public double calculateBmiGet(@RequestParam double height, @RequestParam double weight) {
        return bmiService.calculateBmi(height, weight);
    }

    @PostMapping("/bmi-post")
    public double calculateBmiPost(@RequestBody BmiRequest request) {
        return bmiService.calculateBmi(request.getHeight(), request.getWeight());
    }
}
