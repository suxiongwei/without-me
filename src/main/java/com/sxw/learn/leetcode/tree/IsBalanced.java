package com.sxw.learn.leetcode.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode node){
        if (node == null) return true;

        if (!isBalanced(node.left) || !isBalanced(node.right)){
            return false;
        }

        int leftDepth = MaxDepth.maxDepth1(node.left);
        int rightDepth = MaxDepth.maxDepth1(node.right);

        if (Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node4, node20);

        System.out.println(isBalanced(node3));
    }
}
