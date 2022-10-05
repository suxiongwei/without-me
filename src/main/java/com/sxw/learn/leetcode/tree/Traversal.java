package com.sxw.learn.leetcode.tree;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [题目]：用递归和非递归两种方式实现二叉树的前序遍历、中序遍历、后序遍历
 *
 * 遍历的方式：
 * - 前序遍历(头、左、右)：相当于递归顺序，第一次的时候打印
 * - 中序遍历(左、头、右)：相当于递归顺序，第二次的时候打印
 * - 后续遍历(左、右、头)：相当于递归顺序，第三次的时候打印
 *
 * 解法：
 * - 递归解法：重点需要了解递归的序列
 * - 非递归解法
 */
public class Traversal {
    // 二叉树的递归顺序
    public static List<Integer> recurOrder(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        recurOrder(res, node);
        return res;
    }

    public static void recurOrder(List<Integer> res, TreeNode node){
        if (node == null) return;
        res.add(node.val);

        recurOrder(res, node.left);
        res.add(node.val);// 上面的return之后，node还是当前栈的node

        recurOrder(res, node.right);
        res.add(node.val);
    }

    // 前序遍历(头、左、右)：相当于递归顺序，第一次的时候打印
    public static List<Integer> preOrderTraversal(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        preOrderTraversal(res, node);
        return res;
    }

    public static void preOrderTraversal(List<Integer> res, TreeNode node){
        if (node == null) return;
        res.add(node.val);

        preOrderTraversal(res, node.left);
        preOrderTraversal(res, node.right);
    }

    // 中序遍历(左、头、右)：相当于递归顺序，第二次的时候打印
    public static List<Integer> inOrderTraversal(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        inOrderTraversal(res, node);
        return res;
    }

    public static void inOrderTraversal(List<Integer> res, TreeNode node){
        if (node == null) return;
        inOrderTraversal(res, node.left);
        res.add(node.val);
        inOrderTraversal(res, node.right);
    }

    // 后续遍历(左、右、头)：相当于递归顺序，第三次的时候打印
    public static List<Integer> postOrderTraversal(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        postOrderTraversal(res, node);
        return res;
    }

    public static void postOrderTraversal(List<Integer> res, TreeNode node){
        if (node == null) return;
        postOrderTraversal(res, node.left);
        postOrderTraversal(res, node.right);
        res.add(node.val);
    }

    // -------------------以上是递归解法,下面的是非递归解法-------------------
    /**
     * 用辅助栈的方式实现先序遍历,实现思路:
     * 1、从栈中弹出一个节点
     * 2、处理这个节点(打印)
     * 3、按照先右后左的方式将左右孩子分别入栈
     */
    public static List<Integer> preOrderTraversalUnRecur(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);

        while (!stack.empty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.right != null){
                stack.add(cur.right);
            }
            if (cur.left != null){
                stack.add(cur.left);
            }
        }
        return res;
    }

    /**
     * 用非递归的方式实现中序遍历，实现思路：
     * 1、每棵子数，整棵子数的左边界进栈
     * 2、依次弹出的过程中，输出结果，然后对弹出节点的右子树循环第一步的操作
     */
    public static List<Integer> inOrderTraversalUnRecur(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (!stack.empty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 用两个辅助栈实现二叉树的后序遍历,实现思路:
     * 1、弹出cur
     * 2、cur放入结果栈
     * 3、先左再右 循环往复
     */
    public static List<Integer> postOrderTraversalUnRecur(TreeNode node){
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(node);
        while (!s1.empty()){
            TreeNode cur = s1.pop();
            s2.add(cur);
            if (cur.left != null){
                s1.add(cur.left);
            }
            if (cur.right != null){
                s1.add(cur.right);
            }
        }
        while (!s2.empty()){
            res.add(s2.pop().val);
        }
        return res;
    }



    public static void main(String[] args) {
        /**
         *                         1
         *                     /       \
         *                 2               3
         *              /     \         /     \
         *           4           5   8           9
         *                     /       \
         *                   6           10
         *                  /           /
         *                 7           11
         */
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node8;
        node3.right = node9;

        node5.left = node6;

        node6.left = node7;

        node8.right = node10;

        node10.left = node11;

        TreeNodeShow.show(node1);

        System.out.println("------------递归的方式实现二叉树的三种遍历 begin------------");

        List<Integer> res = recurOrder(node1);
        System.out.println("递归序列输出二叉树:" + Joiner.on(",").join(res));// 递归序列输出二叉树:1,2,4,4,4,2,5,5,5,2,1,3,6,6,6,3,7,7,7,3,1

        res = preOrderTraversal(node1);
        System.out.println("前序遍历输出二叉树:" + Joiner.on(",").join(res));// 前序遍历输出二叉树:1,2,4,5,3,6,7

        res = inOrderTraversal(node1);
        System.out.println("中序遍历输出二叉树:" + Joiner.on(",").join(res));// 中序遍历输出二叉树:4,2,5,1,6,3,7

        res = postOrderTraversal(node1);
        System.out.println("后序遍历输出二叉树:" + Joiner.on(",").join(res));// 后序遍历输出二叉树:4,5,2,6,7,3,1
        System.out.println("------------递归的方式实现二叉树的三种遍历 end------------");

        System.out.println("------------非递归 的方式实现二叉树的三种遍历 begin------------");

        res = preOrderTraversalUnRecur(node1);
        System.out.println("前序遍历输出二叉树:" + Joiner.on(",").join(res));// 前序遍历输出二叉树:1,2,4,5,3,6,7

        res = inOrderTraversalUnRecur(node1);
        System.out.println("中序遍历输出二叉树:" + Joiner.on(",").join(res));// 中序遍历输出二叉树:4,2,5,1,6,3,7

        res = postOrderTraversalUnRecur(node1);
        System.out.println("后序遍历输出二叉树:" + Joiner.on(",").join(res));// 后序遍历输出二叉树:4,5,2,6,7,3,1

        System.out.println("------------非递归 的方式实现二叉树的三种遍历 end------------");
    }
}
