package com.sxw.learn.leetcode.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * [题目]: 最长连续序列(128)
 * [题目描述]:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * [解题思路]: 利用set
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {// 可以从当前值开始计算连续序列，比如2、3、4、5、6，那么只有2会进入此分支
                int curNum = nums[i];
                int k = 1;// 临时变量，用来统计此段连续序列的长度
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    k++;
                }
                result = Math.max(result, k);
            }
        }
        return result;
    }
}
