package com.sxw.learn.juc.queue;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
