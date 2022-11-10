package com.sxw.learn.leetcode.tree;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return recur(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    // 判断树 A 中 以 A 为根节点的子树 是否包含树 B
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null && A == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
