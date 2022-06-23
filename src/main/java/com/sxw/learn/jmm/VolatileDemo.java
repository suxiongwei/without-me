package com.sxw.learn.jmm;

import java.util.concurrent.TimeUnit;

/**
 * 特点：
 * 可见性和有序性(禁止重排序)
 * volatile的内存语义
 * - 当写一个volatile变量时，JMM会把线程对应的本地内存中的共享变量值立即刷新回主内存中
 * - 当读一个volatile变量时，JMM会把线程对应的本地内存设置为无效，重新回到主内存中读取最新值
 *
 * volatile凭什么可以保证可见性和有序性？
 * A：内存屏障Memory Barrier
 *   内存屏障的含义：是一种屏障指令，使得CPU或编译器对屏障前后的所发出的内存操作执行一个排序的约束
 *
 * 如何正确的使用volatile
 * 1、单一赋值可以，but复合运算赋值不可以(如i++)
 * 2、状态标志，判断业务是否结束
 * 3、开销较低的读，写锁策略
 * 4、DCL双端锁的发布
 *
 *
 * 总结：
 * volatile 写之前的操作，都禁止重排序到volatile后
 * volatile 读之后的操作，都禁止重排序到volatile前
 * volatile 写之后 volatile读，禁止重排序
 */
public class VolatileDemo {
    private volatile static boolean flag = true;

    public static void main(String[] args) {
        /**
         * 使用：作为一个布尔状态标志，用于指示一个发生了一个重要的标志性事件，例如完成初始化或任务结束
         * 例子：判断业务是否结束
         */
//        new Thread(() -> {
//            while (true){
//                if (flag){
//                    System.out.println("程序正常执行");
//                } else {
//                    break;
//                }
//            }
//        }, "t1").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(() -> flag = false,"t2").start();



    }

    /**
     * 使用：当读大于写，结合使用内部锁和volatileb变量来减少同步的开销
     * 理由：利用volatile来保证读取操作的可见性，利用synchronized保证复合操作的原子性
     */
    public class Counter{
        private volatile int value;

        public int getValue() {
            return value;
        }

        public synchronized int increment() {
            return value++;
        }
    }
}
