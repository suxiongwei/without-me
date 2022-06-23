package com.sxw.learn.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * https://mp.weixin.qq.com/s/GzjcfogxK3beXB1II7VoQw
 */
public class ExchangerDemo {
    private static void test1() {
        Exchanger exchanger = new Exchanger();

        new Thread(() -> {
            try {
                Object data = "-公众号Java技术栈AAA";
                System.out.println("交换前：" + Thread.currentThread().getName() + data);

                // 开始交换数据
                data = exchanger.exchange(data);
                System.out.println("交换后：" + Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Object data = "-公众号Java技术栈BBB";
                System.out.println("交换前：" + Thread.currentThread().getName() + data);

                TimeUnit.SECONDS.sleep(3);
                // 开始交换数据
                data = exchanger.exchange(data);
                System.out.println("交换后：" + Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        test1();
    }
}
