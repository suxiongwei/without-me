package com.sxw.learn.java.future.task;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 *  FutureTask示例 常用使用方式：
 *      第一种方式: Future + ExecutorService
 *      第二种方式: FutureTask + ExecutorService
 *      第三种方式: FutureTask + Thread
 */
public class CallDemo {
    @SneakyThrows
    public static void main(String[] args) {
        // 第一种方式 Future + ExecutorService
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Integer> future = executorService.submit(new Task());
//        Integer integer = future.get();
//        System.out.println(integer);
//        executorService.shutdown();

        // 第二种方式 FutureTask + ExecutorService
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
//        executorService.submit(futureTask);
//        System.out.println(futureTask.get());
//        executorService.shutdown();

        // 第三种方式：FutureTask + Thread
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        Thread thread = new Thread(futureTask);
        thread.setName("Task Thread");
        thread.start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");

        if (!futureTask.isDone()){
            System.out.println("Task is not done");
//            TimeUnit.SECONDS.sleep(3);
        }

        int result = futureTask.get();
        System.out.println("result is " + result);
    }

    // 1. 继承Callable接口,实现call()方法,泛型参数为要返回的类型
    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");
            int result = 0;
            for (int i = 0; i < 100; i++) {
                result += i;
            }

            TimeUnit.SECONDS.sleep(10);
            return result;
        }
    }
}
