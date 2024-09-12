package com.sxw.learn.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * 线程池命名
 */
public class ThreadFactoryNameLearn {
    public static void main(String[] args) {
        // 通过Spring 框架提供的CustomizableThreadFactory命名
//        ThreadFactory threadFactory = new CustomizableThreadFactory("spring线程池");
        // 通过Google guava工具类提供的ThreadFactoryBuilder命名
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("guava线程池").build();
        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), threadFactory);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread());
        });
    }
}
