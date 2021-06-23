package com.sxw.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-23 10:34 上午
 */
public class MaxDepth {
    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     int leftLength = maxDepth(root.left);
    //     int rightLength = maxDepth(root.right);
    //     return Math.max(leftLength, rightLength) + 1;
    // }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans++;
        }
        return ans;
    }
}
