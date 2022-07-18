package com.sxw.learn.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 *
 * 使用 StopWatch 优雅打印执行耗时
 * https://mp.weixin.qq.com/s/39YTm82iQ12-F6vgty5Arw
 */
@Slf4j
public class SpringStopWatchExample {
    public static void main (String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch("销售统计");
        sw.start("团长订单数据");
        Thread.sleep(5000);
        sw.stop();
        sw.start("渠道订单数据");
        Thread.sleep(3000);
        sw.stop();
        sw.start("达人订单数据");
        Thread.sleep(2000);
        sw.stop();

        log.info("耗时占比统计:[{}]", sw.prettyPrint());
        log.info("总耗时(秒):[{}]", sw.getTotalTimeSeconds());
        log.info("总耗时(毫秒):[{}]", sw.getTotalTimeMillis());
        log.info("最后一次任务[{}]总耗时(毫秒):[{}]", sw.getLastTaskName(), sw.getLastTaskTimeMillis());
        log.info("简短的总耗时描述:[{}]", sw.shortSummary());
        log.info("任务的数量:[{}]", sw.getTaskCount());
        // 遍历每个任务的详情
        Arrays.stream(sw.getTaskInfo()).forEach(e -> log.info("taskName:[{}], second:[{}]", e.getTaskName(), e.getTimeSeconds()));
    }
}
