package com.sxw.learn.leetcode.linkedlist;

/**
 * 两个单链表相交的一系列问题
 *
 * [题目] 给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的第一个节点，如果不相交，返回null
 * [要求] 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)
 *
 * 一些结论：
 * 1、单链表不可能有环还能再绕出来，因为一个节点不可能存在两个next指针
 * 2、一个有环的链表不可能和一个无环的链表相交(参考结论1)
 * 3、查找第一个入环的节点(无需证明，可以记忆)
 *  - 1) 定义快慢指针，快指针每次走两步，慢指针每次走一步，因为快指针相对慢指针每此都快一步，因此肯定会相遇
 *  - 2) 相遇后，快指针回到头节点，慢指针在相遇的节点不动
 *  - 3) 此时两个指针每次往前移动一个节点，两个指针相遇的节点即为入环的节点
 *
 * [解题思路]
 * 1) 两个链表都无环都情况 -> noLoop方法
 * 2) 一个链表有环，一个链表无环，这种情况不可能存在相交的节点
 * 3) 两个链表都有环 -> bothLoop方法
 */
public class FindFirstIntersectNode {
    // 查找第一个入环的节点
    public static ListNode getLoopNode(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode n1 = head.next;// n1 -> slow
        ListNode n2 = head.next.next;// n2 -> first

        while (n1 != n2){
            if (n2 == null || n2.next == null) return null;// 快指针到达末尾，说明没环
            n2 = n2.next.next;
            n1 = n1.next;
        }

        n2 = head;// walk again from head
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    // 如果两个链表都无环，返回第一个相交节点，如果不相交，则返回null
    public static ListNode noLoop(ListNode head1, ListNode head2){
        if (head1 == null || head2 == null) return null;
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        int n = 0;
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) return null;// 两个无环链表相交，只有一种情况，就是相交后，共用剩下的节点，所以走到末尾的节点一定是同一个节点

        cur1 = n > 0 ? head1 : head2;// 谁长，谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2

        n = Math.abs(n);
        while (n > 0){
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2){// 简洁的写法，因为此时链表长度相同，没有相交的时候，cur1和cur2都会置为null
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 如果两个链表都有环，返回第一个相交节点，如果不相交，则返回null
    public static ListNode bothLoop(ListNode head1, ListNode hoop1, ListNode head2, ListNode hoop2){
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4);
        ListNode l1Node5 = new ListNode(5);
        head.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;
        l1Node4.next = l1Node5;
        l1Node5.next = l1Node3;

        ListNode listNode = getLoopNode(head);
        System.out.println("入环的第一个节点:" + listNode.val);

        ListNode head1 = new ListNode(1);
        ListNode l1Node2A = new ListNode(2);
        ListNode l1Node3A = new ListNode(3);
        ListNode l1Node4A = new ListNode(4);
        ListNode l1Node5A = new ListNode(5);
        head1.next = l1Node2A;
        l1Node2A.next = l1Node3A;
        l1Node3A.next = l1Node4A;
        l1Node4A.next = l1Node5A;

        ListNode head2 = new ListNode(7);
        ListNode l1Node2B = new ListNode(8);
        ListNode l1Node3B = new ListNode(9);
        ListNode l1Node4B = new ListNode(2);
        ListNode l1Node5B = new ListNode(1);

        head2.next = l1Node2B;
        l1Node2B.next = l1Node3B;
        l1Node3B.next = l1Node4B;
        l1Node4B.next = l1Node5B;
        l1Node5B.next = l1Node3A;// 定义 l1Node3A val = 3 为相交的节点

        // head1：1 -> 2 -> 3 -> 4 -> 5 head2：7 -> 8 -> 9 -> 2 -> 1 -> 3 -> 4 -> 5
        ListNode noLoop = noLoop(head1, head2);
        if (noLoop != null){
            System.out.println("无环链表相交的节点:" + noLoop.val);
        }else {
            System.out.println("无环链表相交的节点:null");
        }

    }
}
