package com.sxw.learn.leetcode.linkedlist;

/**
 * 删除链表倒数第N个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑节点,使用哑节点的原因是快指针需要快走一步，比如head = [1,2,3,4,5], n = 2
        // 不定义哑节点的话，在fast先走n步，然后fast,slow一起走，当fast走的结束的时候,slow=4,而slow需要=3才能做链表的连接
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;// 快指针
        ListNode second = dummy;// 慢指针
        for (int i = 0; i < n; i++) {// 相当于快慢指针的间隔（窗口）为n
            first = first.next;
        }
        while (first != null){// 当这个窗口滑到最末尾时 慢指针就是代表的倒数第N个节点
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode = removeNthFromEnd.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
}

