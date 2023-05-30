package com.sxw.learn.thread;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * 测试线程池异常
 */
public class ThreadPoolException {
    @SneakyThrows
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 9999, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        // case1 会抛出异常
//        executor.execute(new MyRunnableTask());
        // cese2: 不调用submit.get()  不会抛出异常
//        executor.submit(new MyRunnableTask());
        // case 3: 调用submit.get()  会抛出异常
        Future<Integer> submit = executor.submit(new MyCallableTask());
        Integer o = submit.get();
        System.out.println(o);
    }

    static class MyRunnableTask implements Runnable {
        public void run() {
            System.out.println("进入了task方法！！！");
            int i = 1 / 0;
        }
    }

    static class MyCallableTask implements Callable {
        public Integer call() {
            System.out.println("进入了task方法！！！");
//            int i = 1 / 0;
            return 10;
        }
    }
}
