package com.sxw.learn.leetcode.tree;

import com.google.common.base.Joiner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * [题目]: 路径总和II(113)
 * [题目描述]:
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * [解题思路]:
 * DFS
 * 枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
 */
public class PathSum {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    /**
     *             5
     *          /     \
     *       4           8
     *     /           /   \
     *   11          13      4
     *  / \                 / \
     * 7   2               5   1
     */
    private void dfs(TreeNode node, int targetSum) {
        if (node == null) return;
        path.offerLast(node.val);
        targetSum = targetSum - node.val;
        if (node.left == null && node.right == null && targetSum == 0) res.add(new ArrayList(path));
        if (node.left != null) dfs(node.left, targetSum);
        if (node.right != null) dfs(node.right, targetSum);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4a = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5a = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;

        node4.left = node11;

        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node4a;

        node4a.left = node5a;
        node4a.right = node1;

        TreeNodeShow.show(node5);

        PathSum solution = new PathSum();
        List<List<Integer>> lists = solution.pathSum(node5, 22);
        lists.stream().forEach(e -> System.out.println(Joiner.on(",").join(e)));
    }
}
