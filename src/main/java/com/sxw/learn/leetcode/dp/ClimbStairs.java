package com.sxw.learn.leetcode.dp;

/**
 * 爬楼梯(70)
 * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return n;
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];// DP方程 dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(2);
        System.out.println(i);
    }
}
