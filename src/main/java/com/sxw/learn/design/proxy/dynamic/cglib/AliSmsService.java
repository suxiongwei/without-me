package com.sxw.learn.design.proxy.dynamic.cglib;

/**
 * 委托类（Real Subject）
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
