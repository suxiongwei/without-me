package com.sxw.learn.leetcode.tree;


import java.util.*;

public class Solution {
    /**
     * 求最大深度
     * @param root
     * @return
     */
    public static Integer maxDepth(TreeNode root){

        return 0;
    }

    /**
     * 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    public boolean isValidBST(TreeNode root) {
        return false;
    }

    public static boolean isValidBST(TreeNode node, Integer lower, Integer upper){
        return false;
    }

    // 递归方式实现
    public static TreeNode searchBSF(TreeNode root, int val){
        return null;
    }

    // 迭代方式实现
    public static TreeNode searchBSF1(TreeNode root, int val){

        return null;
    }

    public static void main(String[] args) {
        /**
         *  [3,4,20,null,null,15,7]
         */
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node4, node20);

        System.out.println(maxDepth(node3));
        System.out.println(levelOrder(node3));
    }
}
