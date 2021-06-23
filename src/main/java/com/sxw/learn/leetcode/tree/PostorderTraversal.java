package com.sxw.learn.leetcode.tree;

import com.sxw.learn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
