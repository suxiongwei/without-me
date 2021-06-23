package com.sxw.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-26 2:11 下午
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public List<Integer> preorder(TreeNode node, List<Integer> res){
        if (node == null) return res;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
        return res;
    }
}
