package com.sxw.learn.leetcode.array;

/**
 * [题目]: 缺失的第一个正数(41)
 * [题目描述]:
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * [解题思路]:
 * 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1]
 * <p>
 * 我们对数组进行遍历，对于遍历到的数x，如果它在 [1,N]的范围内，那么就将数组中的第 x−1 个位置（注意：数组下标从 0 开始）打上「标记」。
 * 在遍历结束之后，如果所有的位置都被打上了标记，那么答案是 N+1，否则答案是最小的没有打上标记的位置加 1。
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {// 因为需要找正整数，这里处理负数
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);// 将符合答案区间的数对应的数组下标打上标记
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;// 从数组的0开始遍历，找到的第一个未打上标记的就是答案
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        FirstMissingPositive solution = new FirstMissingPositive();
        int i = solution.firstMissingPositive(arr);
        System.out.println(i);
    }
}
