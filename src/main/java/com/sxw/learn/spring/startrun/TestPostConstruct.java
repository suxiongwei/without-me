package com.sxw.learn.spring.startrun;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestPostConstruct {
    static {
        System.out.println("TestPostConstruct 执行static方法");
    }

    public TestPostConstruct() {
        System.out.println("TestPostConstruct 执行构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestPostConstruct 执行@PostConstruct注解修饰的方法");
    }
}
