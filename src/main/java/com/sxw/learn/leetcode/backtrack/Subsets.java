package com.sxw.learn.leetcode.backtrack;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 子集(78)
 * [题目描述]:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * [解题思路]:
 * 回溯
 */
public class Subsets {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(0, nums);
        return res;
    }

    // 需要画出递归回溯的流程图，便于理解
    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets solution = new Subsets();
        List<List<Integer>> subsets = solution.subsets(nums);
        subsets.stream().forEach(e -> System.out.println(Joiner.on(",").join(e)));
    }
}
