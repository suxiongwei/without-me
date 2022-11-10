package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 解码方法(91)
 * [题目描述]:
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * [解题思路]:
 * 动态规划
 */
public class NumDecodings {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;// 的边界条件为1，含义为：空字符串可以有 1 种解码方法，解码出一个空字符串
        for (int i = 1; i <= n; i++) {// 实际的遍历还是从字符串的0位置开始的 即 下面的i-1
            // 不为0，只选当前位置的元素，那么解码方法种类数不变
            if (chars[i - 1] != '0'){
                dp[i] = dp[i - 1];
            }
            // 选择当前元素和前一个元素
            if (i > 1 && chars[i - 2] != '0' && ((chars[i - 2] - '0') * 10 + chars[i - 1] - '0') <= 26){
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumDecodings solution = new NumDecodings();
        int res = solution.numDecodings("226");
        System.out.println(res);
    }
}
