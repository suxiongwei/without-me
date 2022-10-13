package com.sxw.learn.leetcode.array;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [题目]: 四数之和(18)
 * [题目描述]:
 * 给你一个由 n 个整数组成的数组nums，和一个目标值 target。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],nums[b],nums[c],nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * [解题思路]:
 * 排序 + 双指针
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(logn)
 *
 * 防止数值计算溢出，因此需要把int转换为long，容量小的类型可自动转换为容量大的数据类型，所以只需要把一个变量强转为long即可
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length < 4) return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;// 同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素
            if ((long) nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {// 最小的几个数都组不出来，结束循环
                break;
            }
            if ((long) nums[first] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {// int型会溢出，与最大的数都组不出来，跳出此次循环
                continue;
            }
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;// 同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素
                if ((long) nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                    break;
                }
                if ((long) nums[first] + nums[second] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                int third = second + 1;
                int four = n - 1;
                while (third < four) {
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[four];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[four]));
                        while (third < four && nums[third] == nums[third + 1]) {//数值相同，指针右移
                            third++;
                        }
                        third++;
                        while (third < four && nums[four] == nums[four - 1]) {//数值相同，指针左移
                            four--;
                        }
                        four--;
                    } else if (sum < target) {
                        third++;
                    } else {
                        four--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(nums, 1000000000);
        lists.stream().forEach(e -> System.out.println(Joiner.on(",").join(e)));
    }
}
