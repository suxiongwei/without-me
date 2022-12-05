package com.sxw.learn.leetcode.dfs;

/**
 * [题目]:海岛问题
 * [题目描述]:
 * 给一个01矩阵，求不同的岛屿的个数。
 * 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * [样例]:
 * [
 *   [1, 1, 0, 0, 0],
 *   [0, 1, 0, 0, 1],
 *   [0, 0, 0, 1, 1],
 *   [0, 0, 0, 0, 0],
 *   [0, 0, 0, 0, 1]
 * ]
 * 总共有3个海岛。
 * [解题思路]:
 * 递归的方式将岛相邻的岛感染为2
 *
 * [进阶]:
 * 设计一个并行算法解决这个问题
 * [解题思路]:
 * 将大数组按照CPU核心数，分割为若干小数组，在各个小数组求解
 * 然后利用并查集将各个小数组的结果进行合并，主要是边界的岛屿进行合并
 */
public class CountIslands {
    public static int countIslands(int[][] m){
        if (m == null || m[0] == null) return 0;
        int N = m.length;// 行数
        int M = m[0].length;// 列数
        int res = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    /**
     * 感染过程
     * @param m 原始数组
     * @param i 当前行
     * @param j 当前列
     * @param N 总行数
     * @param M 总列数
     */
    private static void infect(int[][] m, int i, int j, int N, int M) {
        if (i <0 || i >= N || j < 0 || j >= M || m[i][j] != 1) return;
        // i,j没有越界，并且当前位置值为1，执行感染过程
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println("海岛个数:" + countIslands(arr));
    }
}
