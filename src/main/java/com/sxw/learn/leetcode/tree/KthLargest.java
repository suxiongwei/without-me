package com.sxw.learn.leetcode.tree;

[]
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
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.value;
        dfs(root.left);
    }


}
