package com.sxw.learn.proxy.dynamic.jdk;

public class AdminServiceImpl implements AdminService {
    public void select() {
        System.out.println("查询 selectById");
    }
    public void update() {
        System.out.println("更新 update");
    }
}
