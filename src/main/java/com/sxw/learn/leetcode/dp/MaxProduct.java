package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 乘积最大子数组(152)
 * [题目描述]:
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32 位 整数。
 * 子数组 是数组的连续子序列。
 * [解题思路]:
 * 使用动态规划
 * 但是在转移方程中需要考虑到正负数的情况
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 定义以当前位置截止的最大值与最小值，进行状态转移
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
        }
        int ans = dpMax[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] arr = {2, 3, -2, 4};
        int i = solution.maxProduct(arr);
        System.out.println(i);
    }
}
