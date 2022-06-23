package com.sxw.learn.juc.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * https://cloud.tencent.com/developer/article/1625436
 */
public class DeadLockSample extends Thread{
    private String first;
    private String second;

    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }


    @SneakyThrows
    @Override
    public void run() {
        synchronized (first){
            System.out.println(this.getName()+" obtained "+ first);
            TimeUnit.SECONDS.sleep(1);
            synchronized (second){
                System.out.println(this.getName()+" obtained "+ second);
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
