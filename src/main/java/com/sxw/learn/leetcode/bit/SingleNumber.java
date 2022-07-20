package com.sxw.learn.leetcode.bit;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-05 10:13 上午
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
