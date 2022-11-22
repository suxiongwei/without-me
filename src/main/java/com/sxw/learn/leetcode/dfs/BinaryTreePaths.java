package com.sxw.learn.leetcode.dfs;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * [题目]: 二叉树的所有路径(257)
 * [题目描述]:
 * 给你一个二叉树的根节点 root，按任意顺序返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * [解题思路]:
 * DFS + 回溯
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(root.val);
        dfs(root, deque);
        return res;
    }

    public void dfs(TreeNode node, Deque<Integer> deque){
        if (node.left == null && node.right == null){
            List<Integer> tmpList = new ArrayList<>(deque);
            StringBuilder tmpSb = new StringBuilder();
            for (Integer tmp : tmpList) {
                tmpSb.append(tmp).append("->");
            }
            res.add(tmpSb.substring(0, tmpSb.length() - 2));
            return;
        }
        if (node.left != null){
            deque.offerLast(node.left.val);
            dfs(node.left, deque);
            deque.pollLast();
        }
        if (node.right != null){
            deque.offerLast(node.right.val);
            dfs(node.right, deque);
            deque.pollLast();
        }
    }

    public static void main(String[] args) {
        /**
         *      1
         *   2     3
         * 5
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node5;

        BinaryTreePaths solution = new BinaryTreePaths();
        List<String> list = solution.binaryTreePaths(node1);
        list.forEach(System.out::println);
    }
}
