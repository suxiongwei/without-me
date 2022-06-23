package com.sxw.learn.juc.cas;

import lombok.val;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) {
        new Thread(() -> {
            val stamp = reference.getStamp();
            System.out.println(Thread.currentThread().getName() + "初次版本号" + stamp);

            // 暂停500毫秒，保证后面的t2线程拿到的初次版本好和t1是一致的
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reference.compareAndSet(100, 101, reference.getStamp(), reference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "二次版本号" + reference.getStamp());
            reference.compareAndSet(101, 100, reference.getStamp(), reference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "三次版本号" + reference.getStamp());

        },"t1").start();

        new Thread(() -> {
            val stamp = reference.getStamp();
            System.out.println(Thread.currentThread().getName() + "初次版本号" + stamp);

            // 暂停1秒钟，等待t1线程发生ABA问题
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            val b = reference.compareAndSet(100, 2022, stamp, stamp + 1);
            System.out.println(b + "\t" + reference.getReference() + "\t" + reference.getStamp());

        },"t2").start();
    }
}
