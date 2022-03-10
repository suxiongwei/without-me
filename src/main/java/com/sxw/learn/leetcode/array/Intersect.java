package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description 两个数组的交集 II
 * @Date 2021-03-16 5:04 下午
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index = 0, index1 = 0, index2 = 0;
        int[] intersection = new int[Math.min(length1, length2)];
        while (length1 > index1 && length2 > index2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                intersection[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] ints = intersect.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(ints));
    }
}
