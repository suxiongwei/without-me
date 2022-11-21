package com.sxw.learn.leetcode.greedy;

/**
 * [题目]: 跳跃游戏(55)
 * [题目描述]:
 * 给定一个非负整数数组 nums，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * [解题思路]:
 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
 * 如果可以一直跳到最后，就成功了
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        // 前n-1个元素能够跳到的最远距离
        int k = 0;
        for (int i = 0; i <= k; i++) {
            // 第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            // 更新最远距离
            k = Math.max(k, temp);
            // 如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }
}
