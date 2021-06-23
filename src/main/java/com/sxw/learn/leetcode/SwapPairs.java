package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-01 4:04 下午
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
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
