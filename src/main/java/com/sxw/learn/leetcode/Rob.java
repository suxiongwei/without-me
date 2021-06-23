package com.sxw.learn.leetcode;

public class Rob {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        // dp[i] 表示前 i 间房屋能偷窃到的最高总金额，可以得到状态转移方程为:dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        int dp[] = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
