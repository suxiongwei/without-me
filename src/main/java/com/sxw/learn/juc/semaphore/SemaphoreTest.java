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

    public static void testThreadOrderExec(){
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            System.out.println("t1执行了");
            semaphore1.release();
        });

        Thread t2 = new Thread(() -> {
            try {
                // 获取一个许可，如果没有许可就进行阻塞，知道获取到一个许可
                semaphore1.acquire();
                System.out.println("t2执行了");
                semaphore2.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                semaphore2.acquire();
                System.out.println("t3执行了");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    @SneakyThrows
    public static void main(String[] args) {
//        test1();
        testThreadOrderExec();
    }
}
