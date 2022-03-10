package com.sxw.learn.leetcode.linkedlist;


public class RemoveNthFromEndWithoutMe {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++){
            first = first.next;
        }
        while (first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthFromEndWithoutMe removeNthFromEnd = new RemoveNthFromEndWithoutMe();
        ListNode listNode = removeNthFromEnd.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }



































    public ListNode removeNthFromEndWithoutMe(ListNode head, int n) {
        return null;
    }

}

