package com.sxw.learn.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
/**
 * [题目]: 无重叠区间(435)
 * [题目描述]:
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * [解题思路]:
 * 贪心策略，按照右端点的值进行排序，也就是贪心的策略
 * 这个题其实是预定会议的一个问题，给你若干时间的会议，然后去预定会议，那么能够预定的最大的会议数量是多少？
 * 核心在于我们要找到最大不重叠区间的个数。
 * 如果我们把本题的区间看成是会议，那么按照右端点排序，我们一定能够找到一个最先结束的会议，而这个会议一定是我们需要添加到最终结果的的首个会议。
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));
        int matchCount = 1;// 当前匹配到的区间数量
        int right = intervals[0][1];// 当前到达的右边界
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                matchCount++;
            }
        }
        return n - matchCount;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 2;

        intervals[1][0] = 2;
        intervals[1][1] = 3;

        intervals[2][0] = 3;
        intervals[2][1] = 4;

        intervals[3][0] = 1;
        intervals[3][1] = 3;

        EraseOverlapIntervals solution = new EraseOverlapIntervals();
        int i = solution.eraseOverlapIntervals(intervals);
        System.out.println(i);
    }


}
