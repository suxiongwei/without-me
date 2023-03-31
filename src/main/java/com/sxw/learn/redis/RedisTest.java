package com.sxw.learn.redis;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-04 10:07 下午
 */
public class RedisTest {
    public void jedisSet(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("deer", "deer");
//        jedis.close();
    }

    public void jedisGet(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String deer = jedis.get("deer");
        System.out.println(deer);
        jedis.close();
    }


    public void testSortedSet(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 模拟100万 SKU
        for (int i = 0; i < 1000000; i++){
            String skuId = "gjr-goods-" + i;
            System.out.println(skuId);
            // 模拟100条订单
            int goodsNum = (int) (Math.random() * 4000);
            for (int j = 0; j < goodsNum; j++){
                // 模拟下单时间
                long score = (long) (System.currentTimeMillis() + Math.random() * 100);
                // 模拟订单编号
                String runNumAndPrice = j + "#" + Math.random() * 100;
                jedis.zadd(skuId, score, runNumAndPrice);
                System.out.println(runNumAndPrice);
            }
        }
        jedis.close();
    }

    public void testMap(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String name = "gjr-goods";

        int orderCount = 0;
        // 模拟100万 SKU
        for (int i = 0; i < 10000; i++){
            // 模拟100条订单
            int goodsNum = (int) (Math.random() * 4000);
            orderCount = orderCount + goodsNum;
            String skuId = "12345678" + goodsNum;
            Map<String, String> maps = new HashMap<>();
            for (int j = 0; j < goodsNum; j++){
                // 模拟下单时间
                long score = (long) (System.currentTimeMillis() + Math.random() * 100);
                // 模拟订单编号
                String runNum = j + "12345678" + Math.random() * 100;
                double price = Math.random() * 100;

                maps.put(skuId + "#" + runNum, score + "#" + String.format("%.2f",price));

            }
            System.out.println(i);
            if (maps.size() != 0){
                jedis.hmset(name, maps);
            }else {
                System.out.println("map size is empty");
            }
        }
        jedis.close();
        System.out.println(orderCount);
    }

    public void testMap1(){
        Jedis jedis = new Jedis("127.0.0.1", 6379, 100000);
        String name = "gjr-goods";

        int orderCount = 0;
        // 模拟100万 SKU
        Map<String, String> maps = new HashMap<>();
        for (int i = 0; i < 10000; i++){
            // 模拟100条订单
            int goodsNum = (int) (Math.random() * 4000);
            orderCount = orderCount + goodsNum;
            String skuId = "12345678" + goodsNum;

            List<String> orderList = Lists.newArrayList();
            for (int j = 0; j < goodsNum; j++){
                // 模拟订单编号
                String runNum = j + "12345678" + Math.random() * 100;
                int runNumHash = runNum.hashCode();
                double price = Math.random() * 100;

                orderList.add(runNumHash + "#" + String.format("%.2f",price));
            }
            maps.put(skuId, JSON.toJSONString(orderList));
            System.out.println(i);
        }
        jedis.hset(name, maps);
        // 20070969 条数据，150M
        System.out.println(orderCount);

        jedis.close();
    }


    public static void main(String[] args) {
        RedisTest redisTest = new RedisTest();
//        redisTest.jedisSet();
//        redisTest.jedisGet();

        redisTest.testMap1();
    }
}
