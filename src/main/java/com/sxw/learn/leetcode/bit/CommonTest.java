package com.sxw.learn.leetcode.bit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonTest {
    public static void main(String[] args) {
        int a = 7;
        // 偶数
        log.info("是否为偶数:{}", (a & 1) == 0);
        // 奇数
        log.info("是否为奇数:{}", (a & 1) == 1);
        // 乘法和除法，右移1一位是除以2，左移一位是乘以2
        log.info("左移2位:{}", a << 2);
        log.info("右移2位:{}", a >> 2);
    }
}
