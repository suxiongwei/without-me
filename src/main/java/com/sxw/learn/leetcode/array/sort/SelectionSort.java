package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 空间复杂度：O1
 *
 */
public class SelectionSort {
    public static void selectSort(int[] arr){
        if (arr == null || arr.length <= 2) return;
        for (int i = 0; i < arr.length; i++){ // i～N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){ // 找i～N-1上最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;// 一直在找最小值的下标，minIndex一直在更新
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 使用位运算 亦或操作实现交换数据的值
     * 使用前提：i 与 j不是指向同一块内存地址，会被洗成0，所以不通用，这里只提供思路
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap1(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2};
        selectSort(arr);
        System.out.println("选择排序:" + Arrays.toString(arr));
    }
}
