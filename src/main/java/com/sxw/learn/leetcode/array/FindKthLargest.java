package com.sxw.learn.leetcode.array;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] arr, int L, int R, int index) {
        int q = L + (int) Math.random() * (R - L + 1);
        swap(arr, q, R);
        int[] partition = partition(arr, L, R);
        if (partition[1] == index) return q;
        return arr[partition[1]] > index ? quickSelect(arr, L, partition[0] - 1, index) : quickSelect(arr, partition[1] + 1, R, index);
    }


    public static int[] partition(int[] arr, int L, int R) {
        // 小于区右边界
        int less = L - 1;
        // 大于区左边界，之所以不是R - 1,是因为最后一个数是需要比较的数字
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {// arr[L]表示
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        // 将需要比较的数字放在合适的位置
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
