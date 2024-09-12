package com.sxw.learn.juc.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void test1() throws Exception {
        Semaphore semaphore = new Semaphore(1, true);

        Runnable runnable = () -> {
            try {
                semaphore.tryAcquire(1, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + "执行了");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "线程" + i).start();
            // 主线程睡眠1秒，以便观察现象
//            Thread.sleep(500);
        }

    }

    @SneakyThrows
    public static void main(String[] args) {
        test1();
    }
}
