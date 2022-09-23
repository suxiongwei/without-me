package com.sxw.learn.design.proxy.staticstate;

import com.sxw.learn.design.proxy.UserService;
import com.sxw.learn.design.proxy.UserServiceImpl;

public class ClientTest {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
