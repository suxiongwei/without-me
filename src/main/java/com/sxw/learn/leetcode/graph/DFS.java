package com.sxw.learn.leetcode.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * [题目]：深度优先搜索(如果这条路没走过，就逮着这条路一直往下走)
 * [题解]：
 * 1、利用栈实现
 * 2、从源节点开始把节点按照深度放入栈，然后弹出
 * 3、每弹出一个点，把该节点的下一个没有进过栈的邻接点放入栈
 * 4、直到栈为空
 *
 */
public class DFS {
    public static void dfs(Node node){
        if (node == null) return;
        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        set.add(node);
        stack.add(node);
        System.out.println(node.val);
        while (!stack.empty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.val);
                    break;// 因为上面也把cur压栈了，所以可以break
                }
            }
        }
    }
}
