package com.sxw.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * 如果被中断的线程处于被阻塞状态（例如 sleep、wait、joind等状态），那么线程会立即退出被阻塞状态，并且抛出InterruptedException
 * 并且会清除中断状态
 *
 * 以下代码的执行逻辑
 * 1、中断标记位默认位false
 * 2、t2向t1发起中断协商，t2调用t1.interrupt(),中断标记位为true
 * 3、中断标记位为true，正常情况下，程序正常停止
 * 4、中断标记位为true，异常情况下，抛出InterruptedException，会清除中断状态，此时中断标记位为false，因此导致了无限循环
 * 5、在catch块中，再次将中断标记位设置为true可解决上一步的问题
 */
public class Interrupt2Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "设置中断标识位："
                            + Thread.currentThread().isInterrupted() + "程序停止");
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // 不加下面这行代码，程序一直执行，那么为什么要在异常处再调用一次interrupt
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }

                System.out.println("Interrupt2Demo");
            }
        },"t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(20);

        new Thread(() -> t1.interrupt(),"t2 ").start();
    }
}
