package com.sxw.learn.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在 Java 中有两种锁，一种是内置锁 synchronized，一种是显示锁 Lock，其中 Lock 锁是可中断锁，而 synchronized 则为不可中断锁。
 * 所谓的中断锁指的是锁在执行时可被中断，也就是在执行时可以接收 interrupt 的通知，从而中断锁执行。
 */
public class ThreadInteruptDemo {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 其中线程 1 先获取到锁资源执行相应代码，而线程 2 在 0.5s 之后开始尝试获取锁资源，
         * 但线程 1 执行时忘记释放锁了，这就造成线程 2 一直阻塞等待的情况
         *
         * 这个时候如果线程2可以响应中断，就很nice
         */
        Lock lock = new ReentrantLock();
        // 创建线程 1
        Thread t1 = new Thread(() -> {
            try {
                // 加锁操作
                lock.lockInterruptibly();
                System.out.println("线程 1:获取到锁.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程 1 未释放锁
        });
        t1.start();

        // 创建线程 2
        Thread t2 = new Thread(() -> {
            // 先休眠 0.5s，让线程 1 先执行
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取锁
            try {
                System.out.println("线程 2:尝试获取锁.");
                //  lockInterruptibly 可以优先接收到中断的通知，而 lock 方法只能“死等”锁资源的释放
//                lock.lock();
                lock.lockInterruptibly();
                System.out.println("线程 2:获取锁成功.");
            } catch (Exception e) {
                System.out.println("线程 2:执行已被中断.");
            }
        });
        t2.start();

        // 等待 2s 后,终止线程 2
        Thread.sleep(2000);
        if (t2.isAlive()) { // 线程 2 还在执行
            System.out.println("执行线程的中断.");
            t2.interrupt();
        } else {
            System.out.println("线程 2:执行完成.");
        }
    }
}
