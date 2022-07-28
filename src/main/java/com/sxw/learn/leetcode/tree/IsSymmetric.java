package com.sxw.learn.leetcode.tree;

/**
 * [题目]：对称二叉树
 * 你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }
    boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.value == q.value && check(p.left, q.right) && check(p.right, q.left);
    }
}
