package com.sxw.learn.leetcode.tree;

/**
 * [题目]：反转二叉树/二叉树的镜像(剑指Offer27)
 */
public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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

        System.out.println("反转前....");
        TreeNodeShow.show(node1);

        InvertTree.invertTree(node1);
        System.out.println("反转后....");
        TreeNodeShow.show(node1);
    }
}
