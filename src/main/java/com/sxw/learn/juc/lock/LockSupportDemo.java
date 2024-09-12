package com.sxw.learn.juc.lock;

import lombok.SneakyThrows;
import lombok.val;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三种让线程实现阻塞唤醒的方式
 * 1、Object中的wait、notify实现线程的阻塞唤醒
 * 2、Condition接口中的await和signal实现线程的阻塞唤醒
 * 3、park、unpark
 * 方式1和2的局限性：
 * - 线程先要获取并持有锁，必须在锁块中（synchronized或lock）
 * - 必须要先等待后唤醒，线程才能够被唤醒
 *
 * 第三种方式解决了1、2的局限性，无锁块的要求，也支持先唤醒后等待
 * LockSupport的实现阻塞和解除阻塞的过程
 * LockSupport和每个使用他的线程都有一个许可(permit)关联
 * 每个线程都有一个相关的permit，permit最多只有一个，重复调用unpark不会积累凭证
 *
 * 如果在park()之前执行了unpark()会怎样?
 * 线程不会被阻塞，直接跳过park()，继续执行后续内容
 *
 *
 */
public class LockSupportDemo {
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");

    public static void main(String[] args) {
        // 用于测试三种让线程实现阻塞唤醒的方式
//        syncWaitNotify();
        conditionAwaitAndSignal();
//        parkAndUnpark();

        /**
         * 用于测试park和unpark没有先后顺序
         * t1内部有休眠1s的操作，所以unpark肯定先于park的调用，但是t1最终仍然可以完结。这是因为park和unpark会对每个线程维持一个许可（boolean值）
         * 不会出现死锁的情况，如果是前两者，先执行解锁，再执行加锁，这样就会出现死锁
         */
//        t1.start();
//        LockSupport.unpark(t1);
//        System.out.println("unpark invoked");
    }

    /**
     * Object中的wait、notify实现线程的阻塞唤醒
     */
    public static void syncWaitNotify(){
        Object objectLock = new Object();
        new Thread(() -> {
            // 注释此行代码，观察没有同步代码块的效果
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");

            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "发出通知");
            }
        }, "t2").start();
    }

    /**
     * Condition接口中的await和signal实现线程的阻塞唤醒
     */
    @SneakyThrows
    public static void conditionAwaitAndSignal(){
        Lock lock = new ReentrantLock();
        val condition = lock.newCondition();

        new Thread(() -> {
            // 注释此行代码，观察没有锁块的效果
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t1").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            // 注释此行代码，观察没有锁块的效果
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t2").start();

        TimeUnit.SECONDS.sleep(2);


        new Thread(() -> {
            lock.lock();
            try {
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "\t" + "发出通知");
            }finally {
                lock.unlock();
            }
        },"t3").start();
    }

    /**
     * LockSupport park和unpark实现线程的阻塞唤醒
     */
    public static void parkAndUnpark(){
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "发出通知");
        }, "t2");
        t2.start();
    }

    /**
     * 用于测试park和unpark没有先后顺序
     */
    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override public void run() {
            System.out.println("in " + getName());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("被中断了");
            }
            System.out.println("继续执行");
        }
    }

}
