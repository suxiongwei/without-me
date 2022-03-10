package com.sxw.learn.leetcode.array;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description 14. 最长公共前缀
 * @Date 2021-03-11 2:20 下午
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) return "";
        String prefix = strs[0];
        int prefixLength = prefix.length();
        for (int i = 0; i <= prefixLength; i++) {
            if (prefix.length() == 0) return "";
            int size = 0;
            prefix = prefix.substring(0, prefixLength - i);
            for (int j = 1; j < length; j++) {
                if (strs[j].startsWith(prefix)) {
                    size++;
                }else {
                    break;
                }
            }
            if (size == length - 1) return prefix;
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String prefix = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(prefix);
    }
}
