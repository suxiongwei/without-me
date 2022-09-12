package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]:链表的中间结点(876)
 * [题目描述]:
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * [解题思路]:快慢指针
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
