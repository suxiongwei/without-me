package com.sxw.learn.rate.limit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class RateTest {

    @SneakyThrows
    public static void test(int clientSize) {
        CountDownLatch downLatch = new CountDownLatch(clientSize);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(clientSize);
        IntStream.range(0, clientSize).forEach(i ->
                fixedThreadPool.submit(() -> {
                    RestTemplate restTemplate = new RestTemplate();
                    ResponseResult forObject = restTemplate.getForObject("http://localhost:8080/limit1", ResponseResult.class);
                    log.info("ResponseResult:[{}]", forObject);
                    downLatch.countDown();
                })
        );
        downLatch.await();
        fixedThreadPool.shutdown();
    }

    public static void main(String[] args) {
        test(10);
    }
}
