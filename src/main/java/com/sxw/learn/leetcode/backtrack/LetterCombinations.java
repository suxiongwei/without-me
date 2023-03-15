package com.sxw.learn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [题目]: 电话号码的字母组合(17)
 * [题目描述]:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射（与电话按键相同）。注意 1 不对应任何字母。
 * [解题思路]:
 * 递归 + 回溯 + 哈希
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    List<Character> characterList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // base case
        if (digits == null || digits.equals("")) return res;

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        dfs(digits, phoneMap, 0);
        return res;
    }

    // 当前处理到目标字符串digits的index位置
    private void dfs(String digits, Map<Character, String> phoneMap, int index) {
        if (index == digits.length()) {
            StringBuilder sb = new StringBuilder();
            characterList.stream().forEach(i -> sb.append(i));
            res.add(sb.toString());
            return;
        }
        Character curNum = digits.charAt(index);
        String curNumChar = phoneMap.get(curNum);
        for (int curNumIndex = 0; curNumIndex < curNumChar.length(); curNumIndex++) {
            characterList.add(curNumChar.charAt(curNumIndex));
            dfs(digits, phoneMap, index + 1);
            characterList.remove(characterList.size() - 1);
        }
    }
}
