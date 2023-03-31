package com.sxw.learn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [题目]: 去除重复字母(316)
 * [题目描述]:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * [解题思路]:
 * 单调栈
 */
public class RemoveDuplicateLetters {
    // bcabc -> abc
    // cbacdcbc -> acdb
    public String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[] lastIndex = new int[26];

        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque();
        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) {
                continue;
            }
            // 单调栈不为空，且当前元素字典序比栈顶元素小，且栈顶元素之后还会再次出现
            while (!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.pollLast();
                visited[top - 'a'] = false;
            }
            // 只是调整单调栈中的元素，当前元素无论如何都会入栈
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
