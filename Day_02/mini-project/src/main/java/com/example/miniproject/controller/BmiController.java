package com.example.miniproject.controller;

import com.example.miniproject.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BmiController {
    @Autowired
    private BmiService bmiService;
    @GetMapping("/bmi")
    public String bmi(@RequestParam double height,@RequestParam double weight){
        return bmiService.bmi(height,weight);
    }
}
