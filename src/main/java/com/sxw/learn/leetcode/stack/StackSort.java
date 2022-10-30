package com.sxw.learn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [题目]: 双栈排序
 * [题目描述]:
 * https://mp.weixin.qq.com/s/g_AqwsSEUwlRSevnStPkEA
 * [解题思路]:
 * 用一个临时变量与辅助栈中的值相比较，进行主栈与辅助栈的弹出弹入操作
 */
public class StackSort {
    // 4, 2, 1, 3
    public Deque<Integer> stackSort(Deque<Integer> stack) {
        Deque<Integer> tmpStack = new ArrayDeque<>();
        tmpStack.addFirst(stack.pollFirst());
        while (!stack.isEmpty()){
            Integer topVal = stack.pollFirst();
            while (!tmpStack.isEmpty() && topVal < tmpStack.peekFirst()){
                stack.addFirst(tmpStack.pollFirst());
            }
            tmpStack.addFirst(topVal);
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(4);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addFirst(3);
        StackSort solution = new StackSort();
        Deque<Integer> result = solution.stackSort(deque);
        while (!result.isEmpty()){
            System.out.println(result.pollFirst());
        }
    }
}
