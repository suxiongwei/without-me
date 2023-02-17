package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 反转链表(206)
 * [题目描述]: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * [解题思路]:
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null
        ){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
