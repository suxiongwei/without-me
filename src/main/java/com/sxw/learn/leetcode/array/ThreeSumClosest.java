package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]: 最接近的三数之和(16)
 * [题目描述]:
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * [解题思路]:
 * 排序 + 双指针
 */
public class ThreeSumClosest {
    private int best = 1000 * 1000;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) return target;
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    third--;
                    // 移动到下一个不相等的元素
                    if (third > second && nums[third] == nums[third - 1]) {
                        third--;
                    }
                } else {
                    second++;
                    // 移动到下一个不相等的元素
                    if (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                }
            }
        }
        return best;
    }
}
