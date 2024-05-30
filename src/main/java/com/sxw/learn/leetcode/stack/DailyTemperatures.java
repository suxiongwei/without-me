package com.sxw.learn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * [题目]: 每日温度(739)
 * [题目描述]:
 * 给定一个整数数组temperatures ，表示每天的温度，返回一个数组answer，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * temperatures = [73,74,75,71,69,72,76,73]
 * ans = [1,1,4,2,1,1,0,0]
 * [解题思路]:
 * 单调栈
 */
public class DailyTemperatures {
    // 构建单调递增栈，栈顶到栈底单调递增
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];// 默认都是0
        Deque<Integer> deque = new ArrayDeque<>();// 存储下标，栈底到栈顶从大到小
        for (int i = 0; i < n; i++) {
            int curVal = temperatures[i];
            while (!deque.isEmpty() && temperatures[deque.peekFirst()] < curVal) {
                int pollIndex = deque.pollFirst();
                res[pollIndex] = i - pollIndex;
            }
            deque.addFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
}
