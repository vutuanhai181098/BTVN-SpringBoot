package com.btvnSpringBoot.btnvnSpringBoot.entities;

public class BMI {
    private Float height;
    private Float weight;

    public BMI(Float height, Float weight) {
        this.height = height;
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
