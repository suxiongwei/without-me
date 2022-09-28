package com.sxw.learn.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * [题目]: 合并区间(56)
 * [题目描述]:
 *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * [解题思路]:
 *  先将数组按照左边界元素排序，然后merge
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int N = intervals.length;
        int curIndex = 1;
        merged.add(intervals[0]);
        while (curIndex < N) {
            int[] preMergeArr = merged.get(merged.size() - 1);// 前一个merge的节点
            if (intervals[curIndex][0] <= preMergeArr[1]) {// 当前元素的左边界小于前一个元素的右边界
                int[] tmpArr = new int[]{preMergeArr[0], Math.max(intervals[curIndex][1], preMergeArr[1])};// 取两个需要merge的最大结束区间，如{1, 4}, {2, 3}
                merged.remove(merged.size() - 1);
                merged.add(tmpArr);
            } else {
                merged.add(intervals[curIndex]);
            }
            curIndex++;
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {2, 3}};

        Merge solution = new Merge();
        int[][] merge = solution.merge(intervals);
        Arrays.stream(merge).forEach(i -> System.out.println(Arrays.toString(i)));
    }
}
