package com.sxw.learn.leetcode.bfs;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层次遍历(102)
 * 给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();// 每遍历一次，代表往下走了一层
            Integer currentLevelSize = deque.size();// 定义一个变量，因为在执行过程中size的值是变化的
            for (Integer i = 0; i < currentLevelSize; i++) {
                TreeNode curNode = deque.pollFirst();
                level.add(curNode.val);
                if (curNode.left != null) deque.offerLast(curNode.left);// 从队尾插入，当此轮循环结束，上一层的节点都已经弹出，队列按照从左到右存储的已经是下一层的节点
                if (curNode.right != null) deque.offerLast(curNode.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(node3);
        System.out.println(lists);
    }
}
