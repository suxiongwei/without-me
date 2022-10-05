package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: K个一组翻转链表(25)
 * [题目描述]:
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * [解题思路]:
 * 将整个链表划分为：已翻转部分+待翻转部分+未翻转部分
 * 难点在于将三部分的连接
 * 定义变量：
 * pre：待翻转链表的前驱
 * end：待翻转链表的末尾
 * 间接得出：
 * start: pre.next 翻转部分的头指针
 * next：end.next 待翻转部分的头指针
 *
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;// 待翻转链表的前驱
        ListNode end = dummy;// 待翻转链表的末尾
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {// end == null 会直接终止循环 -> 只要end为null就会终止循环
                end = end.next;
            }
            if (end == null) {// end为翻转部分的末指针
                break; // 已经不够k个的翻转了，直接return
            }
            ListNode next = end.next;// 保存待翻转部分的头指针
            ListNode start = pre.next;// 翻转部分的头指针
            end.next = null;// 将end的next指针置为null，进行截断，为下一步的翻转做准备
            pre.next = reverse(start);// 返回的是end节点，与翻转部分的末尾部分连接
            start.next = next;// 翻转后start就成了翻转部分的end节点，与待翻转部分的头节点连接
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 翻转完之后只会包含翻转的片段，也就是完全与整个链表截断了，只包含这个部分
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
