package com.sxw.learn.juc.future;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class ShopDemo {
    private static List<Shop> shopList = Arrays.asList(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"), new Shop("BuyItAll"));

    private static List<String> findPriceSync(String product) {
        return shopList.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))  //格式转换
                .collect(Collectors.toList());
    }

    private static List<String> findPriceAsync(String product) {
        List<CompletableFuture<String>> completableFutureList = shopList.stream()
                //转异步执行
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))  //格式转换
                .collect(Collectors.toList());

        return completableFutureList.stream().map(CompletableFuture::join)  //获取结果不会抛出异常
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch("耗时统计");
        sw.start("1");
        List<String> priceList = findPriceSync("BuyItAll");
        sw.stop();
        sw.start("2");
        priceList = findPriceAsync("BuyItAll");
        sw.stop();

        log.info("占比耗时统计:{}", sw.prettyPrint());
        /**
         * ---------------------------------------------
         * ns         %     Task name
         * ---------------------------------------------
         * 4029953680  080%  1
         * 1012200529  020%  2
         */
    }
}
