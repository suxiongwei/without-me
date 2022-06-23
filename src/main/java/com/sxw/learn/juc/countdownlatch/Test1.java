package com.sxw.learn.juc.countdownlatch;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 面试题:
 * 实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 */
public class Test1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Container container = new Container();
        new Thread(() -> {
            System.out.println("t2 start");
            if (container.getSize() != 5){
                try {
                    countDownLatch.await();
                    System.out.println("t2 end, 当前容器大小:" + container.getSize());
//                    Thread.currentThread().interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 9; i++) {
                container.add(i);
                System.out.println("add"+ i);
                if (container.getSize() == 5){
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                }
            }
            System.out.println("t1 end");
        }, "t1").start();
    }
}

class Container{
    volatile List<Integer> list = Lists.newArrayList();

    public void add(Integer item){
        list.add(item);
    }

    public int getSize(){
        return list.size();
    }
}
