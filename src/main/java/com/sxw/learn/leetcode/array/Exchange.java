package com.sxw.learn.leetcode.array;

/**
 * [题目]: 调整数组顺序使奇数位于偶数前面(剑指Offer21)
 * [题目描述]:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * [解题思路]:
 * [备注]：未记录
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & 1) == 1){// 代表是奇数
                swap(nums, left, i);
                left++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // 1,2,3,4
    }
}
