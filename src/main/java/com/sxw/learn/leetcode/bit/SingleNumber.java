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


    /**
     * 题目：给定一个整数数组 nums，找到数组中只出现一次的两个数字。
     * 示例： 输入：[1,2,1,3,2,5] 输出：[3,5]
     *
     * 要求：
     * 要求线性时间复杂度 O(n)。
     * 要求使用常数级的额外空间。
     * 提示：
     * 可以使用位运算的思想。
     * 可以使用异或运算来找到只出现一次的两个数字。
     *
     * @param nums
     * @return
     */
    public int[] findSingleNumbers(int[] nums) {
        // 首先对所有数字进行异或运算，得到两个只出现一次的数字的异或结果
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // 找到异或结果中最低位的 1
        int lowestBit = xorResult & (-xorResult);

        // 根据最低位的 1 将数组分为两组，每组包含一个只出现一次的数字
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & lowestBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
