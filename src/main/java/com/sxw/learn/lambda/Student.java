package com.sxw.learn.lambda;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int age, stature;
    private SpecialityEnum specialities;

    public Student(String name, int age, int stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}
