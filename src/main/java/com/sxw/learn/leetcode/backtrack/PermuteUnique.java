package com.sxw.learn.leetcode.backtrack;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [题目]: 全排列II(47)
 * [题目描述]:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * [解题思路]:
 * 递归 + 回溯
 */
public class PermuteUnique {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, perm);
        return ans;
    }

    public void backtrack(int idx, int[] nums, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            backtrack(idx + 1, nums, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        PermuteUnique solution = new PermuteUnique();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = solution.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(Joiner.on(",").join(list));
        }
    }
}
