package com.sxw.learn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [题目]: 有效的括号字符串(678)
 * [题目描述]:
 * 给定一个只包含三种字符的字符串：(，) 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * [解题思路]:
 * 栈
 * 用两个栈，分别存储左括号和星号
 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        // 用来存储左括号, 注意存储的是下标，能存储更多的元素
        Deque<Integer> deque1 = new ArrayDeque();
        // 用来存储*号
        Deque<Integer> deque2 = new ArrayDeque();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == '(') {
                deque1.offerFirst(i);
            } else if (cur == '*') {
                deque2.offerFirst(i);
            } else {
                // 优先匹配左括号
                Integer left = deque1.pollFirst();
                if (left == null) {
                    // 没有与之对应的左括号，再匹配 *
                    left = deque2.pollFirst();
                    if (left == null) {
                        return false;
                    }
                }
            }
        }
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            // 存储左括号
            Integer index1 = deque1.pollFirst();
            // 存储了 *
            Integer index2 = deque2.pollFirst();
            // 栈顶元素是数组的末尾方向的元素，因此当 '(' 的右边没有 '*' 时匹配出错
            if (index1 > index2) {
                return false;
            }
        }
        return deque1.isEmpty();
    }

    public static void main(String[] args) {
        CheckValidString solution = new CheckValidString();
        // (((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())
        boolean b = solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(b);
    }
}
