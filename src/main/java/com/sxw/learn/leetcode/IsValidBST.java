package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-23 10:08 上午
 */
public class IsValidBST {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            System.out.println("return false -> node:" + node.val + " lower:" + lower + " upper:" + upper);
            return false;
        }
        System.out.println("node:" + node.val + " lower:" + lower + " upper:" + upper);
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
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

        IsValidBST isValidBST = new IsValidBST();
        isValidBST.isValidBST(node17);
    }
}
