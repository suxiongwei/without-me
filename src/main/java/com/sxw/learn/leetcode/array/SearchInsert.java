package com.sxw.learn.leetcode.array;

/**
 * [题目]:35. 搜索插入位置
 * [题目描述]:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int ans = nums.length;
        while(l <= r){
            mid = l + ((r - l) >> 1);
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                r = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 0));
    }
}
