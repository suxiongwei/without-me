package com.sxw.learn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-17 10:13 上午
 */
public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap();
    Random rand = new Random();
    String key = getRand();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key)){
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    public String getRand(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }
}
