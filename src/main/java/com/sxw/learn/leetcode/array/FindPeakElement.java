package com.sxw.learn.leetcode.array;

/**
 * [题目]: 寻找峰值(162)
 * [题目描述]:
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * [解题思路]:
 * 1、方法一：寻找最大值
 * 2、方法二：迭代爬坡(可以进行二分优化)
 */
public class FindPeakElement {
    // 解法一
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    // 解法二
    // 每次二分去爬坡，只要在爬坡，就一定有下一个山峰要被越过。
    public int findPeakElement1(int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        FindPeakElement solution = new FindPeakElement();
        int peakElement1 = solution.findPeakElement1(nums);
        System.out.println(peakElement1);
    }
}
