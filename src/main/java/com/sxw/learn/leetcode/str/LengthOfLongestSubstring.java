package com.sxw.learn.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 无重复字符的最长子串(3)
 * [题目描述]: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * [解题思路]: 滑动窗口
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap();
        for (int left = 0, right = 0; right < n; right++){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)));// 防止map中已有的字符已经不在当前的串中，然后左窗口从重复字符的下一个开始
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);// 注意这里是加1，即存储的时候就存储的是下一个字符的位置
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int s = solution.lengthOfLongestSubstring("abccbcbb");// 遇到第一个重复的c 直接从重复的c开始，因为前面的字符不可能有结果
        System.out.println(s);
    }
}
