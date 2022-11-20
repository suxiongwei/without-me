package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 整数拆分(343)
 * [题目描述]:
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积
 * <p>
 * [解题思路]:
 * 动态规划
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // dp[x]代表 数字为x时最大乘积,0 和 1 都不能拆分，因此 dp[0]=dp[1] = 0
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            // 遍历的范围是 {1, i - 1},0和i除外，减0和减i相当于数字没有拆分
            for (int j = 1; j < i; j++) {
                // max中的两个case代表两种方案，一种是 ，一种是继续拆分
                int case1 = j * (i - j);// i−j 不再拆分
                int case2 = j * dp[i - j];// i−j 继续拆分
                curMax = Math.max(curMax, Math.max(case1, case2));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
