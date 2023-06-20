package com.sxw.learn.leetcode.array;

/**
 * [题目]:轮转数组(189)
 * [题目描述]:给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * [解题思路]:
 * 双指针
 * 做到了空间复杂度O(1)
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int length = nums.length;
        k = k % length; // 数组length = 5 k = 7 实际上含义是k = 2
        reverseArray(nums, 0, length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, length - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}
