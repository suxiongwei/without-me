package com.sxw.learn.leetcode.array;

/**
 * [题目]: 下一个更大元素III(556)
 * [题目描述]:
 * 给你一个正整数 n，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n。
 * 如果不存在这样的正整数，则返回 -1 。
 * 注意，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * [解题思路]:
 * 参见：下一个排列(31)
 */
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        // 找较小数与较大数，如果找不到较小数，说明当前数组不存在下一个排列
        int N = nums.length;
        int small = -1;// 找尽量靠右的较小数
        for (int i = N - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]) {
                small = i;
                break;
            }
        }
        if (small == -1){// 没有找到较小数，说明当前数组不存在下一个排列，直接return
            return -1;
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
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
