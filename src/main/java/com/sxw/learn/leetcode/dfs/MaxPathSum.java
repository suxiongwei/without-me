package com.sxw.learn.leetcode.dfs;

import com.sxw.learn.leetcode.tree.TreeNode;

/**
 * [题目]: 二叉树中的最大路径和(124)
 * [题目描述]:
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * [解题思路]:
 * 递归 + 回溯
 */
public class MaxPathSum {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return maxPathSum;
    }

    public int process(TreeNode node) {
        if (node == null) return 0;
        // 递归计算左右子节点的最大贡献值
        int leftGain = Math.max(process(node.left), 0);// 只有在最大贡献值大于 0 时，才会选取对应子节点(因为我可以不选择)
        int rightGain = Math.max(process(node.right), 0);
        int priceNewPath = leftGain + rightGain + node.val;// 算最大贡献值时是根据当前节点的值去算，这里没有判断，是因为在下一层的max函数中规避掉了，因为递归是从底往上，如果当前节点加上左右节点的值比原来其中一个子树的值还要小，那么自然不会取到max
        maxPathSum = Math.max(maxPathSum, priceNewPath);
        return node.val + Math.max(leftGain, rightGain);// 返回节点的最大贡献值，取最大贡献值时，是取的左右子树的其中一个
    }
}
