package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 两两交换链表中的节点(24)
 * [题目描述]:
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *  [解题思路]:
 *  递归
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;// 1 -> 2 -> 3 -> 4  在此处newHead为2
        head.next = swapPairs(newHead.next);// 1 -> 2 -> 3 -> 4  在此处head为1，1的next为下一个翻转
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SwapPairs swapPairs = new SwapPairs();
        ListNode node = swapPairs.swapPairs(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


}
