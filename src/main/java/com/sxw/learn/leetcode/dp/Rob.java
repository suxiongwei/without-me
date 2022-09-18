package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 打家劫舍(198)
 * [题目描述]:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * [解题思路]: 动态规划
 */
public class Rob {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];// 偷 [0..k) 房间中的最大金额
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(nums[k - 1] + dp[k - 2], dp[k - 1]);// 当前偷与不偷两种情况取最大值
        }
        return dp[N];
    }

    // 空间优化的版本，我们发现一个dp[k]的值只用到了dp[k-1]和dp[k-2]，因此我们不需要记录整个dp数组
    // 空间复杂度 O(N) -> O(1)
    public int rob1(int[] nums) {
        int N = nums.length;
        int prev = 0;
        int curr = nums[0];
        for (int k = 2; k <= N; k++) {
            int tmp = curr;// 临时变量存储下来，因为这儿不能修改prev的值，prev还要参与下一步的运算
            curr = Math.max(nums[k - 1] + prev, curr);
            prev = tmp;
        }
        return curr;
    }
}
