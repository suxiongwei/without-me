package com.sxw.learn.java.future;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit((Callable<Object>) () -> {
            long start = System.currentTimeMillis();
            while (true){
                long time = System.currentTimeMillis() - start;
                if (time > 1000){
                    return 1;
                }
            }
        });

        Integer result = (Integer) future.get();
        System.out.println(result);
    }
}
