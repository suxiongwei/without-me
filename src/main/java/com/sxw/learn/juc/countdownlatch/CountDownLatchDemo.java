package com.sxw.learn.juc.countdownlatch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    @SneakyThrows
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        MyThread t1 = new MyThread("t1", countDownLatch);
        MyThread t2 = new MyThread("t2", countDownLatch);
        t1.start();
        t2.start();
        System.out.println("Waiting for t1 thread and t2 thread to finish");
        // 首先main线程会调用await操作，此时main线程会被阻塞，等待被唤醒，
        // 之后t1线程执行了countDown操作，最后，t2线程执行了countDown操作，此时main线程就被唤醒了，可以继续运行。
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " continue");

        testThreadOrderExec();
    }

    /**
     * 使用CountDownLatch实现线程顺序执行
     */
    public static void testThreadOrderExec(){
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            System.out.println("当前执行线程:t1");
            countDownLatch1.countDown();
        });

        Thread t2 = new Thread(() -> {
            try {
                // 使当前线程等待，知道计数器变成0
                countDownLatch1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("当前执行线程:t2");
            countDownLatch2.countDown();
        });

        Thread t3 = new Thread(() -> {
            try {
                countDownLatch2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("当前执行线程:t3");
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread extends Thread{
    private CountDownLatch countDownLatch;

    public MyThread(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @SneakyThrows
    public void run(){
        System.out.println(Thread.currentThread().getName() + " doing something");
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + " finish");
        countDownLatch.countDown();
    }
}
