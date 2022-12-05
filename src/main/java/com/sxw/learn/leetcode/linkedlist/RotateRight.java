package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 旋转链表(61)
 * [题目描述]:
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * [解题思路]:
 * 双指针
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        // 末尾节点，因为旋转后末尾节点需要连上原始的头节点
        ListNode tail = null;
        // 定义哑节点，为了计算链表长度
        ListNode dummy = head;
        // 定义链表长度，目的是为了与k取模，解决 k >= length的case
        int length = 0;
        while (dummy != null) {
            length++;
            ListNode next = dummy.next;
            if (next == null) {
                tail = dummy;
            }
            dummy = next;
        }
        k = k % length;
        // base case
        if (length == 1 || k == 0 || length == k) return head;
        // 快指针先走k + 1步，生成窗口
        // 比如：1,2,3,4,5  k=2 -> fast = 3，之所以走k+1步，是为了让slow到达正确的位置，因为最终fast需要走到null才退出循环
        while (k >= 0) {
            fast = fast.next;
            k--;
        }
        // slow 指向的是旋转的前一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        // 将需要旋转的部分从原始链表断开
        slow.next = null;
        tail.next = head;
        return newHead;
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
