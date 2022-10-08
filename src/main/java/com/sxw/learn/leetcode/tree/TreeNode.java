package com.sxw.learn.leetcode.tree;


public class TreeNode {
    public Integer val;
    public TreeNode left, right;

    public TreeNode(Integer val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
