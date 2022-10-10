package com.sxw.learn.leetcode.dp;

import java.util.Arrays;

public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        Change solution = new Change();
        int[] coins = {1, 2};
        int amount = 3;
        int change = solution.change(amount, coins);
        System.out.println(change);
    }
}
