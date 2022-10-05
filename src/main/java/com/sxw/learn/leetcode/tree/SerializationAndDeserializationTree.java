package com.sxw.learn.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [题目]：二叉树的序列化与反序列化
 * 就是内存里的二叉树如何变成字符串的形式，又如何从字符串的形式还原为树
 * [题解]：通过先序遍历的方式
 *             1
 *                \
 *                   2
 *                 /   \
 *               3       4
 *              / \
 *             5   6
 * 先序遍历的方式将树序列化为字符串:1_#_2_3_5_#_#_6_#_#_4_#_#_
 *
 */
public class SerializationAndDeserializationTree {
    // 通过先序列遍历的方式将树序列化为字符串
    public static String serialByPre(TreeNode node){
        if (node == null) return "#_";
        String res = node.val + "_";
        res += serialByPre(node.left);
        res += serialByPre(node.right);
        return res;
    }

    // 通过先序列遍历的方式将字符串反序列化为树
    public static TreeNode reconByPreString(String serialStr){
        String[] split = serialStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            queue.add(split[i]);
        }
        return reconByPreOrder(queue);
    }

    private static TreeNode reconByPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) return null;
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = reconByPreOrder(queue);
        head.right = reconByPreOrder(queue);
        return head;
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

        String res = SerializationAndDeserializationTree.serialByPre(node1);
        System.out.println("先序遍历的方式将树序列化为字符串:" + res);

        TreeNode treeNode = SerializationAndDeserializationTree.reconByPreString(res);
        System.out.println("将先序遍历序列化后的字符串恢复为树，结果如下:" );
        TreeNodeShow.show(treeNode);
    }
}
