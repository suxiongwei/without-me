package com.sxw.learn.leetcode.other;

import java.util.*;

/**
 * [题目]: 组合总和(39)
 * [题目描述]:
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * 
 * [解题思路]:
 * 递归、回溯、剪枝
 */
public class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();
    // 回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        dfs(candidates, 0, candidates.length, target, new ArrayDeque<>());
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path){
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++){
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, i, len, target - candidates[i], path);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    // 将目标数组排序后，如果target已经为负，则接下来的路径也不可能成功，可以进行剪枝
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs1(candidates, 0, candidates.length, target, new ArrayDeque<>());
        return res;
    }

    private void dfs1(int[] candidates, int begin, int len, int target, Deque<Integer> path){
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++){
            if (target - candidates[i] < 0) break;// 进行剪枝
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }
}
