package com.sxw.learn.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * [题目]：图的宽度优先遍历
 *
 * [题解]：
 * 1、利用队列实现
 * 2、从源节点开始依次按照宽度进队列，然后弹出
 * 3、每弹出一个节点，把该节点所有没有进过队列的邻接点放入队列
 * 4、直到队列为空
 */
public class BFS {
    public static void bfs(Node node){
        if (node == null) return;
        Set<Node> nodeSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        nodeSet.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.val);
            for (Node next : cur.nexts) {
                if (!nodeSet.contains(next)) {
                    queue.add(next);
                    nodeSet.add(next);
                }
            }
        }
    }
}
