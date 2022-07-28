package com.sxw.learn.leetcode.tree;

/**
 * [题目]：平衡二叉树(110)
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;// 其中任意一个节点如果不满足平衡二叉树时，那说明整棵树已经不是一颗平衡二叉树，我们可以对其进行阻断，不需要继续递归下去
        int leftH = maxDepth(root.left);// maxDepth本身就是递归的，上面的代码就是为了提前阻断，提升效率
        int rightH = maxDepth(root.right);
        return Math.abs(leftH - rightH) > 1;
    }

    public int maxDepth(TreeNode node){
        if (node == null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right)) + 1;
    }
}
