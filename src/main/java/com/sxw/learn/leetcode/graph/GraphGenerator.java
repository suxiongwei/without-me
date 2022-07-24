package com.sxw.learn.leetcode.graph;

/**
 * 生成图
 */
public class GraphGenerator {
    // matrix 所有的边
    // N * 3的矩阵
    // 每一行存储的元素 [from节点的值，to节点的值、wight]
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer wight = matrix[i][2];
            if (graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if (graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(wight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
