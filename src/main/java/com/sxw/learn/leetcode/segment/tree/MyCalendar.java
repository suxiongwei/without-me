package com.sxw.learn.leetcode.segment.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;




/**
 * [题目]: 我的日程安排表I(729)
 * [题目描述]:
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 *
 * 实现 MyCalendar 类：
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 * [解题思路]:
 * 线段树
 */
@Slf4j
public class MyCalendar {
    // 存储元素idx的含义：[0,1e9)编号idx=1，[0,mid)编号idx=2, [mid,1e9)编号idx=3，以此类推
    //  tree 记录区间 [l,r] 的是否存在标记为 1 的元素。
    Set<Integer> tree;
    //  标记区间 [l,r] 已经被预订，
    Set<Integer> lazy;
    // 线段数中能存储的最大范围
    int R = 1000000000;
//    int R = 50;

    public MyCalendar() {
        tree = new HashSet<>();
        lazy = new HashSet<>();
    }

    public boolean book(int start, int end) {
        boolean query = query(start, end - 1, 0, R, 1);
        if (query) {
            return false;
        }
        update(start, end - 1, 0, R, 1);
        return true;
    }

    public boolean query(int start, int end, int l, int r, int idx) {
        if (start > r || end < l) {
            return false;
        }
        // 如果该区间已被预订，则直接返回
        if (lazy.contains(idx)) {
            return true;
        }
        if (start <= l && r <= end) {
            return tree.contains(idx);
        } else {
            int mid = (l + r) >> 1;
            if (end <= mid) {
                return query(start, end, l, mid, 2 * idx);
            } else if (start > mid) {
                return query(start, end, mid + 1, r, 2 * idx + 1);
            } else {
                return query(start, end, l, mid, 2 * idx) | query(start, end, mid + 1, r, 2 * idx + 1);
            }
        }
    }

    public void update(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        if (start <= l && r <= end) {
            tree.add(idx);
            lazy.add(idx);
        } else {
            int mid = (l + r) >> 1;
            update(start, end, l, mid, 2 * idx);
            update(start, end, mid + 1, r, 2 * idx + 1);
            log.info("start:[{}],end:[{}],l:[{}],r:[{}],idx:[{}]", start, end, l, r, idx);
            tree.add(idx);
        }
    }

    public static void main(String[] args) {
        MyCalendar solution = new MyCalendar();
        // [10, 20], [15, 25], [20, 30]
        boolean b1 = solution.book(10, 20);
        System.out.println(b1);
        /**
         * start:[10],end:[19],l:[7],r:[12],idx:[9]
         * start:[10],end:[19],l:[0],r:[12],idx:[4]
         * start:[10],end:[19],l:[13],r:[25],idx:[5]
         * start:[10],end:[19],l:[0],r:[25],idx:[2]
         * start:[10],end:[19],l:[0],r:[50],idx:[1]
         */
        boolean b2 = solution.book(15, 25);
        System.out.println(b2);

        boolean b3 = solution.book(20, 30);
        System.out.println(b3);
    }
}
