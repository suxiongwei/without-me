package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 完全平方数(279)
 * [题目描述]:
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * [解题思路]:
 * 动态规划
 * 假设当前枚举到 j，那么我们还需要取若干数的平方，构成 i−j^2
 * 此时我们发现该子问题和原问题类似，只是规模变小了。这符合了动态规划的要求
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];// 表示最少需要多少个数的平方来表示整数 i。
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;// 加一代表一个固定的转移方式，在上面循环中挑选了一个最小的dp[i],再加上对应的那个j(这是一个步骤)，因此在此处加一
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares solution = new NumSquares();
        int i = solution.numSquares(12);
        System.out.println(i);
    }
}
