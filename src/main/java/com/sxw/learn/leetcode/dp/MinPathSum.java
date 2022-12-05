package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 最小路径和(64)
 * [题目描述]:
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * [解题思路]:
 * 动态规划
 */
public class MinPathSum {
     public int minPathSum(int[][] grid) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
         int rows = grid.length;
         int columns = grid[0].length;
         int dp[][] = new int[rows][columns];
         // 将出发点单独设置值，为了在给第一行第一列设置值的时候方便（i - 1）
         dp[0][0] = grid[0][0];
         // 第一行的只有一条路
         for (int i = 1; i < columns; i++) {
             dp[0][i] = dp[0][i - 1] + grid[0][i];
         }
         // 第一列只有一条路
         for (int i = 1; i < rows; i++) {
             dp[i][0] = dp[i - 1][0] + grid[i][0];
         }
         for (int i = 1; i < rows; i++) {
             for (int j = 1; j < columns; j++) {
                 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
             }
         }
         return dp[rows - 1][columns - 1];
     }
}

