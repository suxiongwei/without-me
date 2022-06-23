package com.sxw.learn.juc.future;

import lombok.val;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 主要包括 CompletableFuture 对以下方面API的练习
 * - 获取结果和触发计算
 * - 对结算结果进行处理
 * - 对计算结果进行消费
 * - 对计算速度进行选用
 * - 对计算结果进行合并
 *
 * https://mp.weixin.qq.com/s/ZN-UgWGVx-LgjlCU8z36xg
 */
public class CompletableFutureApiDemo {
    public static void main(String[] args) {
//        val supplyAsync = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "abc";
//        });
//
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // 没有计算完给一个替代结果，不阻塞
//        val supplyAsyncNow = supplyAsync.getNow("xxx");
//        System.out.println("supplyAsyncNow：" + supplyAsyncNow);
//
//        // 是否打断get方法 返回括号值
//        val complete = supplyAsync.complete("complete value");
//        System.out.println("complete：" + complete + "/" + supplyAsync.join());
//
        /**
         * 对计算结果进行处理 thenApply / handle 正常情况下二者没什么区别，区别就在于异常发生时的处理方式
         * 计算结果存在依赖，两个线程串行化
         * thenApply 当前步骤存在异常，就停止运行
         * handle 有异常也可以继续往下走，根据带的异常参数进一步处理
         */
//        val executorService = Executors.newFixedThreadPool(3);
//        val future = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("111");
//            return 1;
//        },executorService).handle((f,e) -> {
//            int i = 10 / 0;
//            System.out.println("222");
//            return f + 1;
//        }).handle((f,e) -> {
//            System.out.println("333");
//            return f + 1;
//        }).whenComplete((v,e) -> {
//            if (e == null){
//                System.out.println("计算结果:" + v);
//            }
//        }).exceptionally(e -> {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            return null;
//        });
//        System.out.println("主线程去忙其它任务了....");
//        executorService.shutdown();

        /**
         * 对处理结果进行消费，无返回结果
         * thenRun VS thenAccept VS thenApply
         * thenRun:任务A执行完执行任务B，并且B不需要A对结果
         * thenAccept：任务A执行完执行任务B，B需要A的结果，但是B没有返回值
         * thenApply：任务A执行完执行任务B，B需要A的结果，并且B有返回值
         */
//        CompletableFuture.supplyAsync(() -> 1).thenAccept(System.out::println);

        /**
         * 计算速度进行选用
         *
         */
//        val aComeIn = CompletableFuture.supplyAsync(() -> {
//            System.out.println("A come in");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "playA";
//        });
//
//        val bComeIn = CompletableFuture.supplyAsync(() -> {
//            System.out.println("B come in");
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "playB";
//        });
//
//        val result = aComeIn.applyToEither(bComeIn, f -> f + " is winner");
//        System.out.println(Thread.currentThread().getName() + "\t" + result.join());

        /**
         * 对结算结果进行合并
         */
        val futureA = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "启动");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        val futureB = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "启动");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });

        val thenCombine = futureA.thenCombine(futureB, (x, y) -> {
            System.out.println("开始两个结果的合并");
            return x + y;
        });
        System.out.println("最终合并的结果为:" + "\t"+ thenCombine.join());
    }
}
