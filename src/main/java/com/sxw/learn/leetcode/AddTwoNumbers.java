package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-20 11:43 上午
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode head = null,tail = null;
        int num1 = 0, num2 = 0, carry = 0, sum = 0;
        while (l1 != null || l2 != null){
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            if (head == null){// 证明还没循环
                head = tail = new ListNode(sum % 10);
            }else {
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
        if (carry != 0) tail.next = new ListNode(carry);
        return head;
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
        ListNode node = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(node);
    }
}
