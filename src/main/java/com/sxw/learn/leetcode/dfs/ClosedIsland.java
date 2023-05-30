package com.sxw.learn.leetcode.dfs;

/**
 * [题目]: 统计封闭岛屿的数目(1254)
 * [题目描述]:
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。
 * 岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个完全由1包围（左、上、右、下）的岛。
 * 请返回 封闭岛屿 的数目。
 * <p>
 * 输入：grid =
 * [
 * [1,1,1,1,1,1,1,0],
 * [1,0,0,0,0,1,1,0],
 * [1,0,1,0,1,1,1,0],
 * [1,0,0,0,0,1,0,1],
 * [1,1,1,1,1,1,1,0]
 * ]
 * 输出：2
 * <p>
 * [解题思路]:
 * 边界情况处理 + DFS
 */
public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int res = 0;
        // base case
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        // 处理边界情况，边界的导以及与边界相连的岛都不否和条件
        int m = grid.length;// 行数
        int n = grid[0].length; // 列数
        for (int i = 0; i < n; i++) {// 处理第一行&处理最后一行
            dfs(grid, 0, i, m, n);
            dfs(grid, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {// 处理第一列&最后一列
            dfs(grid, i, 0, m, n);
            dfs(grid, i, n - 1, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    /**
     * dfs 感染
     *
     * @param grid
     * @param i 当前行
     * @param j 当前列
     * @param M 总行数
     * @param N 总列数
     */
    public void dfs(int[][] grid, int i, int j, int M, int N) {
//        System.out.println("i=" + i + " / j=" + j + "/ M=" + M + " N=" + N);
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != 0) return;
        // i,j没有越界，并且当前位置值为1，执行感染过程
        grid[i][j] = 2;
        dfs(grid, i + 1, j, M, N);
        dfs(grid, i - 1, j, M, N);
        dfs(grid, i, j + 1, M, N);
        dfs(grid, i, j - 1, M, N);
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {1,1,1,1,1,1,1,0},
//                {1,0,0,0,0,1,1,0},
//                {1,0,1,0,1,1,1,0},
//                {1,0,0,0,0,1,0,1},
//                {1,1,1,1,1,1,1,0}
//        };

        int[][] grid = {
                {0,0,1,0,0},
                {0,1,0,1,0},
                {0,1,1,1,0}
        };
        ClosedIsland solution = new ClosedIsland();
        int i = solution.closedIsland(grid);
        System.out.println(i);
    }
}
