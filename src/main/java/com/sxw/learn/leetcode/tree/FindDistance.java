package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 查找二叉树中给定节点对之间的距离
 * [题目描述]:
 * 给定一棵二叉树，确定其中给定节点对之间的距离。两个节点之间的距离定义为从一个节点到另一个节点的最短路径中的边的总数。
 * [解题思路]:
 * 1、寻找最近的公共子节点
 * 2、计算两个节点的距离
 */
public class FindDistance {
    // 帮助函数查找给定节点在二叉树中的级别
    public static int findLevel(TreeNode root, TreeNode TreeNode, int level) {
        // 基本情况
        if (root == null) return Integer.MIN_VALUE;
        // 如果找到节点，则返回级别
        if (root == TreeNode) return level;
        // 在左子树中搜索节点
        int left = findLevel(root.left, TreeNode, level + 1);
        // 如果在左子树中找到节点，则返回左孩子
        if (left != Integer.MIN_VALUE) return left;
        // 否则，继续在右子树中搜索
        return findLevel(root.right, TreeNode, level + 1);
    }

    // 在 a 中查找节点 `x` 和节点 `y` 之间的距离的函数
    // 给定以 `root` 节点为根的二叉树
    public static int findDistance(TreeNode root, TreeNode x, TreeNode y) {
        // `lca` 存储 `x` 和 `y` 的最低共同祖先
        TreeNode lca = LowestCommonAncestor.lowestCommonAncestor(root, x, y);
        // 返回 `x` 到 lca 的距离 + `y` 到 lca 的距离
        return findLevel(lca, x, 0) + findLevel(lca, y, 0);
    }

    public static void main(String[] args) {
        /* 构造下面的树
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               /     \
              7       8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        // 找到节点 7 和节点 6 之间的距离
        System.out.print(findDistance(root, root.right.left.left, root.right.right));
    }
}
