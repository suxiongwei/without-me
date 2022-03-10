package com.sxw.learn.leetcode.linkedlist;

public class ReverseListWithoutMe {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
