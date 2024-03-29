package com.sxw.learn.leetcode.other;

import java.util.*;

/**
 * [题目]: 课程表(207)
 * [题目描述]:
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * [解题思路]:
 * 拓扑排序
 */
public class CanFinish {
    // 节点的入度: 使用数组保存每个节点的入度
    // prerequisites = {3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}  numCourses = 6
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2.依赖关系, 依赖当前课程的后序课程 key是前置课程，value是学完key才能学的课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表,就是谁依赖我了)
            int cur = relate[0];
            int preNeedLearnCourse = relate[1];
            // 1.更新入度
            inDegree.put(cur, inDegree.get(cur) + 1);
            // 2.当前节点的邻接表
            if (!adj.containsKey(preNeedLearnCourse)) {
                adj.put(preNeedLearnCourse, new ArrayList<>());
            }
            adj.get(preNeedLearnCourse).add(cur);
        }
        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);
            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }
        // 4.遍历入队, 如果还有课程的入度不为0, 返回fasle
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] course = new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}};
        boolean res = new CanFinish().canFinish(6, course);
        System.out.println(res);
    }
}
