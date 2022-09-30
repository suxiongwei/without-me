package com.sxw.learn.leetcode.other;

import java.util.Arrays;

/**
 * [题目]: 下一个排列（31）
 * [题目描述]:
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * [解题思路]:
 * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
 * 1、我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 * 2、同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 找较小数与较大数，如果找不到较小数，说明当前数组不存在下一个排列
        int N = nums.length;
        int small = -1;// 找尽量靠右的较小数
        for (int i = N - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]) {
                small = i;
                break;
            }
        }
        if (small == -1){// 没有找到较小数，说明当前数组不存在下一个排列，直接将当前数组逆序
            reverse(nums, 0);
            return;
        }
        int large = -1;// 找右边尽量小的较大数，因为small右边的数都是单调递增的，所以找到的第一个大于small的就是目标较大数
        for (int i = N - 1; i > small; i--){
            if (nums[i] > nums[small]) {
                large = i;
                break;
            }
        }
        swap(nums, small, large);// 交换较大数与较小数
        reverse(nums, small + 1);// 交换后，small index 后面的数是降序排列的，因此翻转之后就使得下一个排列变化幅度尽可能的小
    }

    private void reverse(int[] nums, int start) {
        int right = nums.length - 1;
        while (start < right){
            swap(nums, start++, right--);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
