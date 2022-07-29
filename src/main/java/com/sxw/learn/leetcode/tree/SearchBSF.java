package com.sxw.learn.leetcode.tree;

/**
 * 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。你需要在 BST 中找到节点值等于给定值的节点。返回以该节点为根的子树。如果节点不存在，则返回 NULL 。
 */
public class SearchBSF {
    public static TreeNode searchBSF(TreeNode root, int val){
        if (root == null){
            return null;
        }
        if (root.value == val){
            return root;
        }else if(root.value < val){
            return searchBSF(root.right, val);
        }else {
            return searchBSF(root.left, val);
        }
    }
}
