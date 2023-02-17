package com.sxw.learn.redis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedissonDelayQueueController {

    @Resource
    private RedissonDelayQueue redissonDelayQueue;

    @GetMapping("/add")
    public void addTask(@RequestParam("task") String task) {
        redissonDelayQueue.offerTask(task, 5);
    }

}
