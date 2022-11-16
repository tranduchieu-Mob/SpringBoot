package com.example.BaiTap02.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public static String randomColor(int type) {
        return switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexColor();
            case 3 -> randomRgbColor();
            default -> throw new RuntimeException("type khong hop le: ");

        };
    }

    public static String randomRgbColor() {

        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return "rgb(" + r + ","+ g + "," + b+")";

    }

    private static String randomHexColor() {
        Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);
        return Hex;

    }

    private static String randomColorName() {
        List<String> colors = List.of("black", "white", "blue", "yellow", "red");
        Random rd = new Random();
        int temp = rd.nextInt(colors.size());
        return colors.get(temp);
    }

}