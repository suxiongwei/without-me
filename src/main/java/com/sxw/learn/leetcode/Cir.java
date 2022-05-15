package com.sxw.learn.leetcode;

/**
 * 约瑟夫环
 *
 * 约瑟夫问题是个著名的问题：N 个人围成一圈，第一个人从1开始报数，报 M 的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
 * 例如只有三个人，把他们叫做A、B、C，他们围成一圈，从A开始报数，假设报2的人被杀掉。
 * 解析：https://blog.csdn.net/u011500062/article/details/72855826
 */
public class Cir {
    /**
     * f(N,M)=(f(N−1,M)+M) % N
     */
    public static int cir(int n, int m){
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        System.out.println(cir(11, 3));
    }
}
