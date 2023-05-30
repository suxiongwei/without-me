package com.sxw.learn.leetcode.array;

/**
 * [题目]: 数组中的第K个最大元素(215)
 * [题目描述]:
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * [解题思路]:
 * 快速排序的改进 -> 快速选择
 * 快速排序的平均时间复杂度：O(nlogn)
 * 相比快排，我们只关心这一点，至于partition左右的部分是否有序完全不关心，
 * 这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法。
 * <p>
 * 我们知道快速排序的性能和「划分」出的子数组的长度密切相关。
 * 直观地理解如果每次规模为 n 的问题我们都划分成 1 和 n - 1，每次递归的时候又向 n - 1 的集合中递归，这种情况是最坏的，时间代价是 O(n ^ 2)
 * 我们可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int resIndex = quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[resIndex];
    }

    public int quickSelect(int[] arr, int L, int R, int index) {
        int q = L + (int) Math.random() * (R - L + 1);
        swap(arr, q, R);
        int[] partition = partition(arr, L, R);
        if (partition[1] == index) return partition[1];
        if (partition[1] > index) {
            return quickSelect(arr, L, partition[1] - 1, index);
        } else {
            return quickSelect(arr, partition[1] + 1, R, index);
        }
    }


    public static int[] partition(int[] arr, int L, int R) {
        // 小于区右边界
        int less = L - 1;
        // 大于区左边界，之所以不是R - 1,是因为最后一个数是需要比较的数字
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {// arr[L]表示
                less++;
                // swap的目的是因为 中间有可能会存在等于区，这样的话less和L就不相等
                // 含义:把等于区的最左元素(less++)换到当前位置(L)，这样就腾出了一个位置放小于区的元素
                swap(arr, less, L);
                L++;
            } else if (arr[L] > arr[R]) {
                more--;
                swap(arr, more, L);
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

    public static void main(String[] args) {
//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int k = 4;
//        FindKthLargest solution = new FindKthLargest();
//        int kthLargest = solution.findKthLargest(nums, k);
//        System.out.println(kthLargest);

        int nums = 10;
        while (nums > 0){
            int s = (int) (Math.random() * 11);
            System.out.println(s);
            nums--;
        }
    }
}
