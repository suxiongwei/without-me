package com.sxw.learn.java.future.task;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  FutureTask示例 常用使用方式：
 *      第一种方式: Future + ExecutorService
 *      第二种方式: FutureTask + ExecutorService
 *      第三种方式: FutureTask + Thread
 */
public class CallDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger();
    @SneakyThrows
    public static void main(String[] args) {
        // 第一种方式 Future + ExecutorService
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Integer> future = executorService.submit(new Task());
//        Integer integer = future.get();
//        System.out.println(integer);
//        executorService.shutdown();

        // 第二种方式 FutureTask + ExecutorService
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6,6,9999,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(new Task());
            threadPoolExecutor.submit(new Task());
//            System.out.println(futureTask.get());
        }
        threadPoolExecutor.shutdown();
        while(true){
            if(threadPoolExecutor.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                System.out.println("最终count:" + atomicInteger.get());
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }

        // 第三种方式：FutureTask + Thread
//        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
//        Thread thread = new Thread(futureTask);
//        thread.setName("Task Thread");
//        thread.start();

//        TimeUnit.SECONDS.sleep(3);

//        System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");

//        if (!futureTask.isDone()){
//            System.out.println("Task is not done");
////            TimeUnit.SECONDS.sleep(3);
//        }
//
//        int result = futureTask.get();
//        System.out.println("result is " + result);
    }

    // 1. 继承Callable接口,实现call()方法,泛型参数为要返回的类型
    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");
            int count = atomicInteger.getAndAdd(10);
            System.out.println("etlCount:" + count);
//            TimeUnit.SECONDS.sleep(1);
            return count;
        }
    }

}
