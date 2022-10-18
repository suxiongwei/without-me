package com.sxw.learn.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 从前序与中序遍历序列构造二叉树(105)
 * [题目描述]:
 * 给定两个整数数组 preorder 和 inorder，
 * 其中:
 * preorder 是二叉树的先序遍历
 * inorder 是同一棵树的中序遍历
 * 请构造二叉树并返回其根节点。
 * <p>
 * [解题思路]:
 * 前序遍历的形式：
 * [ 根节点,   [左子树的前序遍历结果],   [右子树的前序遍历结果] ]
 * preLeft  preLeft + 1     X      Y         preRight
 * 中序遍历的形式：
 * [ [左子树的中序遍历结果],  根节点,  [右子树的中序遍历结果] ]
 * inLeft   pIndex - 1  pIndex   pIndex + 1  inRight
 * <p>
 * 前序/中序遍历 左子树的长度是相等的：pIndex - 1 - inLeft = X - (preLeft + 1)
 * 推导出：
 * X = pIndex - inLeft + preLeft
 * Y = X + 1 = pIndex - inLeft + preLeft + 1
 * <p>
 * 因此可以使用递归，
 * 每次找到根节点，然后分别递归设置左右节点
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, len - 1, 0, len - 1);
    }

    /**
     * @param preOrder 前序遍历序列
     * @param preLeft 前序遍历左边界
     * @param preRight 前序遍历右边界
     * @param inLeft 中序遍历左边界
     * @param inRight 中序遍历右边界
     * @param map 中序遍历序列里，数值与下标的对应关系
     * @return
     */
    public TreeNode buildTree(int[] preOrder, Map<Integer, Integer> map, int preLeft, int preRight,
                              int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int rootVal = preOrder[preLeft];// 实际的构造树取值都来自于先序遍历
        TreeNode node = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);// 中序遍历构造的map用来划分出哪部分是左子树，哪部分是右子树
        node.left = buildTree(preOrder, map, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1);
        node.right = buildTree(preOrder, map, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight);
        return node;
    }
}
