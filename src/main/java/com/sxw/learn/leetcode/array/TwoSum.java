package com.sxw.learn.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [题目]:两数之和II-输入有序数组(167)
 * [题目描述]:
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * [解题思路]: 双指针
 */
public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])){
//                return new int[]{i, map.get(nums[i])};
//            }else {
//                map.put(target - nums[i], i);
//            }
//        }
//        return new int[0];
//    }

    public int[] twoSum(int[] numbers, int target) {
        int down = 0;
        int up = numbers.length - 1;
        while (down <= up) {
            int sum = numbers[down] + numbers[up];
            if (sum == target) return new int[]{down + 1, up + 1};
            if (sum > target) {// 由于是非递减，右边界的数和谁也组不成结果，则需要将右边界缩短
                up--;
            } else {// 由于是非递减，左边界的数和谁也组不成结果，则需要将左边界缩短
                down++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
