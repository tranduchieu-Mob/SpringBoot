package com.example.miniproject.controller;

import com.example.miniproject.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {

    @Autowired
    private ColorService colorService;

    // GET http://localhost:8080/random-color?type=[typeValue]
    @GetMapping("/random-color")
    public String randomColor(@RequestParam int type) {
        return colorService.randomColor(type);
    }
}
