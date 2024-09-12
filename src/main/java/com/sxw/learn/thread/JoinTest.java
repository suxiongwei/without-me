package com.sxw.learn.thread;


public class JoinTest {
    // 使用join 使得t1、t2、t3按顺序执行
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("t1 is running"));
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 is running");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 is running");
        });

        // 这里三个线程的启动顺序可以任意
        t1.start();
        t3.start();
        t2.start();
    }
}
