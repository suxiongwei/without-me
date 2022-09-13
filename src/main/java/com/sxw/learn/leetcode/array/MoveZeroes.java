package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]:移动零(283)
 * [题目描述]:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * [解题思路]: 双指针
 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                swap(nums, i, j);
                j++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        /**
         * i = 0,j = 0 / 0 1 0 3 12
         * i = 1 j = 1 / 1 0 0 3 12
         * i = 2 j = 1 / 1 0 0 3 12
         * i = 3 j = 2 / 1 3 0 0 12
         * i = 4 j = 3 / 1 3 12 0 0
         */
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
