package com.sxw.learn.leetcode.window;

/**
 * [题目]: 长度最小的子数组(209)
 * [题目描述]:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回0。
 * 示例：target = 7, nums = [2,3,1,2,4,3]
 * [解题思路]:
 * 滑动窗口
 * 没超过target，右指针移动
 * 超过了target更新答案，右指针向右移动的同时，不断更新左边界，因为右边可能进来一个极大的数，这样的话左边界可以大大往右移动
 * 时间复杂度：O(n)，因为指针 start和end最多各移动 n 次。
 * 空间复杂度：O(1)
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        // 容易犯的错误：
        // 1、设置为0，这样的话一直min运算，最后都是 0
        // 2、在没有返回值时，需要将MAX_VALUE处理为 0
        int ans = Integer.MAX_VALUE;
        while (end < n) {
            sum = sum + nums[end];
            if (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                while (start <= end && sum - nums[start] >= target) {
                    sum = sum - nums[start];
                    start++;
                    ans = Math.min(ans, end - start + 1);
                }
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MinSubArrayLen solution = new MinSubArrayLen();
        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int i = solution.minSubArrayLen(target, arr);
        System.out.println(i);
    }
}
