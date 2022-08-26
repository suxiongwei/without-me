package com.sxw.learn.leetcode.array;

/**
 * [题目]:
 * 给定一个元素为非负整数的二维数组matrix，每行和每列都是从小到大排序的。
 * 再给定一个非负整数aim，请判断aim是否在matrix中。
 * [解题思路]:
 * 1   2   3   4   5
 * 6   7   8   9   10
 * 11  12  13  14  15
 * 16  17  18  19  20
 * 21  22  23  24  25
 *
 * 从右上角出发
 *
 * [扩展题目]:
 * 对于一个只有01的二维数组，0始终在1的左边，返回具有1最多的行
 */
public class SearchInDoubleArray {
    public static boolean isInDoubleArray(int[][] arr,int num){
        if(arr == null || num < 0) return false;
        int m = arr.length;// 行数
        int n = arr[0].length;// 列数
        int row = 0;// 当前行号
        int col = n -1;// 当前列号，i和j确定了初始位置在右上角
        while (row < m && col >= 0){
            if (num == arr[row][col]) return true;
            if (num < arr[row][col]){
                col--;// 比当前数小，往左移动
            }else {
                row++;// 比当前数大，往下移动
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,4},
                {5,6}
        };
        boolean result = isInDoubleArray(arr, 3);
        System.out.println(result);
    }
}
