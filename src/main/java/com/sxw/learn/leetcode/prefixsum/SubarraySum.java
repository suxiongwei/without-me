package com.sxw.learn.leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 和为K的子数组(560)
 * [题目描述]:
 * 给你一个整数数组 nums 和一个整数 k，请你统计并返回该数组中和为 k 的连续子数组的个数。
 *
 * [解题思路]:
 * 前缀和 + Hash表
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 截止到当前元素的前缀和
        int pre = 0;
        int ans = 0;
        // 存储的是前缀和以及对应的出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 添加初始值，前缀和是从第一个元素开始的这种情况
        map.put(0, 1);
        // case nums = 1,2,3; k = 3
        for (int num : nums) {
            pre = pre + num;
            if(map.containsKey(pre - k)){
                ans = ans + map.get(pre - k);
            }
            // 更新前缀和及其出现的次数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
