package com.sxw.learn.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock流程：
 * tryAcquire(arg) -> addWaiter(Node.EXCLUSIVE), arg) -> acquireQueued(addWaiter(Node.EXCLUSIVE), arg)
 *
 * shouldParkAfterFailedAcquire：waitStatus是后面的节点更新前面的节点的waitStatus值
 * 将前置节点的waitStatus设置为SIGNAL(-1)，为后续的唤醒做准备
 *
 * 队列中的节点底层是通过LockSupport.park(this);
 *
 * unlock流程：
 * sync.release(1) -> tryRelease(arg) -> unparkSuccessor(h) -> LockSupport.unpark(s.thread);
 *
 *
 */
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
