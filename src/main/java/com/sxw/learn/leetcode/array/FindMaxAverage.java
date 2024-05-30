package com.sxw.learn.leetcode.array;

/**
 * 643. 子数组最大平均数I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 *
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 解题方式：滑动窗口
 */
public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;// 代表的是这个区间的总数
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }
        int index = k;
        int res = sum;
        // 窗口移动，剔除前面元素，加入后面元素，更新当前窗口的值与到目前为止的最大值
        for (; index < len; index++){
            sum = sum - nums[index - k] + nums[index];
            res = Math.max(sum, res);
        }
        return (double) res / k;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,0,3,2};
        System.out.println(findMaxAverage(nums, 1));
    }
}
