package com.sxw.learn.leetcode.other;

/**
 * [题目]:岛屿的最大面积(695)
 * [题目描述]:
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * [解题思路]:
 * 递归的方式将岛相邻的岛感染为2
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null) return 0;
        int N = grid.length;// 行数
        int M = grid[0].length;// 列数
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, infect(grid, i, j, N, M));
                }
            }
        }
        return res;
    }

    /**
     * 感染过程
     *
     * @param grid 原始数组
     * @param i 当前行
     * @param j 当前列
     * @param N 总行数
     * @param M 总列数
     */
    private static int infect(int[][] grid, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] != 1) return 0;
        // i,j没有越界，并且当前位置值为1，执行感染过程
        int res = 1;
        grid[i][j] = 2;
        res += infect(grid, i + 1, j, N, M);// 向下一行感染
        res += infect(grid, i - 1, j, N, M);// 向上一行感染
        res += infect(grid, i, j + 1, N, M);// 向右一列感染
        res += infect(grid, i, j - 1, N, M);// 向左一列感染
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println("海岛最大面积:" + maxAreaOfIsland(arr));
    }
}
