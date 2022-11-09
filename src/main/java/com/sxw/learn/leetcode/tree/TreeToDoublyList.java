package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 二叉搜索树与双向链表(剑指Offer36)
 * [题目描述]:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * [解题思路]:
 * 递归
 */
public class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur){
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null){
            pre.right = cur;
        }else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
