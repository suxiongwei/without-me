package com.sxw.learn.leetcode.dfs;

import java.util.Arrays;

/**
 * [题目]: 被围绕的区域(130)
 * [题目描述]:
 * 给你一个m x n的矩阵 board，由若干字符'X'和'O'，找到所有被'X'围绕的区域，并将这些区域里所有的'O'用'X'填充。
 * 补充说明：
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * [解题思路]:
 * 补充说明中的信息非常终于，提示我们可以从边界的'O'开始dfs，进行感染
 * 将感染到的标记为 'S'
 *
 * 与海岛问题同样的解决办法
 */
public class Solve {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int M = board.length;// 有多少行
        int N = board[0].length; // 有多少列
        for (int i = 0; i < N; i++) {// 从上、下边界开始感染
            // 从上边界开始感染
            if (board[0][i] == 'O') {
                infect(board, 0, i, M, N);
            }
            // 从下边界开始感染，M > 1是为了避免只有一行这种输入
            if (M > 1 && board[M - 1][i] == 'O') {
                infect(board, M - 1, i, M, N);
            }

        }
        for (int i = 1; i < M - 1; i++) {// 从左、右边界开始感染，去掉第一行和最后一行的数
            if (board[i][0] == 'O') {
                infect(board, i, 0, M, N);
            }
            if (N > 1 && board[i][N - 1] == 'O') {
                infect(board, i, N - 1, M, N);
            }
        }
        // 遍历数组，将未感染的'O'修改为'X',将已经感染的'S'还原为'O'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void infect(char[][] board, int row, int col, int M, int N) {
        if (row < 0 || row >= M || col < 0 || col >= N) return;
        if (board[row][col] != 'O') return;// 不是 'O'就return，包含'X'和'S'的情况
        board[row][col] = 'S';
        infect(board, row - 1, col, M, N);
        infect(board, row + 1, col, M, N);
        infect(board, row, col - 1, M, N);
        infect(board, row, col + 1, M, N);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Solve solution = new Solve();
        solution.solve(board);

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
