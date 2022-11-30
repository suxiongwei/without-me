package com.sxw.learn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 有效的括号(20)
 * [题目描述]:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * [解题思路]:
 * 辅助栈
 */
public class IsValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('?', '?');
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        // 防止28行NPE 如果左边没有有之匹配的左括号，比如(){}}{
        stack.addLast('?');
        for(int i = 0; i < chars.length; i++){
            char temp = chars[i];
            // 证明是左括号
            if(map.containsKey(temp)){
                stack.addLast(temp);
            }
            // 证明是右括号
            else{
                char popChar = stack.pollLast();
                if (temp != map.get(popChar)){
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        IsValid solution = new IsValid();
        boolean valid = solution.isValid("()");
        System.out.println(valid);
    }
}
