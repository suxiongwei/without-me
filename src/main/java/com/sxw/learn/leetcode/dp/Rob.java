package com.sxw.learn.leetcode.dp;

import com.sxw.learn.leetcode.tree.TreeNode;

/**
 * [题目]: 打家劫舍(198)&&打家劫舍II(213)&&打家劫舍III(337)
 * [题目描述]:
 * [解题思路]:
 * 动态规划
 */
public class Rob {
    /**
     * 打家劫舍(198)
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
     * 示例：
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     */
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


    /**
     * 打家劫舍II
     * <p>
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，今晚能够偷窃到的最高金额。
     * <p>
     * 示例 1：
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：3
     */
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

    /**
     * 打家劫舍III(337)
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * <p>
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 给定二叉树的root 。返回在不触动警报的情况下，小偷能够盗取的最高金额。
     * <p>
     * 示例 1:
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     * <p>
     * 示例 2:
     * 输入: root = [3,4,5,1,3,null,1]
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
     * <p>
     * 左子树的下标index = 父index * 2 + 1
     */
    public int rob3(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    public static int[] dfs(TreeNode node) {
        /**
         * 定义数组接受返回结果 int[select, noSelect]
         * index 0 代表选择当前节点的最大盗取金额
         * index 1 代表不选择当前节点的最大盗取金额
         * 整个递归过程中拿这两个结果进行状态转移
         */
        int[] res = new int[]{0, 0};
        // 最后一层节点的子节点特殊处理，相当于gei
        if (node == null) {
            return res;
        }
        int[] leftNodeRes = dfs(node.left);
        int[] rightNodeRes = dfs(node.right);

        /**
         * 选择当前节点，那么子节点就必然不能选
         */
        int select = node.val + leftNodeRes[1] + rightNodeRes[1];
        /**
         * 不选当前节点，子节点就可选可不选，取最大值即可
         */
        int noSelect = Math.max(leftNodeRes[0], leftNodeRes[1]) + Math.max(rightNodeRes[0], rightNodeRes[1]);
        res[0] = select;
        res[1] = noSelect;
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        Rob solution = new Rob();
//        int rob = solution.robRange(nums, 0, nums.length - 2);
        int rob = solution.robII(nums);
        System.out.println(rob);
    }
}
