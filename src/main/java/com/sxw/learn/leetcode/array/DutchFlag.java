package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 *
 */
/**
 * [题目]: 荷兰国旗问题 / 颜色分类(75)
 * [题目描述]:
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * [解题思路]:
 * 双指针
 */
public class DutchFlag {
    /**
     * 问题一：
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边，要求额外空间复杂度O(1),时间复杂度O(N)
     *
     * 问题二：荷兰国旗问题
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边，要求额外空间复杂度O(1),时间复杂度O(N)
     *
     * 以上两个问题，都可以用以下解法
     * partition的流程：
     * 1）将整个数组左边划分为小于区域，下标初始值为-1，右边划分为大于区域，下标初始值为r+1
     * 2）当i位置的数小于num时，当前数arr[i]与小于区域下一个数交换，小于区右扩，i++
     * 3) 当i位置的数大于num时，当前数arr[i]与大于区域上一个数交换，大于区左扩，i原地不变（因为此时i位置的数没有看过）
     * 4）当i位置的数等于num时，i++
     */
    public static void partition(int[] arr, int num){
        if (arr == null) return;
        // 左边界
        int lessEqual = -1;
        // 右边界
        int moreEqual = arr.length;
        int index = 0;
        while (index < moreEqual){
            if (arr[index] < num){
                swap(arr, ++lessEqual, index++);
            }else if (arr[index] == num){
                index++;
            }else {
                swap(arr, --moreEqual, index);
            }
        }
    }


    /**
     * 交换两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,3,5,6,1,3,2};
        partition(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
