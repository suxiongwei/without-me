package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-07 7:45 下午
 */
public class RightSideView {
    List<Integer> res = new ArrayList<>();

    /**
     * BFS解法
     * @param root
     * @return
     */
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) return res;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()){
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             TreeNode node = queue.poll();
    //             if (node.left != null) queue.offer(node.left);
    //             if (node.right != null) queue.offer(node.right);
    //             if (i == size - 1){
    //                 res.add(node.val);
    //             }
    //         }
    //     }
    //     return res;
    // }

    /**
     * DFS解法 递归
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);// 如果当前节点所在深度没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此加入
        depth ++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
