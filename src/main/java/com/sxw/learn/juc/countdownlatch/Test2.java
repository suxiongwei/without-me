package com.sxw.learn.juc.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
public class Test2 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            while (true) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("xxxxxx" + list.size());
                break;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i + "");
                System.out.println(i);
                if (list.size() == 5){
                    countDownLatch.countDown();
                }
            }
        }).start();

    }

}
