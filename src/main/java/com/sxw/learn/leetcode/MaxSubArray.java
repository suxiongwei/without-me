package com.sxw.learn.leetcode;


/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-24 6:48 下午
 */
public class MaxSubArray {
    public int solution(int[] nums){
        int length = nums.length;
        if (length < 1) return 0;
        int[] dp = new int[length];// dp[i]：表示以 nums[i] 结尾的连续子数组的最大和
        dp[0] = nums[0];// 初始值为1
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int solution = maxSubArray.solution(nums);
        System.out.println(solution);
    }
}
