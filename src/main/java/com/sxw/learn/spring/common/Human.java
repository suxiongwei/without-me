package com.sxw.learn.spring.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class Human {

    @Bean
    public Woman getWomanBean() {
        Woman woman = new Woman();
        woman.setChild(getChildBean()); // 直接调用@Bean注解的方法方法getChildBean()
        return woman;
    }

    @Bean
    public Child getChildBean() {
        return new Child();
    }
}
