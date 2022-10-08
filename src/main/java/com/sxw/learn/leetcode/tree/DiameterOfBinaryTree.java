package com.sxw.learn.leetcode.tree;


/**
 * [题目]: 二叉树的直径(543)
 * [题目描述]:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 * [解题思路]: 递归/DFS
 */
public class DiameterOfBinaryTree {
    private int diameter = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return diameter - 1;// 减1是因为两结点之间的路径长度是以它们之间边的数目表示 -> 4个节点的直径是3
    }

    private int process(TreeNode node) {
        if (node == null) return 0;
        int leftVal = process(node.left);
        int rightVal = process(node.right);
        diameter = Math.max(diameter, leftVal + rightVal + 1);
        return Math.max(leftVal, rightVal) + 1;
    }
}
