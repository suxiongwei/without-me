package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    /**
     * 插入排序，a表示数组，n表示数组大小
     * 时间复杂度O N的平方(和数据的情况有关，按照最差的情况计算)，
     * 因此比冒泡排序和选择排序要好一些，另外两种是严格的O N的平方的时间复杂度
     *
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            // 从下标为1开始进行排序,要插入的这个槽的值已经被存放了起来，
            // 因此当数据移动的时候会将前面的值移动到这个槽，也不会出现问题
            int value = a[i];
            // 记录插入的位置，第一轮是0，如果经过一次循环，j 为0，且数据没有发生移动，那么a[j+1] = a[1] = value
            // 减1是因为自己不需要和自己比较，与当前元素前面的元素比较
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动,第一次移动时这里[j+1]的位置被覆盖，但是没关系，原因是[j+1]位置的值已经被value变量存放了起来
                    // 每比前面的元素小一次，就将前面的元素往后移动，同时--j 也记录了最后需要插入槽的位置
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2};
        insertionSort(arr, arr.length);
        System.out.println("插入排序:" + Arrays.toString(arr));
    }


}
