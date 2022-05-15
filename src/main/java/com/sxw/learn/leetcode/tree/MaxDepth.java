package com.sxw.learn.leetcode.tree;

import java.util.Stack;

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
    }
}
