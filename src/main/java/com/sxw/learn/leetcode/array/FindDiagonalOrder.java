package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]: 对角线遍历(498)
 * [题目描述]:
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * [解题思路]:
 * 模拟
 */
public class FindDiagonalOrder {
    /**
     * arr:
     * 1   2   3
     * 4   5   6
     * 7   8   9
     *
     * 对应的坐标：
     * 0,0  1,0  2,0
     * 0,1  1,1  2,1
     * 0,2  1,2  2,2
     * 通过观察可以发现：每一次遍历中，x + y为一个定值
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;// 多少行，y轴
        int n = matrix[0].length;// 多少列，x轴
        int[] nums = new int[m * n];
        int k = 0;
        boolean bXFlag = true;// 用到的数据正确定位, 逻辑处理是一样的，x，y的上限值是相反的
        // 以一趟为一个单元，那么 i 就是每一趟的和
        for (int i = 0; i < m + n; i++) {
            int pm = bXFlag ? m : n;
            int pn = bXFlag ? n : m;

            int x = (i < pm) ? i : pm - 1;
            int y = i - x;

            // 结束条件：x 减到 0 或者 y 加到上限
            while (x >= 0 && y < pn) {
                nums[k++] = bXFlag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }

            bXFlag = !bXFlag;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        FindDiagonalOrder solution = new FindDiagonalOrder();
        int[] diagonalOrder = solution.findDiagonalOrder(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
