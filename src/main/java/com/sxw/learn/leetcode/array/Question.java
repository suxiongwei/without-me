package com.sxw.learn.leetcode.array;


import java.util.Arrays;

public class Question {
    /**
     * 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;

        while (index1 < len1 && index2 < len2){

        }

        return nums1;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] ints = intersect.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(ints));
    }
}
