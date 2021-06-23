package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-12 2:29 下午
 */
public class MinPathSum {
    // public int minPathSum(int[][] grid) {
    //     if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    //     int rows = grid.length;
    //     int columns = grid[0].length;
    //     int dp[][] = new int[rows][columns];
    //     dp[0][0] = grid[0][0];
    //     // 第一行的只有一条路
    //     for (int i = 1; i < columns; i++) {
    //         dp[0][i] = dp[0][i - 1] + grid[0][i];
    //     }
    //     // 第一列只有一条路
    //     for (int i = 1; i < rows; i++) {
    //         dp[i][0] = dp[i - 1][0] + grid[i][0];
    //     }
    //     for (int i = 1; i < rows; i++) {
    //         for (int j = 1; j < columns; j++) {
    //             dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
    //         }
    //     }
    //     return dp[rows - 1][columns - 1];
    // }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        // 第一行的只有一条路
        for (int i = 1; i < columns; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        // 第一列只有一条路
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[rows - 1][columns - 1];
    }
}

