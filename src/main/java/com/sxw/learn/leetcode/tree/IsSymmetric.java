package com.sxw.learn.leetcode.tree;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-01 4:30 下午
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }
    boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.value == q.value && check(p.left, q.right) && check(p.right, q.left);
    }
}
