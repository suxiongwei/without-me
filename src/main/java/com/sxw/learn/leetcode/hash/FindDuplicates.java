package com.sxw.learn.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 数组中重复的数据(442)
 * [题目描述]:
 * 给你一个长度为n的整数数组nums，其中nums的所有整数都在范围[1, n]内，且每个整数出现一次或两次。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 *
 * [解题思路]:
 * 使用正负号作为标记
 *
 * 给 nums[i] 加上「负号」表示数 i+1 已经出现过一次
 */
public class FindDuplicates {
    // 使用正负标记
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            // 当前遍历到的值，因为这个值可能被打上负数标记，因此取绝对值
            int curVal = Math.abs(nums[i]);
            // 证明当前值对应的index位置数是第一次出现，将其标记为负数
            if (nums[curVal - 1] > 0){
                nums[curVal - 1] = -nums[curVal - 1];
            }else{
                res.add(curVal);
            }
        }
        return res;
    }
}
