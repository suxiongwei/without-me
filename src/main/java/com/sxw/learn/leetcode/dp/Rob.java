package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 打家劫舍(198)&&打家劫舍II(213)
 * [题目描述]:
 * [解题思路]:
 * 动态规划
 */
public class Rob {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        // dp[i] 表示前 i 间房屋能偷窃到的最高总金额，可以得到状态转移方程为:dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        int dp[] = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    // 空间优化的版本，我们发现一个dp[k]的值只用到了dp[k-1]和dp[k-2]，因此我们不需要记录整个dp数组
    // 空间复杂度 O(N) -> O(1)
    public int robs(int[] nums) {
        int N = nums.length;
        int prev = 0;
        int curr = nums[0];
        for (int k = 2; k <= N; k++) {
            int tmp = curr;// 临时变量存储下来，因为这儿不能修改prev的值，prev还要参与下一步的运算
            curr = Math.max(nums[k - 1] + prev, curr);
            prev = tmp;
        }
        return curr;
    }

    // 打家劫舍II
    public int robII(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        // 如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋。
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length == 1) return nums[start];
        if (length == 2) return Math.max(nums[start], nums[start + 1]);
        // 状态的转移只在相邻的两个变量间转移，因此不需要定义dp数组，定义两个变量就可以
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;// 需要定义临时变量，用于更新first
            second = Math.max(first + nums[i], second);// 当前房间偷和不偷做选择
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        Rob solution = new Rob();
//        int rob = solution.robRange(nums, 0, nums.length - 2);
        int rob = solution.robII(nums);
        System.out.println(rob);
    }
}
