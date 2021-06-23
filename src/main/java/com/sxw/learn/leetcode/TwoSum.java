package com.sxw.learn.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-10 4:23 下午
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
