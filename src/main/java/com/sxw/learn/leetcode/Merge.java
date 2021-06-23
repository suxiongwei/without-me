package com.sxw.learn.leetcode;

import java.util.Arrays;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-11 6:04 下午
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        nums1_copy = Arrays.copyOf(nums1, m);
        int p1 = 0, p2 = 0; // Two get pointers for nums1_copy and nums2
        int p = 0; // Set pointer for nums1
        while (p1 < m && p2 < n)
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        if (p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
