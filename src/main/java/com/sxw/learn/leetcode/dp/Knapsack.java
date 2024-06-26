package com.sxw.learn.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包问题
 */
public class Knapsack {
    /**
     * 0 1背包
     * 给定n 种物品，每种物品都有重量wi 和价值vi ，每种物品都只有 一个。另外，背包容量为W 。求解在不超过背包容量的情况下将哪些
     * 物品放入背包，才可以使背包中的物品价值之和最大。每种物品只有 一个，要么不放入(0)，要么放入(1)，因此称之为01背包。
     *
     * 有5个物品，重量分别为2、5、4、2、3，价值分别为6、3、5、 4、6。背包的容量为10。求解在不超过背包容量的前提下将哪些物品 放入背包，才可以使背包中的物品价值之和最大。
     */
    public List<Integer> solution1(int w[], int v[], int m){
        /**
         * dp[i][j] 代表处理将前i件物品放入j的容量中的最大价值
         *
         * 第 i 种物品的处理状态包括以下两种。
         * 不放入: 放入背包的价值不增加，问题转化为 将前i -1种物品放入容量为 j 的背包中获得的最大价值，最大价值为 dp[i -1][j]。
         * 放入: 在第i 种物品放入之前为第i -1阶段，相当于从第i -1阶段 向第i 阶段转化。问题转化为“将前i -1种物品放入容量为j -w [i ]的背包 中获得的最大价值”，此时获得的最大价值就是 dp[i -1][j -w [i ]]，再加上放入第i 种物品获得的价值v [i ]，总价值为dp[i -1][j -w [i ]]+v[i]。
         * 若背包容量不足，则肯定不可以放入，所以价值仍为前i- 1种物品处理后的结果;若背包容量充足，则考察在放入、不放入哪种情况下获得的价值更大。
         * 则转移方程为：
         * dp[i][j] = dp[i - 1][j]                                                   j < w[i]
         * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i])             j >= w[i]
         *
         *
         * 以 m=10, w[]={2、5、4、2、3} v[]={6、3、5、4、6}
         *                0   1   2   3   4   5   6   7   8   9   10
         * 0   w    v     0   0   0   0   0   0   0   0   0   0   0
         * 1   2    6     0   0   6
         * 2   5    3     0
         * 3   4    5     0
         * 4   2    4     0
         * 5   3    6     0
         *
         *
         *
         */
        return new ArrayList<>();

    }
}
