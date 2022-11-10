package com.sxw.learn.leetcode.window;

/**
 * [题目]: 最大连续1的个数III(1004)
 * [题目描述]:
 * 给定一个二进制数组nums和一个整数 k，如果可以翻转最多k个0 ，则返回数组中连续 1 的最大个数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 *             [0,0,0,1,1,1,0,0,0,0,1]
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * [解题思路]:
 * 滑动窗口
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum = rsum + (1 - nums[right]);
            while (lsum < rsum - k) {
                lsum = lsum + (1 - nums[left]);
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        LongestOnes solution = new LongestOnes();
        solution.longestOnes(nums, 2);
    }
}
