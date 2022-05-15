package com.sxw.learn.leetcode.tree;


public class TreeNode {
    public Integer value;
    public TreeNode left, right;

    public TreeNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
