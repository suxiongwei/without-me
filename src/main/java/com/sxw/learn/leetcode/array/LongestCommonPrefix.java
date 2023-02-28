package com.sxw.learn.leetcode.array;

/**
 * @Description 14. 最长公共前缀
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

    // 2023.02.23 手写的版本
    public String longestCommonPrefix1(String[] strs) {
        // 获取数组中最小的元素，因为最长的前缀也不会超过最小的元素
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        // 拿可能出现的最大的前缀长度去尝试
        while (minLen >= 0) {
            boolean flag = true;
            for (int i = 0; i < strs.length; i++) {
                // substring 不包括结束索引
                String prefix = strs[0].substring(0, minLen);
                if (!strs[i].startsWith(prefix)) {// 出现了不是以当前字符串开头的字符串，尝试失败
                    flag = false;
                    break;
                }
            }
            if (flag == true) {// 当前前缀尝试成功，跳出循环，返回此结果
                break;
            }
            minLen--;
        }
        return minLen == 0 ? "" : strs[0].substring(0, minLen);// 处理边界情况，为0的返回""
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String prefix = longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(prefix);
    }
}
