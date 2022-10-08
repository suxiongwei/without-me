package com.sxw.learn.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 螺旋矩阵(54)
 * [题目描述]:
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * [解题思路]:
 * 按层模拟
 * 左上角位于 (top,left)，右下角位于 (bottom,right)
 * 层层往里缩进
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && bottom >= top) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {// left < right 避免{{3}, {2}};不从右往左就从下往上 / top < bottom 避免{{6, 9, 7}}，不往下走就
                for (int column = right - 1; column > left; column--) {// 不包含左边界，左边界的值让从下往上时的遍历时获取
                    result.add(matrix[bottom][column]);// bottom需要能大于top，否则就遍历的同一行
                }
                for (int row = bottom; row > top; row--) {
                    result.add(matrix[row][left]);// left需要能大于right，否则就遍历的同一列
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{3}, {2}};
        int[][] matrix = {{6, 9, 7}};
        SpiralOrder solution = new SpiralOrder();
        solution.spiralOrder(matrix);
    }
}
