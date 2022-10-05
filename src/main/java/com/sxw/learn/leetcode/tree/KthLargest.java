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
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        /**
         * 输入: root = [5,3,6,2,4,null,null,1], k = 3
         *        5
         *       / \
         *      3   6
         *     / \
         *    2   4
         *   /
         *  1
         * 输出: 4
         */
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        KthLargest solution = new KthLargest();
        int i = solution.kthLargest(node5, 3);
        System.out.println(i);
    }

}
