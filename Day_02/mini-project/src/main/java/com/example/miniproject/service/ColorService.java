package com.example.miniproject.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type){
        return switch (type){
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default ->  throw new RuntimeException("Type không hợp lệ");
        };
    }

    private String randomColorName() {
        List<String> colors = List.of("black","white","blue","green");
        Random rd = new Random();
        int temp = rd.nextInt(colors.size());
        return colors.get(temp);
    }

    private String randomHexColor() {
        Random r = new Random();
        int val = r.nextInt();
        String hex = new String();
        hex = Integer.toHexString(val);
        return hex;
    }

    private String randomRgbColor() {
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }


}
