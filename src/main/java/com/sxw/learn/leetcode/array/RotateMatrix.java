package com.sxw.learn.leetcode.array;

/**
 *
 * [题目]: 旋转图像(48)
 * [题目描述]:
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 00 01 02 03 04
 * 10 11 12 13 14
 * 20 21 22 23 24
 * 30 31 32 33 34
 * 40 41 42 43 44
 *
 * [解题思路]:
 * 先上下翻转，后对角线翻转
 */
public class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        if (matrix == null) return;
        // 行 & 列
        int N = matrix[0].length;
        // 1、上下翻转
        for (int i = 0; i < (N / 2); i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[N - i - 1];
            matrix[N - i - 1] = temp;
        }
        // 2、对角线翻转
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
