package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 删除二叉搜索树中的节点(450)
 * [题目描述]:
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * [解题思路]:
 * 二叉搜索树有以下性质：
 * 左子树的所有节点（如果有）的值均小于当前节点的值；
 * 右子树的所有节点（如果有）的值均大于当前节点的值；
 * 左子树和右子树均为二叉搜索树。
 * <p>
 * 根据以上性质分类讨论
 * 1、讨论当前节点存在不存在
 * 2、讨论要删除的节点的左右孩子的情况，根据不同情况不同处理
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 未搜索到值为 key 的节点，返回空
        if (root == null) return null;
        // 值为 key 的节点可能存在于 root 的左子树中，需要递归地在 root.left 调用 deleteNode，并返回 root。
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        // key == root.val 当前root就是需要删除的root
        // 叶子节点，没有子树。此时可以直接将它删除，即返回空
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        // 只有左子树，没有右子树。此时可以将它的左子树作为新的子树，返回它的左子节点。
        if (root.right == null) {
            return root.left;
        }
        // 说明当前root左右节点都不为空，需要找后继节点，找的是右子树的最小节点
        // 简单证明：successor 位于 root 的右子树中，因此大于 root 的所有左子节点；successor 是 root 的右子树中的最小节点，因此小于 root 的右子树中的其他节点。以上两点保持了新子树的有序性。
        TreeNode successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        // delete 的入参是 root.right，因为函数返回的是删除后的根节点，因此root.right = 删除后的root.right
        root.right = deleteNode(root.right, successor.val);
        successor.left = root.left;
        successor.right = root.right;
        return successor;
    }
}
