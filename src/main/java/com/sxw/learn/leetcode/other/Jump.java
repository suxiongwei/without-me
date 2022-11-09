package com.sxw.learn.leetcode.other;

/**
 * [题目]: 跳跃游戏II(45)
 * [题目描述]:
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * [解题思路]:
 * 贪心策略
 * https://leetcode.cn/problems/jump-game-ii/solutions/230241/tiao-yue-you-xi-ii-by-leetcode-solution/
 */
public class Jump {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;// 上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPosition = 0;// 目前能跳到的最远位置
        int steps = 0;// 跳跃次数
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,2,3};
        Jump solution = new Jump();
        int jump = solution.jump(nums);
        System.out.println(jump);
    }
}
