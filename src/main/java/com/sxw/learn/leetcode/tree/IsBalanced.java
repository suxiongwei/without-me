package com.sxw.learn.leetcode.tree;

/**
 * [题目]：平衡二叉树(110)
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;// 其中任意一个节点如果不满足平衡二叉树时，那说明整棵树已经不是一颗平衡二叉树，我们可以对其进行阻断，不需要继续递归下去
        int leftH = maxDepth(root.left);// maxDepth本身就是递归的，上面的代码就是为了提前阻断，提升效率
        int rightH = maxDepth(root.right);
        return Math.abs(leftH - rightH) <= 1;
    }

    public static int maxDepth(TreeNode node){
        if (node == null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
//        node2.right = node5;

        node4.left = node6;
        node4.right = node7;

        node3.left = node8;
        node3.right = node9;

        node5.left = node10;

        node8.right = node11;

        TreeNodeShow.show(node1);
        /**
         *             1
         *          /     \
         *       2           3
         *     /   \       /   \
         *   4       5   8       9
         *  / \     /     \
         * 6   7   10      11
         *
         */
        boolean b = IsBalanced.isBalanced(node1);
        System.out.println(b);
    }
}
