package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]:有序数组的平方(977)
 * [题目描述]:给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * [解题思路]:双指针
 */
public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int neg = -1;// 区分负数与非负数,[0,neg]都为负数,[neg+1,n-1]为正数
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) neg = i;
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[n];
        int index = 0;
        int i = neg;// 负数区间最小数的起点
        int j = neg + 1;// 非负区间的最小数的起点
        while (j < n || i >= 0){
            if (i < 0){// 负数区没有数据了
                res[index++] = nums[j++];
            }else if (j == n){// 正数区没有数据了
                res[index++] = nums[i--];
            }else if(nums[i] < nums[j]){
                res[index++] = nums[i--];
            }else {
                res[index++] = nums[j++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {-4,-1,0,3,10};
        int[] arr = {-5,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
