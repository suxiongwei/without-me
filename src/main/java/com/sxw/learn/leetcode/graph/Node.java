package com.sxw.learn.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的节点
 */
public class Node {
    public int val;
    public int in;// 节点的入度
    public int out;// 节点的出度
    public List<Node> nexts;// 该节点指向的节点
    public List<Edge> edges;// 该节点的边

    public Node(int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
