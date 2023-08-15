package com.btvnSpringBoot.btnvnSpringBoot.service;

import com.btvnSpringBoot.btnvnSpringBoot.exception.ColorException;

import java.util.Random;

public class ColorService {
    public String getRandomColor(int type) throws ColorException {
        String color = "";
        switch (type){
            case 1 :
                color = getRandomColorName();
                break;
            case 2 :
                color = getRandomHEXColor();
                break;
            case 3 :
                color = getRandomRGBColor();
                break;
            default:
                throw new ColorException("Type không hợp lệ");
        }
        return color;
    }

    public String getRandomColorName() {
        String[] arr = {"Red", "Blue", "Green", "Brown", "Black", "Orange", "Violet", "Pink", "Gray", "Yellow", "Purple"};
        Random random = new Random();
        int idx = random.nextInt(arr.length);
        return arr[idx];
    }

    public String getRandomHEXColor() {
        String letters = "0123456789ABCDEF";
        StringBuilder color = new StringBuilder();
        color.append("#");
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int idx = random.nextInt(letters.length());
            color.append(letters.charAt(idx));
        }
        return color.toString();
    }

    public String getRandomRGBColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return "rgb(" + red + ", " + green + ", " + blue + ")";
    }
}
