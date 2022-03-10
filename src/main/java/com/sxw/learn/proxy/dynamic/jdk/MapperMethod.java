package com.sxw.learn.proxy.dynamic.jdk;


public class MapperMethod {
    public Object execute() {
        System.out.println("封装了mapper接口中对对应方法的信息，一级对应的sql语句信息，它是mapper接口和映射配置文件中sql语句的桥梁");
        return "execute success";
    }
}
