package com.sxw.learn.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 测试guava提供的限流算法
 */
public class RateLimiterTest {
    /**
     * 平滑突发限流
     * 使用RateLimiter的静态方法创建一个限流器，设置每秒放置的令牌数为5个。返回的RateLimiter对象可以保证1秒内不会给超过5个令牌，并且以固定速率进行放置，达到平滑输出的效果。
     */
    public void testSmoothBursty() {
        RateLimiter r = RateLimiter.create(5);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire() + "s");
        }
        /**
         * output: 基本上都是0.2s执行一次，符合一秒发放5个令牌的设定。
         * get 1 tokens: 0.0s
         * get 1 tokens: 0.182014s
         * get 1 tokens: 0.188464s
         * get 1 tokens: 0.198072s
         * get 1 tokens: 0.196048s
         * get 1 tokens: 0.197538s
         * get 1 tokens: 0.196049s
         */
    }

    public static void main(String[] args) {
        RateLimiterTest test = new RateLimiterTest();
        test.testSmoothBursty();
    }
}
