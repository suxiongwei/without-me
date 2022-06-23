package com.sxw.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * 当对线程调用 interrupt()时：
 * 1、如果线程处于<span>正常活动状态</span>，那么该线程对中断标志位会被设置为true，仅此而已
 *    被设置中断标志的线程将继续运行，不受影响
 *    所以 interrupt()并不能真正的中断线程，需要被中断的线程配合才行
 * 2、如果被中断的线程处于被阻塞状态（例如 sleep、wait、joind等状态），那么线程会立即退出被阻塞状态，并且抛出InterruptedException
 *
 * 此篇测试上述1
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 即使被中断后，依然会输出到300，证明被设置中断标志的线程将继续运行，不受影响
            for (int i = 0; i < 300; i++) {
                System.out.println("------" + i);
            }
            // true
            System.out.println("t1线程调用interrupt()后的中断标识位02:" + Thread.currentThread().isInterrupted());
        },"t1");
        t1.start();

        // false
        System.out.println("t1线程默认的中断标识位:" + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(2);
        t1.interrupt();
        // true
        System.out.println("t1线程调用interrupt()后的中断标识位01:" + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(2000);
        // false 原因是中断不活动的线程，不会产生任何影响
        System.out.println("t1线程调用interrupt()后的中断标识位03:" + Thread.currentThread().isInterrupted());
    }
}
