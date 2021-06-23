package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-11 3:12 下午
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length(), haystackLength = haystack.length();
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
