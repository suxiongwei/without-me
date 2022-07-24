package com.sxw.learn.leetcode.tree;

import com.google.common.base.Joiner;

import java.util.List;

/**
 * [题目]：在二叉树中找到一个节点的后继节点
 * [题目描述]：
 * 现在有一种新的二叉树节点类型定义如下 Node
 * 该结构比普通二叉树多了指向父节点的指针
 * 在二叉树的中序遍历中，node的下一个节点叫做node的后续节点
 *
 * [题目分析]：
 * 情况1：
 * 如果节点有右树，则后继节点为右树的最左节点
 *             1
 *                \
 *                   2
 *                 /   \
 *               3       4
 *              / \
 *             5   6
 * 1的后继节点就是5
 * 中序遍历输出二叉树:1,5,3,6,2,4
 *
 * 情况2：
 * 如果节点没有右树，往上走，判断我是不是我父亲的左孩子
 *                        1
 *                     /
 *                 2
 *                    \
 *                       3
 *                         \
 *                           4
 *                            \
 *                             5
 * 中序遍历输出二叉树:2,3,4,5,1
 * 5的后继节点就是1
 * 需考虑意外情况，就是整颗树最右的节点，是没有后继的
 */
public class GetSuccessorNode {
    public static Node getSuccessorNode(Node node){
        if (node == null) return node;
        if (node.right != null){
            return getLeftMost(node);
        }else {
            Node parent = node.parent;
            /**
             * 两个终止条件
             * 1): node == parent.left 当前节点是父亲的左孩子，return parent
             * 2): parent == null 只有当节点是整颗树最右的节点，是没有后继的，此时返回parent(null)
             */
            while (parent != null && node != parent.left){
                node = parent; // node往上移动
                parent = node.parent; // parent往上移动
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if (node == null) return node;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    static class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;


        TreeNodeShow.show(node1);

        List<Integer> res = Traversal.inOrderTraversal(node1);
        System.out.println("中序遍历输出二叉树:" + Joiner.on(",").join(res));// 后序遍历输出二叉树:4,5,2,6,7,3,1
    }
}
