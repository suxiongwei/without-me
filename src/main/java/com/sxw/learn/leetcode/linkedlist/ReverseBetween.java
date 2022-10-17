package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 反转链表II(92)
 * [题目描述]:
 * 给你单链表的头指针 head 和两个整数left 和 right，其中left <= right。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表。
 *
 * [解题思路]:
 * 一次遍历 + 头插法
 * 使用三个指针变量 pre、curr、next 来记录反转的过程中需要的变量，它们的意义如下：
 *
 * curr：指向待反转区域的第一个节点 left；
 * next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化；
 * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        /**
         * dummy -> 1 -> 2 -> 3 -> 4 -> 5
         * left = 2 right = 4
         * 第一轮：
         * pre = 1
         * curr = 2
         * next = 3
         * dummy -> 1 -> 3 -> 2 -> 4 -> 5
         */
        ListNode dummy = new ListNode(0, head);
        // 找到prev
        ListNode pre = dummy;
        for (int i = 1; i < left; i++){
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for (int i = left; i < right; i++){
            next = curr.next;// 需要插入到头部的节点
            curr.next = next.next;// 先把当前节点和未遍历到的节点连接上
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2= new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ReverseBetween solution = new ReverseBetween();
        solution.reverseBetween(node1, 2, 4);
    }
}
