package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 树的子结构(剑指Offer26) OR 另一棵树的子树(572)
 * [题目描述]:
 * 树的子结构(剑指Offer26):
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 另一棵树的子树(572):
 * 特殊要求：B是A的子结构的基础上增加了B包含A子结构的所有后代节点
 *
 * [解题思路]:
 * 先序遍历A树，调用递归函数判断是否B
 */
public class IsSubStructure {
    // 先序遍历树 A 中的每个节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断树 A 中 以 A 为根节点的子树 是否包含树 B
    public boolean recur(TreeNode A, TreeNode B){
        // 树的子结构(剑指Offer26)
        if (B == null) {
            return true;
        }
        if (A == null){
            return false;
        }
        // 另一棵树的子树(572)
//        if (B == null && A == null) {
//            return true;
//        }
//        if (A == null || B == null) {
//            return false;
//        }
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }
}
