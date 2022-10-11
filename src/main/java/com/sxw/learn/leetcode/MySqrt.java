package com.sxw.learn.leetcode;

/**
 * [题目]: x的平方根(69)
 * [题目描述]:
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * [解题思路]:
 */


public class MySqrt {
    public int sqrt(int x){
        if (x == 0) return 0;
        long left = 1;
        long right = x >> 1;
        while (left < right){
            long mid = ((left + right) >> 1) + 1;// 先算数运算符 后位移运算符
            if (mid > x / mid){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        MySqrt solution = new MySqrt();
        int sqrt = solution.sqrt(10);
        System.out.println(sqrt);
    }
}
