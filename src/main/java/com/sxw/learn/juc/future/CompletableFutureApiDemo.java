package com.sxw.learn.juc.future;

import lombok.SneakyThrows;
import lombok.val;

import java.util.concurrent.*;

/**
 * 主要包括 CompletableFuture 对以下方面API的练习
 * - 获取结果和触发计算
 * - 对结算结果进行处理
 * - 对计算结果进行消费
 * - 对计算速度进行选用
 * - 对计算结果进行合并
 * <p>
 * https://mp.weixin.qq.com/s/ZN-UgWGVx-LgjlCU8z36xg
 */
public class CompletableFutureApiDemo {
    @SneakyThrows
    public static void test1() {
        val supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        TimeUnit.SECONDS.sleep(1);

        // 没有计算完给一个替代结果，不阻塞
        val supplyAsyncNow = supplyAsync.getNow("xxx");
        System.out.println("supplyAsyncNow：" + supplyAsyncNow);

        // 阻塞的获取，通过注释此行代码可以观察complete的效果
        val supplyAsyncVal = supplyAsync.get();
        System.out.println("supplyAsyncVal：" + supplyAsyncVal);

        // 是否打断get方法 返回括号值
        val complete = supplyAsync.complete("complete value");
        System.out.println("complete：" + complete + "/" + supplyAsync.join());
    }

    @SneakyThrows
    public static void test2() {
        /**
         * 对计算结果进行处理 thenApply / handle 正常情况下二者没什么区别，区别就在于异常发生时的处理方式
         * 计算结果存在依赖，两个线程串行化
         * thenApply 当前步骤存在异常，就停止运行
         * handle 有异常也可以继续往下走，根据带的异常参数进一步处理
         */
//        val executorService = Executors.newFixedThreadPool(3);
        val executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        val future = CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("111");
                    return 1;
                }, executorService)
                .handleAsync((f, e) -> {
                    System.out.println("222");
//                    int i = 10 / 0;
                    return f + 1;
                })
                .thenApply(f -> {
                    System.out.println("333");
                    return f + 1;
                })
                .handle((f, e) -> {
                    System.out.println("444");
                    return f + 1;
                })
                .whenComplete((v, e) -> {
                    System.out.println("执行whenComplete方法");
                    if (e == null) {
                        System.out.println("计算结果:" + v);
                    }
                }).exceptionally(e -> {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    return null;
                });
        Integer res = future.get();
        System.out.println(res);
        System.out.println("主线程去忙其它任务了....");
        executorService.shutdown();
    }

    public static void test3() {
        /**
         * 对处理结果进行消费，无返回结果
         * thenRun VS thenAccept VS thenApply
         * thenRun:任务A执行完执行任务B，并且B不需要A对结果
         * thenAccept：任务A执行完执行任务B，B需要A的结果，但是B没有返回值
         * thenApply：任务A执行完执行任务B，B需要A的结果，并且B有返回值
         */
        CompletableFuture.supplyAsync(() -> 1).thenAccept(System.out::println);
        System.out.println("--------------------------test3 over--------------------------");
    }

    public static void test4() {
        /**
         * 计算速度进行选用
         *
         */
        val aComeIn = CompletableFuture.supplyAsync(() -> {
            System.out.println("A come in");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playA";
        });

        val bComeIn = CompletableFuture.supplyAsync(() -> {
            System.out.println("B come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playB";
        });

        val result = aComeIn.applyToEither(bComeIn, f -> f + " is winner");
        System.out.println(Thread.currentThread().getName() + "\t" + result.join());
    }

    public static void test5() {
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
        System.out.println("最终合并的结果为:" + "\t" + thenCombine.join());
        System.out.println("--------------------------test5 over--------------------------");
    }

    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
//        test4();
//        test5();
    }
}
