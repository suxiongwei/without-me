package com.sxw.learn.leetcode.dp;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * [题目]: 三角形最小路径和(120)
 * [题目描述]:
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * [解题思路]: 动态规划
 */
public class MinimumTotal {
    public static int solution(int[][] triangle){
        // 行
        int m = triangle.length;
        // 列
        int n = triangle[m - 1].length;

        // 定义：dp[i][j] 代表从bottom 到 (i，j)路径和的最小值
        int[][] dp = new int[m][n];
        // 最底层的显然都是 原始值triangle
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle[m - 1][i];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int i1 = 0; i1 < i + 1; i1++) {
                // System.out.println(triangle[i][i1]);
                int tmp = i1 + 1;
                dp[i][i1] = + triangle[i][i1] + Math.min(dp[i + 1][i1], dp[i + 1][tmp]);
            }
        }
        return dp[0][0];
    }

    // 与上面的只是入参的形式不同
    public static int solution(List<List<Integer>> triangle){
        // 行
        int m = triangle.size();
        // 列
        int n = triangle.get(m - 1).size();

        // 定义：dp[i][j] 代表从bottom 到 (i，j)路径和的最小值
        int[][] dp = new int[m][n];
        // 最底层的显然都是 原始值triangle
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static int solutionPlus(List<List<Integer>> triangle){
        // triangle.size() + 1防止数组越界，int初始值都是1,在填充最下层dp时，都会给原始值设置为triangle的值
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static int solutionPlusMax(List<List<Integer>> triangle){
        // triangle.size() + 1防止数组越界，int初始值都是1,在填充最下层dp时，都会给原始值设置为triangle的值
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        // int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        // int solution = solution(triangle);
        // System.out.println(solution);

        List<List<Integer>> triangle = Lists.newArrayList();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));

        int solution = solution(triangle);
        int solutionPlus = solutionPlus(triangle);
        System.out.println(solution);
        System.out.println(solutionPlus);
    }
}
