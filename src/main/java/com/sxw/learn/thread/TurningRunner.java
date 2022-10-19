package com.sxw.learn.thread;

import lombok.SneakyThrows;

/**
 * 两个线程交替打印0-100的奇偶数
 */
public class TurningRunner {
    static class Runner implements Runnable {
        private static int num = 1;
        private static final Object lock = new Object();
        private static final int targetNum = 4;

        @SneakyThrows
        @Override
        public void run() {
            while (num <= targetNum) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num++;
                    lock.notify();
                    if (num <= targetNum) {
                        lock.wait();
                    }
                }
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        new Thread(new Runner(), "奇数").start();
        Thread.sleep(500);
        new Thread(new Runner(), "偶数").start();
        /**
         * 1 notify wait
         * 2 notify wait
         * 3 notify wait
         * 4 notify wait不执行了，因为打印完 num 会加1，因此不执行wait了，直接结束了
         */
    }


}
