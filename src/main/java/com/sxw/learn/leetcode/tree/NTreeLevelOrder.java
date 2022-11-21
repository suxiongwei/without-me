package com.sxw.learn.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [题目]: N叉树的层序遍历(429)
 * [题目描述]:
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * [解题思路]:
 * BFS 队列
 */
public class NTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                curLevelList.add(tmp.val);
                for (Node child : tmp.children) {
                    queue.offer(child);
                }
            }
            res.add(curLevelList);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
