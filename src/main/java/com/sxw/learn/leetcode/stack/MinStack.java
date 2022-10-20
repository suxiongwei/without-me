package com.sxw.learn.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [题目]: 最小栈(155)
 * [题目描述]:
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * [解题思路]:
 * 定义一个辅助栈 存储当前元素的最小值
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);// 防止peek NPE
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
