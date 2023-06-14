package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 删除排序链表中的重复元素II(82)
 * [题目描述]:
 * 给定一个已排序的链表的头 head， 删除原始链表中所有重复数字的节点，只留下不同的数。返回已排序的链表。
 * [解题思路]:
 */
public class DeleteDuplicates {
    // 删除重复元素II [1,2,3,3,4,4,5] -> [1,2,5]
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-101, head);// 定义哑节点，这是因为首个节点有可能重复，从而会从链表中删除
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;// 只要当前节点重复了，就直接跳过，这里只是修改了cur的next，cur的位置并没有变化
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // 删除重复元素 [1,2,3,3,4,4,5] -> [1,2,3,4,5]
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
