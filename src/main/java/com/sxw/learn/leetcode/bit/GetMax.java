package com.sxw.learn.leetcode.bit;

/**
 * [题目]：给定两个有符号整数a和b，返回a和b中较大的
 */
public class GetMax {
    /**
     * 请保证参数n，不是1就是0的情况下
     * 如果n为1，返回0，如果n为0，返回1
     */
    public static int flip(int n){
        return n ^ 1;// 亦或运算
    }

    // sign函数的功能是返回整数n的符号，正数和0返回1，负数则返回0
    public static int sign(int n){
        int sign = (n >> 31) & 1;// 有符号数的最高位用来表示符号，即1表示负数，0表示正数或零。因此sign的值负数时为1，正数或零时为0
        return flip(sign);
    }

    public static int getMax(int a, int b){
        int c = a - b;
        int sca = sign(c);
        int scb = flip(sca);
        return a * sca + b * scb;
    }

    /**
     * 虽然上面的看起来没有问题，但是会有溢出问题。
     * 对于溢出只会发生在，两者符号不一致的情况下，所以我们可以先判断两者的正负号：
     * 如果a为0或正数，b为负数，则返回a
     * 如果a为负数，b为0或正数，则返回b
     */
    public static int getMax1(int a, int b){
        int c = a - b;
        int sa = sign(a);// 非负返回1
        int sb = sign(b);// 非负返回1
        int sc = sign(c);// 非负返回1
        int difSab = sa ^ sb;// 符号位不同返回1，一样返回0
        int sameSab = flip(difSab);// 符号位不同返回0，一样返回1
        int returnA = difSab * sa + sameSab * sc;// 如果符号位不同，sa非负才会返回a，如果符号位相同，差值是正的才会返回a，相当于一个加的运算实现了if的效果
        int returnB = flip(returnA);// b的判断取反即可
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = -2147483647;
        System.out.println(getMax(a, b));// 返回-2147483647，说明溢出了，结果是错误的
        System.out.println(getMax1(a, b));// 返回2147483647，结果是正确的
    }
}
