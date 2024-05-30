package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 最长公共子序列(1143)
 * [题目描述]:
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * [解题思路]:
 * 动态规划
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int dp[][] = new int[M + 1][N + 1];// dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列
        for (int i = 1; i <= M; i++) {// 初始的格子，第0行第0列为0
            for (int j = 1; j <= N; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        /**
         * "GATA", "TAGAAGGT" 对应的动态规划表如下
         *          T  A  G  A  A  G  G  T
         *      [0, 0, 0, 0, 0, 0, 0, 0, 0]
         *  G   [0, 0, 0, 1, 1, 1, 1, 1, 1]
         *  A   [0, 0, 1, 1, 2, 2, 2, 2, 2]
         *  T   [0, 1, 1, 1, 2, 2, 2, 2, 3]
         *  A   [0, 1, 2, 2, 2, 3, 3, 3, 3]
         */
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        int i = solution.longestCommonSubsequence("GATA", "TAGAAGGT");
        System.out.println(i);
    }
}
