package com.sxw.learn.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map map = new ConcurrentHashMap(21);
        map.put("1", "1");
        map.get("1");
    }
}
