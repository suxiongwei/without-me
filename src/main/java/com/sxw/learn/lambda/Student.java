package com.sxw.learn.lambda;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer age, stature;
    private SpecialityEnum specialities;

    public Student(String name, Integer age, Integer stature) {
        this.name = name;
        this.age = age;
        this.stature = stature;
    }
}
