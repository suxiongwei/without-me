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
 * https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484070&idx=1&sn=c1d49bce3c9da7fcc7e057d858e21d69&chksm=fba6eaa5ccd163b3a935303f10a54a38f15f3c8364c7c1d489f0b1aa1b2ef293a35c565d2fda&mpshare=1&scene=1&srcid=0608QzOXG2l0z2QyfVaCKqRH%23rd
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
