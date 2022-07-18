package com.sxw.learn.leetcode.tree;

import java.util.Stack;

/**
 * 先介绍一下DFS：深度优先搜索算法（Depth First Search）
 * 对于二叉树而言，它沿着树的深度遍历树的节点，尽可能深的搜索树的分支，这一过程一直进行到已发现从源节点可达的所有节点为止。
 */
public class MaxDepth {
    /**
     * DFS求最大深度
     *
     * @param root
     * @return
     */
    public static Integer maxDepth(TreeNode root){
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        level.push(1);
        Integer maxDepth = 1;
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            Integer temp = level.pop();
            maxDepth = Math.max(temp, maxDepth);
            if (node.right != null) {
                stack.push(node.right);
                level.push(temp + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                level.push(temp + 1);
            }
        }
        return maxDepth;
    }

    /**
     * 递归求解
     */
    public static int maxDepth1(TreeNode node){
        if (null == node) return 0;
        return Integer.max(maxDepth1(node.left), maxDepth1(node.right)) + 1;
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
        System.out.println(maxDepth1(node3));
    }
}
