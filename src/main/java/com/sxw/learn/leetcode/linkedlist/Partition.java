package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 分隔链表(86)
 * [题目描述]:
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * [解题思路]:
 * 模拟
 * 分别模拟出小于区的链表和大于等于区的链表，然后将二者连接
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        // 小于区的头节点
        ListNode smallHead = null;
        // 小于区的尾节点 tips：链表连接这种操作，头节点和尾节点都需要记录
        ListNode smallTail = null;
        // 大于等于区的头尾节点
        ListNode largeHead = null;
        ListNode largeTail = null;
        while (head != null) {
            if (head.val < x) {
                // 初始化头节点
                if (smallHead == null) {
                    // 头节点的值至此就不再修改了，用尾节点去连接新的元素
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = head;
                    largeTail = head;
                } else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
            }
            ListNode next = head.next;
            // 将当前元素从链表中拆分出来
            head.next = null;
            head = next;
        }
        // 如果没有小于区，直接返回大于区
        if (smallTail == null) {
            return largeHead;
        } else {
            smallTail.next = largeHead;
            return smallHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Partition solution = new Partition();
        solution.partition(node1, 3);
    }
}
