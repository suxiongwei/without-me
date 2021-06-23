package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-11 5:20 下午
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
