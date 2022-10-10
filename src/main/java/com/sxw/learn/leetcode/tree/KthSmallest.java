package com.sxw.learn.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [题目]: 二叉搜索树中第K小的元素(230)
 * [题目描述]:
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * [解题思路]:
 * 因为二叉搜索树和中序遍历的性质，所以二叉搜索树的中序遍历是按照键增加的顺序进行的。于是，我们可以通过中序遍历找到第 k 个最小元素。
 * 使用迭代方法，这样可以在找到答案后停止，不需要遍历整棵树。
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;// 每弹出一个就 减少一次
            if (k == 0) {
                break;
            }
            root = root.right;// 模拟升序列遍历，左中右
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        KthSmallest solution = new KthSmallest();
        int i = solution.kthSmallest(node5, 3);
        System.out.println(i);
    }
}
