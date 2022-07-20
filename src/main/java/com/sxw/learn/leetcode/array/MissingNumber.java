package com.sxw.learn.leetcode.array;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-05 10:46 上午
 */
public class MissingNumber {
    public int missingNumber1(int[] nums){
        int result = (nums.length + 1) * nums.length / 2;
        for (int i = 0; i < nums.length; i++){
            result -= nums[i];
        }
        return result;
    }

    public int missingNumber(int[] nums) {
        // 比如 3, 0, 1, 4
        // 前后拼接了 0 和length -> 0(拼接的) ^ 0 ^ 3 ^ 1 ^ 0 ^ 2 ^ 1 ^ 3 ^ 4 ^ 4(最后拼接的length) = 2
        int res = 0;
        for(int i = 0; i < nums.length; i++ )
            res ^= nums[i] ^ i;
        return res ^ nums.length;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int i = solution.missingNumber1(new int[]{3, 0, 1, 4});
        // 输出2
        System.out.println(i);
    }
}
