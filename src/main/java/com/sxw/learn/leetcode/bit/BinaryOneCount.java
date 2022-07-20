package com.sxw.learn.leetcode.bit;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-04 7:52 下午
 */
public class BinaryOneCount {
    private int hammingWeight(int n){
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
        BinaryOneCount binaryOneCount = new BinaryOneCount();
        int i = binaryOneCount.hammingWeight(11);
        System.out.println(i);
    }
}
