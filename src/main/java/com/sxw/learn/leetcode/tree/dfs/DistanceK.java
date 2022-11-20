package com.sxw.learn.leetcode.tree.dfs;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [题目]: 二叉树中所有距离为K的结点(863)
 * [题目描述]:
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
 * 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。
 *
 * [解题思路]:
 * 1、DFS的方式，建立子节点到父节点的映射关系
 * 2、DFS的方式，从左、右、父三个方向查找答案
 */
public class DistanceK {
    public Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);
        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);
        return ans;
    }

    public void findParents(TreeNode node){
        if (node.left != null){
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null){
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    // 增加from，在递归前比较目标结点是否与来源结点相同
    // 比如node1先到node2的左儿子，在node1找parent后，parent再递归左孩子的时候会再次回到当前节点
    public void findAns(TreeNode node, TreeNode from, int depth, int k){
        if (node == null){
            return;
        }
        if (depth == k){
            ans.add(node.val);
            return;
        }
        if (node.left != from){
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from){
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) !=from){
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
