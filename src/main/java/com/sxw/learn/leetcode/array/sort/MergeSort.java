package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 整体就是一个简单递归，左边排好序，右边排好序，然后让其整体有序
 * 让其整体有序的过程中采用了外排序方法
 *
 * 时间复杂度:o(NlogN)
 * 额外空间复杂度:O(N)
 *
 * 优点：
 * 选择排序、冒泡排序为什么时间复杂度高，因为浪费了大量的比较行为，前一轮的比较对下一轮没有帮助，每一轮只搞定了一个数
 * 归并排序就避免了上述问题
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (null == arr || arr.length <= 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R){
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 剩下的元素一定是较大的元素，因为小的已经走到头了，所以直接按照从小到大往后排
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }

    /**
     * 归并排序的扩展
     * 小和问题和逆序对问题
     *
     * 小和问题：
     * 在一个数组中，每一个数左边比当前小的数累加起来，叫做这个数组的小和，求一个数组的小和
     * 例子:
     * 例子
     * [1,3,4,2,5]
     * 1左边比1小的数：没有
     * 3左边比3小的数：1
     * 4左边比4小的数：1,3
     * 2左边比2小的数：1
     * 5左边比5小的数：1,3,4,2
     * 所以小和为1+1+3+1+1+3+4+2=16
     *
     * 逆序对问题：
     * 在一个数组中，左边的数如果比右边的大，则这两个数构成一个逆序对，请打印所有逆序对
     */

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2};
        mergeSort(arr);
        System.out.println("归并排序:" + Arrays.toString(arr));
    }
}
