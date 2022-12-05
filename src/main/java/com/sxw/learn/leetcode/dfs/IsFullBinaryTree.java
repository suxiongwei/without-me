package com.sxw.learn.leetcode.dfs;

import com.sxw.learn.leetcode.tree.TreeNode;
import com.sxw.learn.leetcode.tree.TreeNodeShow;

/**
 * [题目]：判断一颗二叉树是否为满二叉树
 * 满二叉树的定义：如果二叉树中除了叶子结点，每个结点的度都为 2，则此二叉树称为满二叉树。
 * 满二叉树的节点个数，l为层级，则节点个数=2^l+1
 *
 * [解题思路]
 * 通过递归的方式，理解为拆黑盒拿信息，已经从黑盒拿到了需要的信息，加工出自己的信息就可以
 *
 * - 问左树要信息（本题就是，左子树的高度，左子树的节点个数）
 * - 问右树要信息（本题就是，右子树的高度，右子树的节点个数）
 * - 比较条件
 */
public class IsFullBinaryTree {
    public static boolean isFullBinaryTree(TreeNode node){
        Info data = process(node);
        return data.nodes == ((1 << data.height) - 1);// 这里需要注意一下位运算的优先级问题，加减的优先级高于位运算，因此位运算需要加括号
    }

    public static Info process(TreeNode node){
        if (node == null) return new Info(0, 0);
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }

    static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        TreeNodeShow.show(node1);

        // case1
        System.out.println("以上树是否为满二叉树:" + IsFullBinaryTree.isFullBinaryTree(node1));

        // case2
        node2.left = null;
        TreeNodeShow.show(node1);
        System.out.println("以上树是否为满二叉树:" + IsFullBinaryTree.isFullBinaryTree(node1));

        System.out.println((1 << 3- 1));
        System.out.println(((1 << 3)- 1));

    }
}
