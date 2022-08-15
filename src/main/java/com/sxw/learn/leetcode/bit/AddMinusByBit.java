package com.sxw.learn.leetcode.bit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddMinusByBit {
    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;// 亦或运算相当于无进位相加
            log.info("a:[{}],b:[{}]", Integer.toBinaryString(a), Integer.toBinaryString(b));
            b = (a & b) << 1;// 获取进位信息，进位信息迟早会变成0
            a = sum;
            log.info("new a[{}],b:[{}]",Integer.toBinaryString(a), Integer.toBinaryString(b));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 6));
    }
}
