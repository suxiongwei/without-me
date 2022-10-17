package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 最长重复子数组(718)
 * [题目描述]:
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * 示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * [解题思路]:
 * 动态规划
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return ans;
        }
        int m = nums1.length;
        int n = nums2.length;
        // 定义DP数组，dp[i][j]代表nums1的i位置和nums2的j位置的最长重复长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {// 不需要判断else 不赋值默认为0
                    dp[i][j] = dp[i + 1][j + 1] + 1;// 初始化 dp[i + 1][j + 1] = 0
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        /**
         * 上述数组的动态规划表如下
         *      0  1  2  3  4  5
         * 0   [0, 0, 1, 0, 0, 0]
         * 1   [0, 1, 0, 0, 0, 0]
         * 2   [3, 0, 0, 0, 0, 0]
         * 3   [0, 2, 0, 0, 0, 0]
         * 4   [0, 0, 1, 0, 0, 0]
         * 5   [0, 0, 0, 0, 0, 0]
         */
        FindLength solution = new FindLength();
        int length = solution.findLength(nums1, nums2);
        System.out.println(length);
    }
}
