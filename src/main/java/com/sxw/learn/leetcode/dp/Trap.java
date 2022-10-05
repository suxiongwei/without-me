package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 接雨水(42)
 * [题目描述]:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * [解题思路]:
 * 一格一格的算，每个格能接的雨水取决于当前高度 与 左边的最大高度和右边的最大高度
 * 动态规划解法
 * 建立左边/右边最高的墙的高度的动态数组加速计算
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Trap {
    public int trap(int[] height) {
        /**
         * height:   0,1,0,2,1,0,1,3,2,1,2,1
         * leftMax:  0,0,1,1,2,2,2,2,3,3,3,3 最左边的直接置为0
         * rightMax: 3,3,3,3,3,3,3,2,2,2,1,0 最右边的直接置为0
         */
        int length = height.length;
        int sum = 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 0; i < length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        trap.trap(height);
    }
}
