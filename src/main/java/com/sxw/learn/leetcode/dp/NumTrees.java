package com.sxw.learn.leetcode.dp;

/**
 * [题目]: 不同的二叉搜索树(96)
 * [题目描述]:
 * 给你一个整数n，求恰由n个节点组成且节点值从1到n互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 * [解题思路]:
 * 数学问题
 * 定义：
 * G(n):长度为n的序列能构成的不同二叉树的个数
 * F(i, n):以 i 为根、序列长度为n的不同二叉树的个数
 */
public class NumTrees {
    public int numTrees(int n) {
        /**
         * dp[i] = i个不同的数组成的二叉搜索数的个数
         * 假设 i = 5
         * 当根节点等于 1 时 ，其余数字都比1大，只能在右边 dp[i] += dp[4]
         * 当根节点等于 2 时，左边有一个1比2小，右边有三个比2大的数字 dp[i] += dp[1] * dp[3]
         * 当根节点等于 3 时，左边有两个数比3小，右边有两个数比3大的数字 dp[i] += dp[2] * dp[2]
         * ...
         * 知道根节点等于5，左边有4个数字比5小，只能放在5的左边,dp[i] += dp[4]
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            System.out.println("i:" + i);
            for (int j = 1; j <= i; j++) {
                System.out.println("left:" + (j - 1) + " right:" + (i - j));
                int leftNum = dp[j - 1];
                int rightNum = dp[i - j];
                dp[i] += leftNum * rightNum;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees solution = new NumTrees();
        int i = solution.numTrees(3);
        System.out.println(i);
    }
}
