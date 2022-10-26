package com.sxw.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [题目]: 单词拆分(139)
 * [题目描述]:
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * [解题思路]:
 * 使用动态规划,dp[i]表示s 的前 i 位是否可以用 wordDict 中的单词表示
 * 以 输入: s = "leetcode", wordDict = ["leet", "code"]为例子，动态规划表如下：
 * ""       l       e       e       t       c       o       d       e
 * true     false   false   false   true    false   false   false   true
 *
 * 具体dp[4],也就是第一个t字符，循环dp[0]~dp[3]，只要有一个符合要求就为true，也就是 "" + leet、l + eet、le + et、lee + t
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String s1 = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(s1)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak.wordBreak(s, wordDict);
    }
}
