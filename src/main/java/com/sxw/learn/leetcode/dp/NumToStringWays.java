package com.sxw.learn.leetcode.dp;

/**
 * [题目]:
 * 将给定的数转换为字符串，原则如下：1对应 a，2对应b，…..26对应z，例如12258可以转换为"abbeh", "aveh", "abyh", "lbeh" and "lyh"，个数为5，
 * 编写一个函数，给出可以转换的不同字符串的个数。
 * [解题思路]:
 *  1)、穷举+剪枝，将所有情况都列举出来，然后剪到不符合要求的情况。可以画出递归图去理解 https://zhuanlan.zhihu.com/p/520451682
 *  2)、动态规划，递归改成动态规划
 */
public class NumToStringWays {
    public static int numToStringWays(int nums){
        return process(String.valueOf(nums).toCharArray(), 0);
    }

    // chs[0...index-1]已经转换完毕，并且转换正确
    // chs[index...]能转出多少有效的字符串表达
    public static int process(char[] chs, int index){
        if (index == chs.length) return 1;// 递归到结尾了，说明走通了一条路径(是一种方案)，return 1
        if (chs[index] == '0') return 0;// 开头为0，不能组出有效的字符
        int res = process(chs, index + 1);// index及其后续还是有字符的，可以做选择 -> 做一个选择，以chs[index]自己作为一个部分
        if (index == chs.length - 1) return res; // 以chs[index]做了选择后，后续没有字符了，返回这个选择的结果
        // index+1 依然没有越界，index 和 index+1共同构成一个部分去尝试
        if ((chs[index] - '0') * 10 + (chs[index + 1] - '0') < 27) {// char-'0'的目的是把字符转换成数字
            res += process(chs, index + 2);
        }
        return res;
    }

    // 动态规划版本
    public static int dpWays(int num){
        if (num < 1) return 0;
        char[] chs = String.valueOf(num).toCharArray();
        int N = chs.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        dp[N - 1] = chs[N - 1] == '0' ? 0 : 1;
        for (int i = N - 2; i >= 0; i--){
            if (chs[i] == '0'){
                dp[i] = 0;
            }else {
                dp[i] = dp[i + 1] + (((chs[i] - '0') * 10 + (chs[i + 1] - '0')) < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(dpWays(12258));
    }
}
