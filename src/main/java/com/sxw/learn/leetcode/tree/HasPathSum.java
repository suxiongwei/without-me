package com.sxw.learn.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class HasPathSum {
    /**
     * 广度优先搜索解法
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.offer(root);
        valueQueue.offer(root.value);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer value = valueQueue.poll();
            // 到叶子节点的路径
            if (node.left == null && node.right == null && value == targetSum) return true;

            if (node.left != null){
                nodeQueue.offer(node.left);
                valueQueue.offer(node.left.value + value);
            }

            if (node.right != null){
                nodeQueue.offer(node.right);
                valueQueue.offer(node.right.value + value);
            }
        }
        return false;
    }

    /**
     * 递归解法
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean solution1(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.value;
        return solution1(root.left, targetSum - root.value) || solution1(root.right, targetSum - root.value);
    }


}
