package com.sxw.learn.leetcode.tree;

/**
 * [题目]: 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * [解法]:
 * 二叉搜索树的中序遍历为 递增序列 。
 * 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”。
 * 中序遍历为 “左、根、右” 顺序
 * 中序遍历的倒序为 “右、根、左” 顺序
 */
public class KthLargest {
    private int k, res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        if (root == null) return -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.right);// 先递归右子树，就是中序遍历的倒序
        if (k == 0) return;
        if (--k == 0) res = root.value;
        dfs(root.left);
    }


}
