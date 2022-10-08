package com.sxw.learn.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 括号生成(22)
 * [题目描述]:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * [解题思路]:
 * 1、暴力递归
 * 2、回溯法
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 1) return ans;
        StringBuilder sb = new StringBuilder();
        backtrack(ans, sb, 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2){
            ans.add(sb.toString());
            return;
        }
        if (open < max){
            sb.append("(");
            backtrack(ans, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open){
            sb.append(")");
            backtrack(ans, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        // ["((()))","(()())","(())()","()(())","()()()"]
        List<String> list = solution.generateParenthesis(3);
        list.stream().forEach(System.out::println);
    }
}
