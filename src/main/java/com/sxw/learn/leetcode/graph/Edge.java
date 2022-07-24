package com.sxw.learn.leetcode.graph;

/**
 * 边
 */
public class Edge {
    private int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
