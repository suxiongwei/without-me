package com.sxw.learn.leetcode.array.sort;

public class Test {
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
