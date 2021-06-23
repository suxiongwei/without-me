package com.sxw.learn.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();// 单调栈 栈中存的是元素的下标
        int[] result = new int[T.length];
        for (int i : T) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
