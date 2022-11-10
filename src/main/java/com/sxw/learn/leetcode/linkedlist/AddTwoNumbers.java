package com.sxw.learn.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers {
    /**
     * [题目]: 两数相加(2)
     * [题目描述]:
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
     * [解题思路]:
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode head = null, tail = null;
        int num1 = 0, num2 = 0, carry = 0, sum = 0;
        while (l1 != null || l2 != null) {
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            if (head == null) {// 证明还没循环
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * [题目]: 两数相加II(445)
     * [题目描述]:
     * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * [解题思路]:
     * 和两数相加(2)的区别在于输入的链表不是按照逆序的，因此借助栈将链表顺序翻转之后，解法一致
     */
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        Deque<ListNode> deque1 = new ArrayDeque();
        Deque<ListNode> deque2 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.offerFirst(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.offerFirst(l2);
            l2 = l2.next;
        }
        ListNode head = null;// 由于需要从个位数依次往上计算，因此head节点需要不断更新
        ListNode cur = null;
        int num1 = 0, num2 = 0, carry = 0, sum = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            num1 = deque1.peekFirst() == null ? 0 : deque1.pollFirst().val;
            num2 = deque2.peekFirst() == null ? 0 : deque2.pollFirst().val;
            sum = num1 + num2 + carry;
            if (head == null) {// 证明还没循环
                head = new ListNode(sum % 10);
                cur = head;// 由于最终需要返回cur，因此cur在这也需要更新，比如 个位数 + 个位数
            } else {
                cur = new ListNode(sum % 10);
                cur.next = head;
                head = cur;
            }
            carry = sum / 10;
        }
        if (carry != 0) {
            cur = new ListNode(carry);
            cur.next = head;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Node1 = new ListNode(4);
        ListNode l1Node2 = new ListNode(3);
        l1.next = l1Node1;
        l1Node1.next = l1Node2;

        ListNode l2 = new ListNode(5);
        ListNode l2Node1 = new ListNode(6);
        ListNode l2Node2 = new ListNode(4);
        l2.next = l2Node1;
        l2Node1.next = l2Node2;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        // 243 + 564 = 807
        ListNode node = addTwoNumbers.addTwoNumbersII(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
