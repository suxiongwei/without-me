package com.sxw.learn.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * 谈谈你对多线程锁的理解，通过8种案例说明
 * 口诀：线程  操作  资源类
 * 1、标准访问a b两个线程，请问先打印发邮件还是发短信
 * 2、sendEmail中加入暂停方法3秒钟，此时先打印发邮件还是发短信
 * ...
 *
 * 结论：
 * 主要看锁的资源：对象锁和类锁
 * 静态方法和普通方法是不会产生竞态条件的
 *
 * synchronized体现在三个地方：
 * 作用于实例方法，当前实例加锁，进入同步代码前要获得当前实例的锁
 * 作用于代码块，对括号里配置对对象加锁
 * 作用于静态方法，当前类加锁，进入同步代码前要获得当前类对象的锁
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> phone.sendEmail(),"a").start();

        // 保证a线程先启动执行
        TimeUnit.MILLISECONDS.sleep(200);
        new Thread(() -> phone.sendSMS(),"b").start();
    }
}

/**
 * 定义一个资源类
 */
class Phone{
    // 此处的synchronized不是锁的一个方法，而是锁的当前对象this
    public synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---sendEmail");
    }

    public synchronized void sendSMS(){
        System.out.println("---sendSMS");
    }

    // 静态方法锁的是类锁
    public static synchronized void sendXXX(){
        System.out.println("---sendXXX");
    }
}
