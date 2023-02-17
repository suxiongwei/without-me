package com.sxw.learn.spring.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Man {

    @Autowired
    public Man(Woman wn, Child child) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(wn.getChild() == child ? "是同一个对象":"不是同一个对象");
    }
}
