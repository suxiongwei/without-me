package com.sxw.learn.juc.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// 三个线程交替打印 ABC
public class ABCPrinter {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    private static AtomicInteger curNum = new AtomicInteger(0);

    private static AtomicInteger maxNum = new AtomicInteger(100);


    public static class Task implements Runnable{
        private Semaphore curSemaphore;
        private Semaphore nextSemaphore;

        private String cur;

        public Task(Semaphore curSemaphore, Semaphore nextSemaphore, String cur){
            this.curSemaphore = curSemaphore;
            this.nextSemaphore = nextSemaphore;
            this.cur = cur;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (curNum.get() <= maxNum.get()){
                curSemaphore.acquire();
                System.out.println(cur);
                curNum.incrementAndGet();
                nextSemaphore.release();
            }

        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        // 形成了一个等待锁定的环
        new Thread(new Task(semaphoreA, semaphoreB, "A")).start();
        new Thread(new Task(semaphoreB, semaphoreC, "B")).start();
        new Thread(new Task(semaphoreC, semaphoreA, "C")).start();
    }
}
