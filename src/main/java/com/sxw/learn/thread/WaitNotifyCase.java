package com.sxw.learn.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-03 8:26 下午
 */
public class WaitNotifyCase {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(() -> {
            System.out.println("线程 A 等待 获得 锁");
            synchronized (lock) {
                try {
                    System.out.println("线程 A 获得 锁");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("线程 A 开始 执行 wait() ");
                    lock.wait();
                    System.out.println("线程 A 结束 执行 wait()");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("线程 B 等待 获得 锁");
            synchronized (lock) {
                System.out.println("线程 B 获得 锁");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                System.out.println("线程 B 执行 notify()");
            }
        }).start();
    }
}
