package com.sxw.learn.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [题目]: 合并K个升序链表(23)
 * [题目描述]:
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * [解题思路]:
 * 方法一：顺序合并
 * 方法二：分治合并
 * 方法三：使用优先队列合并 本题解
 * 渐进时间复杂度为 O(kn×logk)
 * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 k 个，故渐进空间复杂度为 O(k)。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) pq.offer(listNode);
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            tail.next = cur;
            tail = cur;
            if (cur.next != null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
