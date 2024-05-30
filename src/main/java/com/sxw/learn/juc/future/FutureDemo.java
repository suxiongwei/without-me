package com.sxw.learn.juc.future;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  FutureTask示例 常用使用方式：
 *      第一种方式: Future + ExecutorService
 *      第二种方式: FutureTask + ExecutorService
 *      第三种方式: FutureTask + Thread
 *
 *  Future 是一个接口，FutureTask是Future接口一个实现，个人猜测ExecutorService.submit方法返回的也是一个FutureTask
 *
 *
 */
public class FutureDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit((Callable<Object>) () -> {
            long start = System.currentTimeMillis();
            while (true){
                long time = System.currentTimeMillis() - start;
                if (time > 10000){
                    return 1;
                }
            }
        });

        // 阻塞的获取
        Integer result = (Integer) future.get();
        System.out.println(result);


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
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        Thread thread = new Thread(futureTask);
        thread.setName("Task Thread");
        thread.start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");

        // FutureTask get容易发生阻塞，一般放在程序最后面, 如果使用推荐下面轮询的方式使用
        // Future的缺点：对于结果的获取不是很友好，只能通过轮询或者阻塞的方式得到任务的结果，因此引出了CompletableFuture
        while (true){
            if (!futureTask.isDone()){
                System.out.println("Task is not done");
                TimeUnit.SECONDS.sleep(3);
            }else {
                int result1 = futureTask.get();
                System.out.println("result is " + result1);
            }
        }
    }

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
