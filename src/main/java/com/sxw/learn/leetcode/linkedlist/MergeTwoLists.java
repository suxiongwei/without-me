package com.sxw.learn.leetcode.linkedlist;

/**
 * 合并两个有序链表(21)
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode result = prehead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prehead.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                prehead.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prehead = prehead.next;
        }
        if (l1 != null){
            prehead.next = l1;
        }
        if (l2 != null){
            prehead.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        l2.next = node3;
        node3.next = node4;

        ListNode listNode = MergeTwoLists.mergeTwoLists(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
