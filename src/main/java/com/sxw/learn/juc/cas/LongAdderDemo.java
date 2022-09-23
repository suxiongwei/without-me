package com.sxw.learn.juc.cas;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * AtomicLong VS LongAdder
 * LongAdder使用分段累加的设计 比AtomicLong要快
 *
 * 但是LongAdder提供的API较少
 */
public class LongAdderDemo {
    @SneakyThrows
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        CountDownLatch countDownLatch = new CountDownLatch(101);
        ExecutorService service = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(counter, countDownLatch));
        }
//        Thread.sleep(2000);
        countDownLatch.await();
        System.out.println(counter.sum());
        service.shutdown();
    }

    static class Task implements Runnable {
        private final LongAdder counter;

        private final CountDownLatch countDownLatch;

        public Task(LongAdder counter, CountDownLatch countDownLatch) {
            this.counter = counter;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            counter.increment();
            countDownLatch.countDown();
        }
    }
}
