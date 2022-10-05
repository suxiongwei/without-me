package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 重排链表(143)
 * [题目描述]:
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * [解题思路]:
 * 寻找链表中点 + 链表逆序 + 合并链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode middleNode = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        l2 = reverse(l2);
        mergeTwoLists(l1, l2);
    }

    public ListNode middleNode(ListNode node) {
        ListNode first = node;// 就是需要逆序的后半段，比如1、2、3、4 -> first=3 / 1、2、3、4、5 -> first=3,
        ListNode slow = node;
        while (first.next != null && first.next.next != null) {
            slow = slow.next;
            first = first.next.next;
        }
        return slow;
    }

    private void mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
