package com.sxw.learn.spring.test1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@Slf4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Person student = (Person) applicationContext.getBean("student");
        log.info(student.getClass().getName());
        student.sayHello();
        Person teacher = (Person) applicationContext.getBean("teacher");
        log.info(teacher.getClass().getName());
        teacher.sayHello();
    }
}
