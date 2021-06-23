package com.sxw.learn.redis;


import redis.clients.jedis.Jedis;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-04 10:07 下午
 */
public class RedisTest {
    public void jedisSet(){
        Jedis jedis = new Jedis("127.0.0.1", 6378);
        jedis.set("deer", "deer");
        jedis.close();
    }

    public void jedisGet(){
        Jedis jedis = new Jedis("127.0.0.1", 6378);
        jedis.get("deer");
        jedis.close();
    }


    public static void main(String[] args) {

    }
}
