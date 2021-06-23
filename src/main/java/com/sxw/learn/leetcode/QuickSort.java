package com.sxw.learn.leetcode;

import java.util.Arrays;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-01 7:31 下午
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        // 原始数组 2, 1, 7, 9, 5, 8
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 原始数组 2, 1, 7, 9, 5, 8
        // 随机挑选最左边的元素为基准值
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; i++){// 循环将小于基准值的在基准值的后面依次添加
            if (arr[i] < arr[pivot]){
                swap(arr, i, index);
                index ++;// 基准值的位置
            }
        }
        swap(arr, pivot, index - 1);// 在上面依次添加完之后，交换基准值原始位置和比较后该处于的位置
        return index - 1;
    }

    /**
     * 交换两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{2, 1, 7, 9, 5, 8};
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sortArray(arr);
        System.out.println(Arrays.toString(sort));
    }
}
