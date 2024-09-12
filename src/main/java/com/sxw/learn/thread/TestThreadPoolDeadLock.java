package com.sxw.learn.thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPoolDeadLock {
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    private void test() {
        List<CompletableFuture<Void>> outFutureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            outFutureList.add(CompletableFuture.runAsync(new TaskA(i), executor));
        }
        // 注释掉此行代码也还是会发生死锁
//        CompletableFuture.allOf(outFutureList.toArray(new CompletableFuture[outFutureList.size()])).join();
    }


    class TaskA implements Runnable {
        private Integer outId;

        TaskA(Integer outId) {
            this.outId = outId;
        }

        @Override
        @SneakyThrows
        public void run() {
            List<Future<String>> innerFutureList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                int finalI = i;
                Future<String> submit = executor.submit(() -> {
                    TimeUnit.SECONDS.sleep(5);
                    String res = outId + "-" + finalI;
                    System.out.println(res);
                    return res;
                });
                innerFutureList.add(submit);
            }
            // 这一段代码是关键，必须要形成阻塞，不阻塞的话主线程就可以执行完毕了，那么主线程就释放线程了，子线程队列中的任务就有空闲线程执行了
            for (Future<String> stringFuture : innerFutureList) {
                System.out.println(stringFuture.get());
            }
        }
    }

    public static void main(String[] args) {
        TestThreadPoolDeadLock testThreadPoolDeadLock = new TestThreadPoolDeadLock();
        testThreadPoolDeadLock.test();
    }
}
