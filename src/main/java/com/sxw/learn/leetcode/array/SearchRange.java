package com.sxw.learn.leetcode.array;



/**
 * [题目]: 在排序数组中查找元素的第一个和最后一个位置(34)
 * [题目描述]:
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * [解题思路]: 二分法
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {// rightIdx < nums.length 处理要查找的数比数组最大值还大
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    /**
     * @param nums
     * @param target
     * @param lower  如果 lower 为 true，则查找第一个大于等于 target 的下标，否则查找第一个大于 target 的下标。
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean lower) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,7,10};
        SearchRange searchRange = new SearchRange();
        int i = searchRange.binarySearch(nums, 100, true);
        System.out.println(i);
        int i1 = searchRange.binarySearch(nums, 100, false);
        System.out.println(i1);
    }
}
