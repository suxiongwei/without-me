package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class WidthOfBinaryTree {
    /**
     * 宽度优先搜索
     * @param root
     * @return
     */
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        Queue<AnnotatedNode> queue = new LinkedList();
//        queue.add(new AnnotatedNode(root, 0, 0));
//        int curDepth = 0, left = 0, ans = 0;
//        while (!queue.isEmpty()){
//            AnnotatedNode a = queue.poll();
//            if (a.node != null){
//                if (curDepth != a.depth){// 遍历当前层的第一个节点（最左边的节点）时，将depth更新
//                    curDepth = a.depth;
//                    left = a.pos;
//                }
//                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
//                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
//                ans = Math.max(ans, a.pos - left + 1);
//            }
//        }
//        return ans;
//    }

    int ans;
    Map<Integer, Integer> left;

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }

}

class AnnotatedNode{
    TreeNode node;
    int depth,pos;

    public AnnotatedNode(TreeNode node, int depth, int pos) {
        this.node = node;
        this.depth = depth;
        this.pos = pos;
    }
}
