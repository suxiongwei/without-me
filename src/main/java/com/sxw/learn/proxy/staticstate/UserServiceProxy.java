package com.sxw.learn.proxy.staticstate;

import com.sxw.learn.proxy.UserService;

import java.util.Date;

public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void select() {
        before();
        target.select();    // 这里才实际调用真实主题角色的方法
        after();
    }

    @Override
    public void update() {
        before();
        target.update();    // 这里才实际调用真实主题角色的方法
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {      // 在执行方法之后执行
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
