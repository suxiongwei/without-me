package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-30 7:43 下午
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;// 最少也为1，如果放在循环外面dp[0] = 1 会使得其它dp[i] 初始值为0
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
