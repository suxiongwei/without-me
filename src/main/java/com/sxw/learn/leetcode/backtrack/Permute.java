package com.sxw.learn.leetcode.backtrack;

import java.util.*;

/**
 * [题目]: 全排列(46)
 * [题目描述]: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * [解题思路]: 回溯算法
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();// 使用一个动态数组保存所有可能的全排列
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {// 如果去掉这个限制，返回的是全排列：[], [1], [1, 2], [1, 2, 3], [1, 3], [1, 3, 2], [2], [2, 1], [2, 1, 3], [2, 3], [2, 3, 1], [3], [3, 1], [3, 1, 2], [3, 2], [3, 2, 1]
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            System.out.println("i=" + i + ";used:" + Arrays.toString(used) + ";path:" + path);
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();// 使用一个动态数组保存所有可能的全排列
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs1(nums, len, path, used, res, 0);
        return res;
    }

    private void dfs1(int[] nums, int len, List<Integer> path, boolean[] used, List<List<Integer>> res, int depth) {
        res.add(new ArrayList<>(path));
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                String s = String.format("递归前：depth=%d; i=%d; used=%s; path=%s", depth, i, Arrays.toString(used), path);
                System.out.println(s);

                dfs1(nums, len, path, used, res, depth + 1);

                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);

                String s1 = String.format("递归后：depth=%d; i=%d; used=%s; path=%s", depth, i, Arrays.toString(used), path);
                System.out.println(s1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
//        List<List<Integer>> lists = solution.permute(nums);
        List<List<Integer>> lists = solution.permute1(nums);

        System.out.println(lists);
    }
}
