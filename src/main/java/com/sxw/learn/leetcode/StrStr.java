package com.sxw.learn.leetcode;

/**
 * [题目]: 实现 Sunday 匹配
 * [题目描述]: 实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        if (haystack == null || haystack.length() == 0) return 0;
        for (int start = 0; start < haystackLength - needleLength + 1; start++) {
            if (haystack.substring(start, start + needleLength).equals(needle)){
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("hello", "ll");
        System.out.println(i);
    }
}
