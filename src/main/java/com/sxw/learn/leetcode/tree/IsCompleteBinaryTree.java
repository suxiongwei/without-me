package com.sxw.learn.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [题目]：判断一颗二叉树是否为完全二叉树
 * LC名称：二叉树的完全性检验(isCompleteTree)
 *
 * 完全二叉树的定义：如果二叉树中除去最后一层节点为满二叉树，且最后一层的结点依次从左到右分布，则此二叉树被称为完全二叉树。
 * 1
 * /     \
 * 2           3
 * /   \       /   \
 * 4       5   8       9
 * / \     / \ /
 * 6   7   10  12
 * <p>
 * [解题思路]：
 * 使用层次遍历
 * 1) 任意节点，有右子树无左子树，返回false
 * 2) 不违反第一步的前提下，如果遇到了第一个左右子树不全，则接下来的节点必须为叶子节点
 */
public class IsCompleteBinaryTree {
    public static boolean isCompleteBinaryTree(TreeNode node) {
        if (node == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        // 是否遇到过左右孩子不双全的节点
        boolean leaf = false;
        TreeNode left, right;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            left = cur.left;
            right = cur.right;
            if (left == null && right != null) return false;// 不符合条件一:任意节点，有右子树无左子树，返回false
            if (leaf && (left != null || right != null)) return false;// 不满足条件二：不违反第一步的前提下，如果遇到了第一个左右子树不全，则接下来的节点必须为叶子节点
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);

            if (left == null || right == null) leaf = true;// 证明已经到叶子节点
        }
        return true;
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
        TreeNode node12 = new TreeNode(12);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node7;

        node3.left = node8;
        node3.right = node9;

        node5.left = node10;
        node5.right = node11;

        node8.left = node12;

        TreeNodeShow.show(node1);
        // case1
        System.out.println("以上树是否为完全二叉树:" + IsCompleteBinaryTree.isCompleteBinaryTree(node1));

        // case2
        node3.right = null;
        TreeNodeShow.show(node1);
        System.out.println("以上树是否为完全二叉树:" + IsCompleteBinaryTree.isCompleteBinaryTree(node1));

    }
}
