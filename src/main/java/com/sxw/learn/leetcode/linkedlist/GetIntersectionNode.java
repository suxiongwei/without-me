package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 相交链表(160)
 * [题目描述]:
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * [解题思路]:
 * 我吹过你吹过的晚风
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
