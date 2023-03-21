package com.sxw.learn.leetcode.backtrack;

/**
 * [题目]: 目标和(494)
 * [题目描述]:
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * [解题思路]:
 * 回溯
 */
public class FindTargetSumWays {
    int res = 0;

    // 一把过
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }

    // 代表从当前位置curStart找target - curSum
    public void dfs(int[] nums, int target, int curStart, int curSum) {
        // 已经遍历完数组
        if (curStart == nums.length) {
            if (target == curSum) {
                res++;
            }
            return;
        }
        // 处理加
        dfs(nums, target, curStart + 1, curSum + nums[curStart]);
        // 处理减
        dfs(nums, target, curStart + 1, curSum - nums[curStart]);
    }
}
