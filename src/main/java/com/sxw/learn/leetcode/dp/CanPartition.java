package com.sxw.learn.leetcode.dp;

import java.util.Arrays;

/**
 * [题目]: 分割等和子集(416)
 * [题目描述]:
 * 给你一个 只包含正整数的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * [解题思路]:
 * 动态规划
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j。
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            // 不选取任何正整数，则被选取的正整数等于 0, 因此都为true
            dp[i][0] = true;
        }
        // 当 i==0 时，只有一个正整数 nums[0] 可以被选取
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    // 当前的数字 nums[i]，可以选取也可以不选取 是或的关系
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    // 当前的数字 nums[i] 不能选
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 输出DP信息
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        CanPartition solution = new CanPartition();
        boolean b = solution.canPartition(nums);
        System.out.println(b);
    }
}
