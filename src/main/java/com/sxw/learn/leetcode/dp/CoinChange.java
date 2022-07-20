package com.sxw.learn.leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    /**
     * 322. 零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
     * 你可以认为每种硬币的数量是无限的。
     * 动态规划解法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);// 设置初始值为max = amount + 1，如果金额没有匹配的零钱 dp[amount] 为amount + 1  大于 amount，因此返回 -1
        dp[0] = 0; // dp[0]原则上是-1，但是这里为了定义状态转移将其置为 0
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 记忆化搜索解法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {// 记忆化存储
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;// 找到当前rem 最小的零钱数量
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange1(new int[]{1, 2, 3}, 6);
        System.out.println(i);
    }


}
