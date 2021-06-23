package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode iter = head;
        int n = 0;
        while (iter.next != null){
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) return head;
        iter.next = head;
        while (add-- > 0) iter = iter.next;
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        RotateRight rotateRight = new RotateRight();
        rotateRight.rotateRight(head, 2);
    }
}
