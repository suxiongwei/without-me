package com.sxw.learn.java.queue;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }


    @SneakyThrows
    @Override
    public void run() {
        queue.put(1);
        TimeUnit.SECONDS.sleep(1);
        queue.put(2);
        TimeUnit.SECONDS.sleep(1);
        queue.put(3);
        TimeUnit.SECONDS.sleep(1);
    }
}
