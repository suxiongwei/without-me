package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 *
 */
public class OtherQuestion {
    /**
     * 问题一：
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边，要求额外空间复杂度O(1),时间复杂度O(N)
     */

    /**
     * 问题二：荷兰国旗问题
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边，要求额外空间复杂度O(1),时间复杂度O(N)
     */

    public static void test(int[] arr, int num){
        if (arr == null) return;
        int p1 = 0;
        while (p1 < arr.length){
            if (arr[p1] < num){
                swap(arr, 0, p1);
            }
            p1++;
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
        int[] a = new int[]{4,5,6,1,3,2};
        test(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
