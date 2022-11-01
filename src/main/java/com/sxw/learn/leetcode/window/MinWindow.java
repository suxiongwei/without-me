package com.sxw.learn.leetcode.window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * [题目]: 最小覆盖子串(76)
 * [题目描述]:
 * 给你一个字符串s 、一个字符串t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * [解题思路]:
 * 滑动窗口
 */
public class MinWindow {
    Map<Character, Integer> ori = new HashMap<>();// 存储字符串t中每个字符和每个字符出现的次数
    Map<Character, Integer> cnt = new HashMap<>();// // 动态存储截取的字符串中每个字符包含的个数

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {// cnt为当前匹配出来的字符串
                return false;
            }
        }
        return true;
    }
}
