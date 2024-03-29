package com.sxw.learn.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [题目]: 最长有效括号(32)
 * [题目描述]:
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * [解题思路]:
 * 栈：始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        Deque<Integer> stack = new LinkedList<>();// 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {// 说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                    stack.push(i);
                } else {// 当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        int parentheses = solution.longestValidParentheses(")()())");
        System.out.println(parentheses);
    }
}
