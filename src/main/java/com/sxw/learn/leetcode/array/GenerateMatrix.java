package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]: 螺旋矩阵II(59)
 * [题目描述]:
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * [解题思路]:
 * 与 螺旋矩阵(54) 一致
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        while (left <= right && bottom >= top) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {// left < right 避免{{3}, {2}};不从右往左就从下往上 / top < bottom 避免{{6, 9, 7}}，不往下走就
                for (int column = right - 1; column > left; column--) {// 不包含左边界，左边界的值让从下往上时的遍历时获取
                    matrix[bottom][column] = num;// bottom需要能大于top，否则就遍历的同一行
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;// left需要能大于right，否则就遍历的同一列
                    num++;
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenerateMatrix solution = new GenerateMatrix();
        int[][] ints = solution.generateMatrix(3);
        Arrays.stream(ints).forEach(i -> System.out.println(Arrays.toString(i)));
    }
}
