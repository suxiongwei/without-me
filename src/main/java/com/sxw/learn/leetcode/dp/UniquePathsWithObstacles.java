package com.sxw.learn.leetcode.dp;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description 有障碍的路径
 * @Date 2021-03-03 5:44 下午
 */
public class UniquePathsWithObstacles {
    private static int solution(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] != 1){
            dp[0][0] = 1;
        }

        // 填充第一行的值 需要根据前一个的值来确定当前值
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
        }

        // 填充第一列的值 需要根据前一个的值来确定当前值
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    private static int solution1(int[][] obstacleGrid){
        // 行
        int m = obstacleGrid.length;
        // 列
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] array = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(UniquePathsWithObstacles.solution1(array));
    }
}
