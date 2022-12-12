package com.example.miniproject.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ColorService {
    public String randomColor(int type) {
        return switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default -> throw new RuntimeException("Type không hợp lệ");
        };
    }

    private String randomColorName() {
    // Định nghĩa 1 mảng -> lấy random 1 giá trị trong mảng
        String[] colors = { "red", "green", "blue", "black", "yellow" };

        Random rd = new Random();
        int rdIndex = rd.nextInt(colors.length);
        return colors[rdIndex];
    }

    public String randomRgbColor() {
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return "rgb(" + r + "," + g + "," + b + ")"; // "rgb(22,14,123)";
    }

    // 0 -> 9; a -> f
    private String randomHexColor() {
        Random rd = new Random();
        String[] characters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 6; i++) {
            int index = rd.nextInt(characters.length);
            sb.append(characters[index]);
        }
        return sb.toString();
    }


}
