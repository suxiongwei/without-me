package com.sxw.learn.leetcode.bit;

/**
 * [题目]: 只出现一次的数字(136)
 * [题目描述]: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * [解题思路]: 使用位运算
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // nums 假如为 2 1 2 3 3，由于异或操作满足交换律和结合律 因此
        // 2 ^ 1 ^ 2 ^ 3 ^ 3 = (2 ^ 2) ^ (3 ^ 3) ^ 1 = (0 ^ 0) ^ 1 = 0 ^ 1 = 1
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        int i = singleNumber.singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }
}
