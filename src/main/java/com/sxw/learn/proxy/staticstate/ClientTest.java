package com.sxw.learn.proxy.staticstate;

import com.sxw.learn.proxy.UserService;
import com.sxw.learn.proxy.UserServiceImpl;

public class ClientTest {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
