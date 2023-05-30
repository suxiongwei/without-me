package com.sxw.learn.leetcode.bfs;

import java.util.*;

/**
 * [题目]: 腐烂的橘子(994)
 * [题目描述]:
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 * [解题思路]: 广度优先搜索
 */
public class OrangesRotting {
    // dr，dc组合起来代表移动的方向为上、下、左、右
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length;// 行数
        int C = grid[0].length;// 列数
        Deque<Integer> queue = new ArrayDeque<>();// 定义队列 用于BFS
        Map<Integer, Integer> depth = new HashMap<>();// 存储当前元素是第几分钟被腐烂的
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {// 值2代表腐烂的橘子
                    int code = r * C + c;// 累加形式的位置
                    queue.offerLast(code);// BFS的形式，将腐烂的🍊作为搜索的起点
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.pollFirst();
            int r = code / C;// 当前节点所在行
            int c = code % C;// 当前节点所在列
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];// dr: new int[]{-1, 0, 1, 0}; 当前行，随着k增加，位置分别为：下 左 上 右
                int nc = c + dc[k];// dc: new int[]{0, -1, 0, 1}  当前列
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.offerLast(ncode);
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
    }
}
