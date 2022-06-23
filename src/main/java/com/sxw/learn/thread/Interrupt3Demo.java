package com.sxw.learn.thread;

/**
 * 静态方法interrupted
 * 静态方法的实际调用
 * public static boolean interrupted() {
 *    return currentThread().isInterrupted(true);
 * }
 * 做了两件事：
 * 1、返回当前线程的中断状态
 * 2、将当前线程的中断状态清零并重制为false，清除线程的中断状态（与实例方法的不同之处，实例方法只有上述1）
 * 因此连续两次调用就会返回false
 *
 * 实例方法的实际调用 Thread.currentThread().isInterrupted();
 * public boolean isInterrupted() {
 *    return isInterrupted(false);
 * }
 * 区别在于清零标识位的设置
 *
 * 总结：
 *
 */
public class Interrupt3Demo {
    public static void main(String[] args) {
        // false
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        // false
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println("---1");
        Thread.currentThread().interrupt();
        System.out.println("---2");
        // true
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        // false
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());

        Thread.currentThread().isInterrupted();

    }
}
