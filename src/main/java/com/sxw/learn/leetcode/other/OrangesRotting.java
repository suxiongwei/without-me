package com.sxw.learn.leetcode.other;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * [题目]: 腐烂的橘子(994)
 * [题目描述]:
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 * [解题思路]: 广度优先搜索
 */
public class OrangesRotting {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length;// 行数
        int C = grid[0].length;// 列数
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;// 累加形式的位置
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C;// 当前节点所在行
            int c = code % C;// 当前节点所在列
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];// dr: new int[]{-1, 0, 1, 0}; 当前行，随着k增加，位置分别为：下 左 上 右
                int nc = c + dc[k];// dc: new int[]{0, -1, 0, 1}  当前列
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) return -1;// 如果感染完之后还存在新鲜的🍊，返回-1
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {2, 1, 1},
//                {2, 1, 0},
//                {0, 1, 1}
//        };
//        OrangesRotting solution = new OrangesRotting();
//        int rotting = solution.orangesRotting(grid);
//        System.out.println(rotting);

        for (int m = 3; m <= 12; m++) {
            int x = 4400;
            int pay = ((x / 3) * m + (x / 2) * (12 - m)) / 12;
//        System.out.println("平均月租金："+ pay);
//        System.out.println("平均月租金："+ (pay + (x * 0.8) / 12 / 3));
            System.out.println(m + "个月平均月租金：" + (pay + (x * 0.1 * 0.85) / 3));
        }


    }
}
