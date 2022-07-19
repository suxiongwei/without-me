package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 堆的性质：
 * 左孩子：2 * i + 1
 * 右孩子：2 * i + 2
 * 父亲：i - 1 / 2
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {// O(N)
            heapInsert(arr, i);// O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){// O(N)
            heapify(arr, 0, heapSize);// O(logN)
            swap(arr, 0, --heapSize);// O(1)
        }

    }

    // 某个数现在处于index位置，往上移动
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子的下标
        int left = 2 * index + 1;
        while (left < heapSize){// 下方还有孩子
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;// 两个孩子中，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;// 父亲和较大的孩子比较，谁的值大，把下标给largest
            if (largest == index){
                return;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,3,5,6,1,3};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
