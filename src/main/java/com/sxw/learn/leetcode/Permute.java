package com.sxw.learn.leetcode;

import java.util.*;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 1){
            res.add(new ArrayList<Integer>(){{add(nums[0]);}});
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();// 已经选了哪些数
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);// depth 递归到了第几层
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{1,2,3});
    }
}
