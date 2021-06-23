package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-10 8:04 下午
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0; // 慢指针
        for (int j = 1; j < nums.length; j++) {// j 是快指针，如果遇到重复的，快指针往前走
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;// 因为快指针是从1开始的 而且至少也有一个
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i = removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(i);
    }
}
