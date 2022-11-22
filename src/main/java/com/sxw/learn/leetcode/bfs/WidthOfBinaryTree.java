package com.sxw.learn.leetcode.bfs;


import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 二叉树最大宽度(662)
 * [题目描述]:
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 *
 * [解题思路]:
 * BFS 初始化根的宽度为1，每次求下一层节点的宽度
 *
 * 此题求二叉树所有层的最大宽度，比较直观的方法是求出每一层的宽度，然后求出最大值。求每一层的宽度时，因为两端点间的 null 节点也需要计入宽度，
 * 因此可以对节点进行编号。一个编号为 index 的左子节点的编号记为 2×index，右子节点的编号记为 2×index+1，计算每层宽度时，用每层节点的最大编号减去最小编号再加 1 即为宽度。
 * 遍历节点时，可以用广度优先搜索来遍历每一层的节点，并求出最大值。
 */
public class WidthOfBinaryTree {
    class TreeNodeAndIndex {
        public TreeNode node;
        public int index;

        public TreeNodeAndIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNodeAndIndex> arr = new ArrayList<>();
        if (root == null) return 0;
        int res = 1;
        arr.add(new TreeNodeAndIndex(root, 1));
        while (arr.size() != 0) {
            List<TreeNodeAndIndex> tmp = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                TreeNodeAndIndex tmpNode = arr.get(i);
                if (tmpNode.node.left != null) {
                    tmp.add(new TreeNodeAndIndex(tmpNode.node.left, tmpNode.index * 2));
                }
                if (tmpNode.node.right != null) {
                    tmp.add(new TreeNodeAndIndex(tmpNode.node.right, tmpNode.index * 2 + 1));
                }
            }
            if (tmp.size() > 0) {// 已经没有下一层了，所以下一层不存在宽度
                res = Math.max(tmp.get(tmp.size() - 1).index - tmp.get(0).index + 1, res);
            }
            arr = tmp;
        }
        return res;
    }
}
