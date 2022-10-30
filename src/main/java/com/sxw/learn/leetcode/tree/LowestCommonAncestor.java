package com.sxw.learn.leetcode.tree;

/**
 * [题目描述]：二叉树的最近公共祖先(236)
 * [说明]：前提条件是一定存在公共祖先
 * [解题思路]：
 */
public class LowestCommonAncestor {
    private static TreeNode ans;
    public static TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        dfs(node, p, q);
        return ans;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);
        // 两种情况可以认为找到了最近公共祖先，只要有一种满足则证明找到了结果
        boolean b1 = lSon && rSon;// p和q分别在root的左右子树
        boolean b2 = (lSon || rSon) && (p.val == root.val || q.val == root.val);// p和q其中一个为当前节点，一个为子节点
        if (b1 || b2) ans = root;
        return lSon || rSon || (p.val == root.val || q.val == root.val);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node1.left = node0;
        node1.right = node8;

        node2.left = node7;
        node2.right = node4;

        TreeNodeShow.show(node3);

        TreeNode lowestCommonAncestor = LowestCommonAncestor.lowestCommonAncestor(node3, node5, node4);
        System.out.println("最低公共祖先节点：" + lowestCommonAncestor.val);
    }
}
