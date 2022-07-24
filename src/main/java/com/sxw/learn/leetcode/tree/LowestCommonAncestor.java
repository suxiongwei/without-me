package com.sxw.learn.leetcode.tree;

/**
 * [题目描述]：给定两个二叉树的节点node1和node2，找到它们的最低公共祖先节点
 * [说明]：前提条件是一定存在公共祖先
 * [解题思路]：
 * 分析当有公共祖先时的可能的情况
 * 情况1：o1是o2祖先，或者o2是o1的祖先
 * 情况2：o1和o2不互为祖先，需要向上找
 */
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode o1, TreeNode o2){
        if (node == null || node == o1 || node == o2) return node;// base case 遇到null返回null，遇到o1返回o1，遇到o2返回o2
        TreeNode left = lowestCommonAncestor(node.left, o1, o2);
        TreeNode right = lowestCommonAncestor(node.right, o1, o2);
        if (left != null && right != null) return node;// 如果左子树和右子树返回的结果都不为空，往上传递
        return left != null ? left : right;// 左右子树，并不是都有返回值，谁有值返回谁，都没值，返回null，叶子节点一定返回null

        /**
         * 举例子:
         *                         1
         *                     /       \
         *                 2               3
         *              /     \
         *           4           5
         *         /   \           \
         *       6       7           8
         *                          /
         *                         9
         *  1）：1
         *  2）：2
         *  3）：4 -> return 6
         *  4）：7 -> return null
         *  5）：4 -> return 6
         *  6）：5
         *  7）：8 -> return 9
         *  8）：5 -> return 9
         *  9）：3 -> return null
         *  10）：
         */

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
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node7;

        node5.right = node8;

        node8.left = node9;
        TreeNodeShow.show(node1);

        TreeNode lowestCommonAncestor = LowestCommonAncestor.lowestCommonAncestor(node1, node6, node9);
        System.out.println("最低公共祖先节点：" + lowestCommonAncestor.value);
    }
}
