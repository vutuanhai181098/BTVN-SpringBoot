package com.btvnSpringBoot.btnvnSpringBoot.service;

import com.btvnSpringBoot.btnvnSpringBoot.exception.BMIException;

public class BMIService {
    public Float indexBMI(Float height, Float weight) throws BMIException {
        if(height <= 0 || weight <= 0) {
            throw new BMIException("Chiều cao và cân nặng không hợp lệ");
        }
        return weight / (height * height);
    }
}
