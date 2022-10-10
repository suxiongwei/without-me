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
        valueQueue.offer(root.val);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer value = valueQueue.poll();
            // 到叶子节点的路径
            if (node.left == null && node.right == null && value == targetSum) return true;

            if (node.left != null){
                nodeQueue.offer(node.left);
                valueQueue.offer(node.left.val + value);
            }

            if (node.right != null){
                nodeQueue.offer(node.right);
                valueQueue.offer(node.right.val + value);
            }
        }
        return false;
    }

    /**
     * 递归解法
     *
     *             1
     *          /     \
     *       2           3
     *     /   \       /   \
     *   4       5   8       9
     *  / \     /     \
     * 6   7   10      11
     * cur:1,targetSum:18
     * cur:2,targetSum:17
     * cur:4,targetSum:15
     * cur:6,targetSum:11
     * cur:7,targetSum:11
     * cur:5,targetSum:15
     * cur:10,targetSum:10
     * true
     */
    public static boolean solution1(TreeNode root, int targetSum) {
        if (root != null) System.out.println("cur:" + root.val + ",targetSum:" + targetSum);
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return solution1(root.left, targetSum - root.val) || solution1(root.right, targetSum - root.val);// 左节点返回false才会去右节点继续
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node7;

        node3.left = node8;
        node3.right = node9;

        node5.left = node10;

        node8.right = node11;

        TreeNodeShow.show(node1);
        /**
         *             1
         *          /     \
         *       2           3
         *     /   \       /   \
         *   4       5   8       9
         *  / \     /     \
         * 6   7   10      11
         *
         * 1,2,4,6 走完之后直接return
         */
        boolean b = HasPathSum.solution1(node1, 18);
        System.out.println(b);
    }


}
