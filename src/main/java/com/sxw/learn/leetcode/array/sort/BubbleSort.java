package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i++){
            boolean flag = false;// 用来标记数组是否为有序，如果经过一次冒泡没有发生数据的交换，说明当前数组已经有序，直接返回即可
            for (int j = 0; j < n - i - 1; j++){
                if (a[j] > a[j + 1]){
                    swap(a, j, j + 1);
                    flag = true;// 表示有数据交换
                }
            }
            if (!flag) break;// 没有数据交换，提前退出
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,1,3,2};
        bubbleSort(a, a.length);
//        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
