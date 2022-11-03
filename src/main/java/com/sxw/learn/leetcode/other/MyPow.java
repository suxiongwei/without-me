package com.sxw.learn.leetcode.other;

/**
 * [题目]: Pow(x, n)(50)
 * [题目描述]:
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
 *
 * [解题思路]:
 * 快速幂 + 递归
 * 时间复杂度：O(logn)，即为递归的层数。
 * 空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
 */
public class MyPow {
    public double myPow(double x, int n) {
        return n < 0 ? 1 / quickMul(x, -n) : quickMul(x, n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return (n & 1) == 1 ? y * y * x : y * y;
    }

    public static void main(String[] args) {
        MyPow solution = new MyPow();
        double v = solution.myPow(2.0, 10);
        System.out.println(v);
    }
}
