package com.sxw.learn.proxy.dynamic.cglib;

public class Main {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("Java");
    }
}
