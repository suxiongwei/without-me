package com.sxw.learn.spring.test1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("teacher")
public class TeacherImpl implements Person {
    private String name;

    @Override
    public void sayHello() {
        log.info("Hello World, "+this.name);
    }

    @PostConstruct
    public void init(){
        this.name="teacher";
    }

    @Override
    public String toString() {
        return "TeacherImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}