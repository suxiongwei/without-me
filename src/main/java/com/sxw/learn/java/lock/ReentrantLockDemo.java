package com.sxw.learn.java.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    static class MyThread extends Thread{
        Lock lock;

        public MyThread(String name, Lock lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread() + " running");
                TimeUnit.NANOSECONDS.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        new MyThread("t1", lock).start();
        new MyThread("t2", lock).start();
        new MyThread("t3", lock).start();
    }
}
