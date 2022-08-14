package com.sxw.learn.leetcode.dp;

/**
 * 给定一个正数数组，里面的每一个数代表了一枚硬币以及它的面值，如果给定一个值aim，返回组成aim所需的最少硬币个数
 *
 * 学习一种方法：递归过程改动态规划表
 * 1、递归(尝试)一旦确定
 * 2、计划搜索的方法就是加缓存
 * 3、变成严格位置表依赖
 *  3.1、分析可变参数的变化范围
 *  3.2、标出要计算的终止位置
 *  3.3、标出不用计算的直接出答案的位置(根据base case)
 *  3.4、推出普遍的位置是如何依赖其它位置的
 *  3.5、确定依次计算的顺序
 */
public class CoinsMin {
    public static int coinsMin(int[] arr, int aim){
        return process(arr, 0, aim);
    }

    // 尝试的解法
    // arr[index...]组成rest这么多钱，返回最少的硬币个数，具体分析的思路可以通过画一颗树分析，就是每个硬币不停的试
    public static int process(int[] arr, int index, int rest){
        if (index == arr.length) return -1;// 没有剩余的硬币了，直接返回-1无效解
        if (rest < 0) return -1;// 已经为负数了，不可能再有组合的方式了，直接返回-1无效解
        if (rest == 0) return 0;// 之前的方式，已经是一种方案了，直接返回，此时0也是一个有意义的值
        // 开始处理rest > 0的情况
        int p1 = process(arr, index + 1, rest);// 不要当前的硬币,用剩下的硬币搞定rest
        int p2Next = process(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        }else {
            if (p1 == -1) return p2Next + 1;// 因为用了当前的硬币，所以需要加一
            if (p2Next == -1) return p1;// 这两个-1的判断，无效解根本不会用，返回有效解法，避免了进入min的判断，否则无效解的-1永远是最小值
            return Math.min(p1, p2Next + 1);// 两个都不是-1，做决策
        }
    }

    // 用缓存的方式
    public static int coinsMin1(int[] arr, int aim){
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++){
            for (int j = 0; j <= aim; j++){
                dp[i][j] = -2;// 初始设置一个值
            }
        }
        return process2(arr, 0, aim, dp);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp){
        if (rest < 0) return -1;
        if (dp[index][rest] != -2) return dp[index][rest];// 保证每个格子不会重复被设置
        if(rest == 0) {
            dp[index][rest] = 0;
        }else if (index == arr.length){
            dp[index][rest] = -1;
        }else {
            int p1 = process2(arr, index + 1, rest, dp);
            int p2Next = process2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2Next == -1) {
                dp[index][rest] = -1;
            }else {
                if (p1 == -1) {
                    dp[index][rest] = p2Next + 1;
                }else if(p2Next == -1){
                    dp[index][rest] = p1;
                }else {
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[index][rest];
    }

    /**
     * 用动态规划表的方式
     *
     * 举例子：数组为[2,3,5,7,2] aim=10
     * 初始化二维数组(index做行，剩余钱数rest做列)：
     *      0  1   2   3   4   5   6   7   8   9   10
     * 0    0                                       最终要的位置
     * 1    0
     * 2    0
     * 3    0
     * 4    0
     * 5    0 -1  -1  -1  -1  -1  -1  -1  -1  -1   -1
     *
     * 按照步骤修改分析：
     * 1、分析可变参数的变化范围 -> index做行，剩余钱数rest做列
     * 2、标出要计算的终止位置 -> index = 5 和 rest < 0
     * 3、标出不用计算的直接出答案的位置(根据base case) -> rest = 0 时都是0，index越界都是-1
     * 4、推出普遍的位置是如何依赖其它位置的 -> 递归函数里的if else
     * 5、确定依次计算的顺序 -> 从底往上
     * 说明:
     * index = 5是为了设置终止位置
     *
     */
    public static int coinsMin3(int[] arr, int aim){
        // 初始化动态规划表
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int row = 0; row <= N; row++){
            dp[row][0] = 0;// 初始化列
        }
        for (int col = 1; col <= aim; col++){
            dp[N][col] = -1;
        }
        for (int index = N - 1; index >= 0; index--){
            for (int rest = 1; rest <= aim; rest++){
                int p1 = dp[index + 1][rest];
                int p2Next = rest - arr[index] < 0 ? -1 : dp[index + 1][rest - arr[index]];
                if (p1 == -1 && p2Next == -1){
                    dp[index][rest] = -1;
                }else {
                    if (p1 == -1) {
                        dp[index][rest] = p2Next + 1;
                    }else if (p2Next == -1) {
                        dp[index][rest] = p1;
                    }else {
                        dp[index][rest] = Math.min(p1, p2Next + 1);
                    }
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,100};
        System.out.println(coinsMin3(arr, 5));
    }
}
