package com.sxw.learn.leetcode.str;

/**
 * [题目]: 比较版本号(165)
 * [题目描述]:
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * <p>
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * <p>
 * [解题思路]:
 * 双指针
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int n = version1.length();// 1.01
        int m = version2.length();// 1.001
        int i = 0;// 外层定义变量，指针是一直往后推的
        int j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;// 跳过 .
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;// 跳过 .
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    // 2023.02.10 code 2024.05.21再次编码，也是这种思路
    public int compareVersion1(String version1, String version2) {
        char[] chars1 = version1.toCharArray();
        char[] chars2 = version2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int i = 0;
        int j = 0;
        // 控制遍历完两个字符串的全部字符
        while (i < len1 || j < len2) {
            // 结果默认为0，隐藏的含义将缺失的修订号视为 0
            int version1Num = 0;
            int version2Num = 0;
            while (i < len1 && chars1[i] != '.') {
                version1Num = version1Num * 10 + chars1[i] - '0';
                i++;
            }
            while (j < len2 && chars2[j] != '.') {
                version2Num = version2Num * 10 + chars2[j] - '0';
                j++;
            }
            if (version1Num == version2Num) {
                i++;
                j++;
            } else {
                return version1Num > version2Num ? 1 : -1;
            }
        }
        return 0;
    }
}
