package com.sxw.learn.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1, queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // queue2始终是空的,这样新进来的元素一定是第一个
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.poll();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
