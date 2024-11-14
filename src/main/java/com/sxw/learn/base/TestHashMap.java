package com.sxw.learn.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> stringStringMap = Collections.synchronizedMap(map);
//        ConcurrentHashMap
    }
}
