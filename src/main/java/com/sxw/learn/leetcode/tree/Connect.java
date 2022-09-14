package com.sxw.learn.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [题目]: 填充每个节点的下一个右侧节点指针(116)
 * [题目描述]:
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * [解题思路]: 层次遍历
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();// 处理当前层的同时，将节点弹出
                if (i < size - 1) tmp.next = queue.peek();// 只处理当前层除最后一个节点的数据
                if (tmp.left != null) queue.offer(tmp.left);// 将下一层的节点压入队列
                if (tmp.right != null) queue.offer(tmp.right);// 将下一层的节点压入队列
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
