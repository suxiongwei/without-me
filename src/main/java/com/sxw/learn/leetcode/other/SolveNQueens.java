package com.sxw.learn.leetcode.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * [题目]: N皇后(51)
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * [示例]：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * [提示]：1 <= n <= 9
 * [解法]:使用暴力递归(也就是所谓的回溯)
 * 暴力递归就是尝试
 * 1、把问题转换为规模规模缩小了的同类问题的子问题
 * 2、有明确的不需要继续进行递归的条件(base case)
 * 3、有当得到了子问题的结果之后的决策过程
 * 4、不记录每一个问题的解
 *
 */
@Slf4j
public class SolveNQueens {
    public static int solveNQueens(int n) {
        int[] record = new int[n];// record[i] -> i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    /**
     * 潜台词是 record[0....i-1]的皇后，任意两个皇后一定不共行，不共列，不共斜线
     * @param i 目前来到了第 i 行
     * @param record record[0....i-1]表示之前的行，放了皇后的位置
     * @param n 整体一共有多少行
     * @return 返回值为，摆完所有的皇后，合理的摆法有多少种
     */
    public static int process1(int i, int[] record, int n) {
        if (i == n) return 1;// 来到了终止行了，说明这是一种摆法，返回1
        int res = 0;// 如果所有j的槽都不能放皇后，则return的是默认值0，也就是代表着这种摆法不能往下继续了
        for (int j = 0; j < n; j++){// 当前行在第i行，尝试i行所有的列->j
            /**
             * 当前i行的皇后，放在j列，会不会和之前(0..i-1)的皇后，不共行、不共列、不共斜线
             * 如果是，认为当前j是有效的，可以当作是一个放皇后的位置
             * 如果不是，认为无效，继续往下一个j验证
             */
            if (isValid(record, i, j)){
                record[i] = j;
                res += process1(i + 1, record, n);// 两层循环，实际上是走了一个暴力递归
            }
        }
        return res;
    }

    /**
     *
     * @param record record[0..i-1]需要看，record[i...]不需要看
     * @param i 第i行
     * @param j 第j列
     * @return 返回i行皇后放在j列，是否有效
     */
    public static boolean isValid(int[] record, int i, int j){
        for (int k = 0; k < i; k++){
            /**
             * record[k] == j 判断的是在同一列
             * Math.abs(record[k] - j) == Math.abs(i - k) 判断的是对角线，就是拿坐标的绝对值来比较
             * 00 01 02 03 04
             * 10 11 12 13 14
             * 20 21 22 23 24
             * 30 31 32 33 34
             * 40 41 42 43 44
             * 可以观察出 对角线的值的坐标，行-行的绝对值 = 列-列的绝对值
             */
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }

    // ---------------------------分割线，以下是利用位运算的优化版本-----------------------------
    public static int solveNQueens1(int n) {
        if (n < 1 || n > 32) return 0;// 不处理32以上的皇后问题
        int limit = n == 32 ? -1 : (1 << n) - 1;// -1的二进制数：11111111111111111111111111111111; (1 << 8) - 1):11111111
        return process2(limit, 0, 0, 0);
    }

    /**
     * 使用二进制位优化后的版本
     * @param limit
     * @param colLim 列的限制，1的位置不能放皇后，0的位置可以
     * @param leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
     * @param rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
     * @return
     */
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if (colLim == limit) return 1;// 当前列上都是1，放满了，是一种摆法，直接return
        int pos = 0;
        int mostRightOne = 0;
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));// 所有候选皇后的位置都在pos上，与一下 是为了把高位的1截掉
        int res = 0;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1);// 把一个二进制数最右侧的1提取出来
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch("统计N皇后耗时");
        sw.start("常规解法");
        int n = 15;
        int i = SolveNQueens.solveNQueens(n);
        System.out.println(n + "皇后的摆法有" + i + "种");
        log.info("[{}]皇后的摆法有[{}]种", n, i);
        sw.stop();
        /**
         * 15皇后的摆法有2279184种
         * 35.527624862
         *
         * 可以观察出 在算15皇后时已经很慢了，可以使用位运算进行优化
         */
//        System.out.println(Integer.toBinaryString((1 << 8) - 1));
        sw.start("使用位运算优化后的解法");
        i = SolveNQueens.solveNQueens1(n);
        sw.stop();
        log.info("[{}]皇后的摆法有[{}]种", n, i);
        Arrays.stream(sw.getTaskInfo()).forEach(e -> log.info("taskName:[{}], second:[{}]", e.getTaskName(), e.getTimeSeconds()));
    }
}
