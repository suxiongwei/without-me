package com.sxw.learn.thread;

import lombok.SneakyThrows;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-03 7:42 下午
 */
public class TestSleepAndWait {
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (TestSleepAndWait.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    TestSleepAndWait.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            synchronized (TestSleepAndWait.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                // notify()或者notifyAll()调用时并不会真正释放对象锁, 必须等到synchronized方法或者语法块执行完才真正释放锁.
                // TestSleepAndWait.class.notify();

                //区别
                //如果我们把代码：TestSleepAndWait.class.notify();给注释掉，TestSleepAndWait.class调用了wait()方法，但是没有调用notify()方法，则线程永远处于挂起状态。
                //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                //在调用sleep()方法的过程中，线程不会释放对象锁。
                Thread.sleep(5000);

                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
            System.out.println("thread2 sleep 10s begin...");
            // TestSleepAndWait.class.notify() 退出了synchronized 才真正释放了锁，此时wait的线程开始运行
            Thread.sleep(10);
            System.out.println("thread2 sleep 10s over!!!");
        }
    }
}
