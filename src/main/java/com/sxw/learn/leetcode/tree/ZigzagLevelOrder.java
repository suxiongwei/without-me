package com.sxw.learn.leetcode.tree;

import java.util.*;
/**
 * [题目]: 二叉树的锯齿形层序遍历(103)
 * [题目描述]:
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * [解题思路]:
 * 利用双端队列 和一个 布尔型变量
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque();
        boolean fromLeft = false;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            Deque<Integer> curLevelResult = new ArrayDeque<>();
            int size = deque.size();
            while (size > 0){
                TreeNode curNode = deque.poll();
                if (fromLeft){
                    curLevelResult.offerFirst(curNode.val);
                }else {
                    curLevelResult.offerLast(curNode.val);
                }
                if (curNode.left != null){
                    deque.offer(curNode.left);
                }
                if (curNode.right != null){
                    deque.offer(curNode.right);
                }
                size--;
            }
            fromLeft = !fromLeft;
            result.add(new LinkedList<>(curLevelResult));
        }
        return result;
    }
}
