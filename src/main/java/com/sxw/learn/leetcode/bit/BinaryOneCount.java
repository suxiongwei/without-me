package com.sxw.learn.leetcode.bit;

/**
 * [题目]: 二进制中1的个数
 * [解题思路]: 利用掩码和与运算的性质，从低位依次往高位判断
 */
public class BinaryOneCount {
    public static int hammingWeight(int n){
        String nBinaryString = Integer.toBinaryString(n);
        System.out.println("目标值的二进制值:" + nBinaryString);
        // 初始化掩码为1
        int mask = 1;
        int result = 0;
        for (int i = 0; i < 32; i++){
            String maskBinaryString = Integer.toBinaryString(mask);
            System.out.println("mask的二进制值:" + maskBinaryString);
            if ((n & mask) > 0){
                System.out.println("匹配到1:");
                result ++;
            }
            mask = mask << 1;
            System.out.println("-------------------------------");
        }
        return result;
    }

    public static void main(String[] args) {
        int i = BinaryOneCount.hammingWeight(11);
        System.out.println(i);
    }
}
