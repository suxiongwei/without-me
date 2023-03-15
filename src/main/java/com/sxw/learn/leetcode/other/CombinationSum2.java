package com.sxw.learn.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [题目]: 组合总和II(40)
 * [题目描述]:
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * [解题思路]:
 * 递归 + 回溯 + 剪枝
 * 可以画出递归树，便于理解
 */
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    void dfs(int[] candidates, int start, int target) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 排序后的目的就是便于这里的剪枝
        for (int curStart = start; curStart < candidates.length && sum + candidates[curStart] <= target; curStart++) {
            // 元素只能出现一次,也就是说 1,1,6 这种结果是合法的，而不是只能为1,7
            if (curStart > start && candidates[curStart] == candidates[curStart - 1]) {
                continue;
            }
            sum += candidates[curStart];
            path.add(candidates[curStart]);
            System.out.println("当前数:" + candidates[curStart] + ",总和:" + sum + ",path:" + path);
            dfs(candidates, curStart + 1, target);
            sum -= candidates[curStart];
            path.remove(path.size() - 1);
            System.out.println("return后当前数:" + candidates[curStart] + ",总和:" + sum + ",path:" + path);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        lists.stream().forEach(System.out::println);
    }

}
