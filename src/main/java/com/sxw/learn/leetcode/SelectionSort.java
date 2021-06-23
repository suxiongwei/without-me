package com.sxw.learn.leetcode;

import java.util.Arrays;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-02 9:09 下午
 */
public class SelectionSort {
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++){
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    // 记录目前能找到的最小值元素的下标(每次找到小的数 都会更新这个指针，所以循环结束可以找到最小的数)
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 7, 9, 5, 8};
        SelectionSort selectionSort = new SelectionSort();
        int[] sort = selectionSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
