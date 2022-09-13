package com.sxw.learn.leetcode.str;


import java.util.Arrays;

/**
 * [题目]: 字符串的排列(567)
 * [题目描述]:
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * [解题思路]:
 * 由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) return false;
        int[] char1 = new int[26];
        int[] char2 = new int[26];
        for (int i = 0; i < n; i++) {
            char1[s1.charAt(i) - 'a']++;
            char2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(char1, char2)) return true;
        for (int i = n; i < m; i++) {
            char2[s2.charAt(i) - 'a']++;
            char2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(char1, char2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }
}
