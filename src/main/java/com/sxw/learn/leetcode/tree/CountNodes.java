package com.sxw.learn.leetcode.tree;

import java.util.Objects;

/**
 * 完全二叉树的节点个数
 */
public class CountNodes {
    /**
     * 递归求解
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root){
        System.out.println("begin node:" + (Objects.isNull(root) ? "" : root.value));
        if (null == root) return 0;
        int currentCount = 1 + countNodes(root.left) + countNodes(root.right);
        System.out.println("current node:" + root.value + " / " + "current count:" + currentCount);
        return currentCount;
    }

    /**
     * 经典解法
     * 由于题中已经告诉我们这是一颗完全二叉树，我们又已知了完全二叉树除了最后一层，其他层都是满的，并且最后一层的节点全部靠向了左边。
     * 那我们可以想到，可以将该完全二叉树可以分割成若干满二叉树和完全二叉树，满二叉树直接根据层高h计算出节点为2^h-1，然后继续计算子树中完全二叉树节点。
     * 那如何分割成若干满二叉树和完全二叉树呢？对任意一个子树，遍历其左子树层高left，右子树层高right，相等左子树则是满二叉树，否则右子树是满二叉树。
     * @param root
     * @return
     */
    public static int countNodes1(TreeNode root){
       if (root == null) return 0;
       // 对任意一个子树，遍历其左子树层高left，右子树层高right
       int leftLevel = countLevel(root.left);
       int rightLevel = countLevel(root.right);

       // 层高相等左子树则是满二叉树，否则右子树是满二叉树
       if (leftLevel == rightLevel){
           // 左移n位就相当于乘以2的n次方
           int currentCount = countNodes1(root.right) + (1 << leftLevel);
           System.out.println("左右子树level相等：currentNode:" + root.value + ",leftLevel:" + leftLevel + ",rightLevel:" + rightLevel + ",currentCount:" + currentCount);
           return currentCount;
       }else {
           int currentCount = countNodes1(root.left) + (1 << rightLevel);
           System.out.println("左右子树level不等：currentNode:" + root.value + ",leftLevel:" + leftLevel + ",rightLevel:" + rightLevel + ",currentCount:" + currentCount);
           return currentCount;
       }
    }

    public static int countLevel(TreeNode root){
        int level = 0;
        while (root != null){
            level ++;
            root = root.left;
        }
        return level;
    }



    public static void main(String[] args) {
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node20 = new TreeNode(20, node15, node7);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3, node4, node20);

//        System.out.println(countNodes(node3));
        /**
         * 输出结果:
         * begin node:3
         * begin node:4
         * begin node:
         * begin node:
         * current node:4 / current count:1
         * begin node:20
         * begin node:15
         * begin node:
         * begin node:
         * current node:15 / current count:1
         * begin node:7
         * begin node:
         * begin node:
         * current node:7 / current count:1
         * current node:20 / current count:3
         * current node:3 / current count:5
         * 5
         */


        /**
         * 使用经典解法
         */
        TreeNode node5 = new TreeNode(5, new TreeNode(10), null);
        TreeNode node4 = new TreeNode(4, new TreeNode(8), new TreeNode(9));
        TreeNode node3 = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println("final count:" + countNodes1(node1));
    }
}
