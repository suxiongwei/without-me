package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 二叉树展开为链表(114)
 * [题目描述]:
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * [解题思路]:
 * 可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。
 * <p>
 * 1、将左子树插入到右子树的地方
 * 2、将原来的右子树接到左子树的最右边节点
 * 3、考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
 */
public class Flatten {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {//左子树为 null，直接考虑下一个节点
                root = root.right;
            } else {
                TreeNode pre = root.left;// 存储左子树最右边的节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;// 对应上面的操作2 将原来的右子树接到左子树的最右边节点
                root.right = root.left;// 对应上面的操作1
                root.left = null;
                root = root.right;// 考虑下一个节点
            }
        }
    }
}
