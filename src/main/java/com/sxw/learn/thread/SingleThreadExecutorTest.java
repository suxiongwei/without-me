package com.sxw.learn.thread;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutorTest {

    @SneakyThrows
    public static void main(String[] args) {
//        testThreadOrderExec();
    }

    /**
     * 使用单线程池实现线程顺序执行
     */
    public static void testThreadOrderExec(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            System.out.println("t1线程执行了");
        });
        executorService.submit(() -> {
            System.out.println("t2线程执行了");
        });
        executorService.submit(() -> {
            System.out.println("t3线程执行了");
        });
        executorService.shutdown();
    }
}
