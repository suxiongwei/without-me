package com.sxw.learn.leetcode.tree;

/**
 * 二叉搜索数（二叉查找数、二叉排序树）
 * 定义：或者是一棵空树，或者是具有如此性质的树：
 *      若它的左子树不为空，则左子树的所有节点的值均小于它的根节点的值
 *      若它的右子树不为空，则右子树的所有节点的值均大于它的根节点的值
 *      它的左、右子树也分别为二叉搜索树
 *
 * [二叉搜索数验证]
 * - 解法一：本文档的解法
 * - 解法二：使用中序遍历，如果是升序，那就是搜索二叉树，具体编码就是将升序的打印时机换成比较时机
 */
public class IsValidBST {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.value <= lower || node.value >= upper) {
            System.out.println("return false -> node:" + node.value + " lower:" + lower + " upper:" + upper);
            return false;
        }
        System.out.println("node:" + node.value + " lower:" + lower + " upper:" + upper);
        return isValidBST(node.left, lower, node.value) && isValidBST(node.right, node.value, upper);
    }

    public static void main(String[] args) {
        TreeNode node17 = new TreeNode(17);
        TreeNode node5 = new TreeNode(5);
        TreeNode node35 = new TreeNode(35);
        TreeNode node2 = new TreeNode(2);
        TreeNode node16 = new TreeNode(16);
        TreeNode node29 = new TreeNode(29);
        TreeNode node38 = new TreeNode(38);
        TreeNode node19 = new TreeNode(19);
        TreeNode node33 = new TreeNode(33);

        node17.left = node5;
        node17.right = node35;

        node5.left = node2;
        node5.right =node16;

        node35.left = node29;
        node35.right = node38;

        node29.left = node19;
        node29.right = node33;

        TreeNodeShow.show(node17);

        IsValidBST.isValidBST(node17);
    }
}
