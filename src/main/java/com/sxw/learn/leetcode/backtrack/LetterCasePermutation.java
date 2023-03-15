package com.sxw.learn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 字母大小写全排列(784)
 * [题目描述]:
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 *
 * [解题思路]: 回溯算法 深度优先遍历
 * 变换大小写这件事等价于：
 *
 * 技巧：
 * 如果字符是小写字符，减去 32 得到大写字符；
 * 如果字符是大写字符，加上 32 得到小写字符。
 * 而这两者合并起来，就是给这个字符做一次不进位的加法，即异或上 1 << 5。
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] charArray = S.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {// 判断是否为字母
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation solution = new LetterCasePermutation();
        List<String> letterCasePermutation = solution.letterCasePermutation("a1b2");
        letterCasePermutation.forEach(System.out::println);
    }
}
