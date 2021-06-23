package com.sxw.learn.leetcode;

import java.util.Arrays;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-03 3:44 下午
 */
public class MergeSort {

    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 判断是否只剩下最后一个元素
        if (arr.length < 2){
            return arr;
        }
        // 从中间将数组分成两个部分
        int middle = (int) Math.floor(arr.length / 2);
        // copyOfRange 包括下标from，不包括上标to
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        // 分别递归地将左右两半排好序
        int[] leftResult = sort(left);
        int[] rightResult = sort(right);
        // 将排好序的左右两半合并
        return merge(leftResult, rightResult);
    }

protected int[] merge(int[] left, int[] right){
    int[] result = new int[left.length + right.length];
    int i = 0;
    // 每次只取两个数组中最小的一个元素，并将其移除出去
    while (left.length > 0 && right.length > 0) {
        // 左边的数小于右边的数，将左边的数拷贝到合适的位置，并将其移除出数组。
        if (left[0] <= right[0]) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        } else {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
    }

    // 右半边的数都处理完毕，只剩下左半边的数，只需要将左半边的数逐个拷贝过去就好。
    while (left.length > 0) {
        result[i++] = left[0];
        left = Arrays.copyOfRange(left, 1, left.length);
    }
    // 左半边的数都处理完毕，只剩下右半边的数，只需要将右半边的数逐个拷贝过去。
    while (right.length > 0) {
        result[i++] = right[0];
        right = Arrays.copyOfRange(right, 1, right.length);
    }

    return result;
}

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 7, 9, 5, 8};

        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
