package com.sxw.learn.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [题目]: 三数之和(15)
 * [题目描述]:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * [解题思路]:
 * 先排序，然后两层循环，利用排序后数据的性质加速查找
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;// 需要和上一次枚举的值不相同
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;// 需要和上一次枚举的数不相同
                while (second < third && nums[second] + nums[third] > target) third--;// 如果两数之和大于target，缩小右边界
                if (second == third) break;// 如果指针重合，随着 b 后续的增加 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
