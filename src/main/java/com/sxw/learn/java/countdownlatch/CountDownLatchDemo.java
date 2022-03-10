package com.sxw.learn.java.countdownlatch;

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
        // 首先main线程会调用await操作，此时main线程会被阻塞，等待被唤醒，之后t1线程执行了countDown操作，最后，t2线程执行了countDown操作，此时main线程就被唤醒了，可以继续运行。
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " continue");
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
