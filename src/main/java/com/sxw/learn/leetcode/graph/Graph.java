package com.sxw.learn.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 图
 */
public class Graph {
    public Map<Integer, Node> nodes;// Map key:节点的值 value:节点构建的node值
    public Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
