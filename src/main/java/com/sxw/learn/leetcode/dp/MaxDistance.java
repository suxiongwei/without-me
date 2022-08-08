package com.sxw.learn.leetcode.dp;

import com.sxw.learn.leetcode.tree.TreeNode;
import com.sxw.learn.leetcode.tree.TreeNodeShow;

/**
 * [题目]: 二叉树节点间的最大距离问题
 * 从二叉树的节点 A 出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点 B 时，路径上的节点数叫作 A 到 B 的距离。
 * 现在给出一棵二叉树，求整棵树上每对节点之间的最大距离。
 * [解题思路]:
 * 树型DP的问题
 * 分为两种情况讨论:
 * 1) X不参与的情况下,max(左子树的maxDistance，右子树的maxDistance)
 * 2) X参与的情况下,左高+右高+1
 */
public class MaxDistance {
    public static int maxDistance(TreeNode root){
        return process(root).maxDistance;
    }

    static class Info{
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static Info process(TreeNode root){
        if (root == null) return new Info(0, 0);
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        // info
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
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
         */
        System.out.println(maxDistance(node1));
    }

}
