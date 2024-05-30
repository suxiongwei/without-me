package com.sxw.learn.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * 给你一个整型数组 nums,在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * 
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *
 * 处理思路：
 * 需要考虑到负数，因此需要分情况讨论
 * 先排序
 *
 * 至于只有一个负数的情况，在max的时候肯定是
 */
public class MaximumProduct {
    // 直接版本，先进行了排序，时间复杂度是排序的时间复杂度，其实不需要全局排序，因为只需要知道最大的3个数和最小的2个数即可
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // 至于只有一个负数的情况，在max的时候肯定是case2的值大了
        int case1 = nums[0] * nums[1] * nums[len - 1];
        int case2 = nums[len - 3] * nums[len - 2] * nums[len - 1];
        return Math.max(case1, case2);
    }

    // 相比排序,使用线性扫描,效率更高
    public static int maximumProductNew(int[] nums) {
        // 更新最大最小元素 重要的判断是要区分门槛元素
        int min1 = Integer.MAX_VALUE; // 最小的
        int min2 = Integer.MAX_VALUE; // 第二小
        int max1 = Integer.MIN_VALUE; // 最大的
        int max2 = Integer.MIN_VALUE; // 第二大
        int max3 = Integer.MIN_VALUE; // 第三大

        int len = nums.length;

        for (int i = 0; i < len; i++){
            int cur = nums[i];
            // 计算最小值
            if (cur < min1){
                min2 = min1;
                min1 = cur;
            }else if (cur < min2){
                min2 = cur;
            }
            // 计算最大值
            if (cur > max1){
                max3 = max2;
                max2 = max1;
                max1 = cur;
            } else if (cur > max2) {
                max3 = max2;
                max2 = cur;
            } else if (cur > max3) {
                max3 = cur;
            }

        }
        // 至于只有一个负数的情况，在max的时候肯定是case2的值大了
        int case1 = min1 * min2 * max1;
        int case2 = max3 * max2 * max1;
        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int i = maximumProductNew(nums);
        System.out.println(i);
    }
}
