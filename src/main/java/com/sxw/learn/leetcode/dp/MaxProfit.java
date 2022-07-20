package com.sxw.learn.leetcode.dp;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit {
//    public int maxProfit(int[] prices) {
//        // // 动态规划版本
//        // int n = prices.length;
//        // int[][] dp = new int[n][2];
//        // dp[0][0] = 0;
//        // dp[0][1] = -prices[0];
//        // for (int i = 1; i < n; i++) {
//        //     dp[i][0] = Math.max(dp[i -1][0],dp[i - 1][1] + prices[i]);
//        //     dp[i][1] = Math.max(dp[i -1][1],dp[i - 1][0] - prices[i]);
//        // }
//        // return dp[n - 1][0];
//        int res = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; i++) {
//            res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
//        }
//        return res;
//    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 解法：动态规划、贪心算法，
     * 本解法使用动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return prices[0];
        int length = prices.length;
        // 定义状态:dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 00 开始）。
        int[][] dp = new int[length][2];
        /**
         * 定义转移方程
         * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + price)
         * dp[i][1] = max(dp[i-1][0] - price, dp[i-1][1])
         */
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i -1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 上面解法的优化版本,注意到上面的状态转移方程中，每一天的状态只与前一天的状态有关，而与更早的状态都无关，因此我们不必存储这些无关的状态，
     * 只需要将dp[i−1][0] 和 dp[i−1][1] 存放在两个变量中，通过它们计算出 dp[i][0] 和 dp[i][1] 并存回对应的变量，以便于第 i+1 天的状态转移即可。
     *
     * 利用原始数组，空间复杂度O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitAdvance(int[] prices) {
        // 第一天持有0支的收益与1支的收益
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp0 - prices[i], dp1);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }


}
