package com.sxw.learn.juc.future;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    @SneakyThrows
    public static void main(String[] args) {
//        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName());
//                TimeUnit.SECONDS.sleep(3);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println(runAsync.get());
//
//        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName());
//                TimeUnit.SECONDS.sleep(3);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "hello supplyAsync";
//        });
//        System.out.println(supplyAsync.get());

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "-> come in");
                int nextInt = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("5秒后出结果");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return nextInt;
            }, executor).whenComplete((v, e) -> {
                if (e == null){
                    System.out.println("计算完成，获取的结果为：" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况:" + e.getCause());
                return null;
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        System.out.println("main 线程执行输出");
    }
}
