package com.sxw.learn.leetcode.dfs;

import com.sxw.learn.leetcode.tree.TreeNode;

/**
 * [题目]: 求根节点到叶节点数字之和(129)
 * [题目描述]:
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * <p>
 * [解题思路]:
 * DFS 每次递归的时候，记录前面的总和，然后计算出每个节点的数字之和
 * 1        1 -> 249 + 275
 * 2     3     2 -> 124 + 125 = 249    3 -> 136 + 137 = 275
 * 4  5   6  7
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int preSum) {
        if (node == null) return 0;
        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;// 处理根节点的值，没有这行代码，下面这一行在根节点的时候返回的是0，层层往上，最终结果就是0了
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }

    // 个人解法,2023.03.09
    int ans = 0;

    public int sumNumbers1(TreeNode root) {
        dfs1(root, root.val);
        return ans;
    }

    // 定义函数dfs1,preSum表示截止到当前节点,已经生成的数字为preSum
    void dfs1(TreeNode root, int preSum) {
        // base case:当前节点已经为叶子节点,走完了一条路径
        if (root.left == null && root.right == null) {
            ans = ans + preSum;
        }
        if (root.left != null) {
            dfs1(root.left, preSum * 10 + root.left.val);
        }
        if (root.right != null) {
            dfs1(root.right, preSum * 10 + root.right.val);
        }
    }
}
