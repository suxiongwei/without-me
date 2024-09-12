package com.sxw.learn.thread;

import java.util.concurrent.TimeUnit;

public class WaitNotifyCase {
    public static void main(String[] args) {
        // wait/notify 必须配合 synchronized 使用
        final Object lock = new Object();

        new Thread(() -> {
            System.out.println("线程 A 等待 获得 锁");
            synchronized (lock) {
                try {
                    System.out.println("线程 A 获得 锁");
                    // sleep不会释放锁，当睡眠的时间到了之后，线程会自动进入可执行状态，等待cpu的执行
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("线程 A 开始 执行 wait() ");
                    // 暂时让出同步锁
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
                // notify并不释放锁，只是告诉调用过wait()的线程可以去参与获得锁的竞争了，但不是马上得到锁，因为锁还在别人手里，别人还没释放，
                // 调用 wait() 的一个(notify)或多个(notifyAll)线程就会解除 wait 状态，重新参与竞争对象锁，程序如果可以再次得到锁，就可以继续向下运行。
                lock.notify();
                System.out.println("线程 B 执行 notify()");
            }
        },"B").start();

        /**
         * 执行结果:
         * 线程 A 等待 获得 锁
         * 线程 A 获得 锁
         * 线程 B 等待 获得 锁
         * 线程 A 开始 执行 wait()
         * 线程 B 获得 锁
         * 线程 B 执行 notify() 从这一行结果可以得出结论：notify并不释放锁，等B线程执行完毕之后，释放了锁，此时处于wait状态的A线程才会竞争得到锁，继续执行
         * 线程 A 结束 执行 wait()
         */
    }
}
