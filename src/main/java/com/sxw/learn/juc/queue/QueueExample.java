package com.sxw.learn.juc.queue;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class QueueExample {
    @SneakyThrows
    public static void main(String[] args) {
        // 测试数组阻塞队列，初始化时设置上限，一旦设置，不能更改
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

        TimeUnit.SECONDS.sleep(4);
        // DelayQueue
        // ....

        // 链阻塞队列 LinkedBlockingQueue
        // 无界队列，没有定义上限，将使用 Integer.MAX_VALUE 作为上限
        BlockingQueue unbounded = new LinkedBlockingQueue();
        // 有界队列
        BlockingQueue bounded = new LinkedBlockingQueue(1024);
        bounded.put("LinkedBlockingQueue bounded");
        Object take = bounded.take();
        System.out.println("LinkedBlockingQueue value" + take);

        // PriorityBlockingQueue 优先级阻塞队列

        // SynchronousQueue 同步队列 内部只存在一个元素


        // 测试BlockingDeque
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.addFirst("1");
        deque.addLast("2");

        System.out.println("测试BlockingDeque Begin");
        String two = deque.takeLast();
        String one = deque.takeFirst();
        System.out.println(two);
        System.out.println(one);
    }
}
