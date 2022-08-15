package com.sxw.learn.leetcode.bit;

/**
 * [题目]: 如何判断整数是否是2、3、4的乘方（幂）
 * 乘方数的重要性质：已知整数M是整数n的乘方即M = n ^ i，若将M表示为n进制的数，则该数的第i位为1，其他所有位为0。
 */
public class PowerOfX {
    // 判断整数是否是2的乘方（幂）
    public static boolean PowerOfTwo(int num){
        /**
         * 如8: 1000
         *   7:  111
         */
        return (num & (num - 1)) == 0;
    }

    // 判断整数是否是4的乘方（幂）
    // 由乘方数的上述性质，4的乘方数一定是2的乘方数，但是4的乘方数的二进制的偶数位上为0，奇数位上为1。
    // 因此需要在判断是2的乘方数的基础上，对1出现的位置进进行判断。
    public static boolean PowerOfFour(int num){
        /**
         * 0x55555555 的偶数位为0，奇数位为1，对应二进制为：1010101010101010101010101010101
         * 如16:                           10000
         *       1010101010101010101010101010101
         */
        return (num & (num - 1)) == 0 && ((num & 0x55555555) != 0);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(0x55555555));
    }
}
