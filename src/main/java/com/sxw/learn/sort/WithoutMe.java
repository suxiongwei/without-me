package com.sxw.learn.sort;

import java.util.Arrays;

public class WithoutMe {
    public static void insertSort(int[] arr, int n){
        if (n <= 1) return;
        for (int i = 1; i < n; i++){
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--){
                if (arr[j] > value){
                    arr[j + 1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void bubbleSort(int[] arr, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i++){
            boolean flag = false;
            for (int j = 0; j < n- i- 1; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }















    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,1,3,2};
        bubbleSort(a, a.length);
        System.out.println("冒泡排序:" + Arrays.toString(a));
        a = new int[]{4,5,6,1,3,2};
        insertSort(a, a.length);
        System.out.println("插入排序:" + Arrays.toString(a));
    }
}
