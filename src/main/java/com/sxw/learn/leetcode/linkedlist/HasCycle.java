package com.sxw.learn.leetcode.linkedlist;


/**
 * 环形链表(141)
 * 题目描述：给定一个链表，判断链表中是否有环。为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 解题方法：通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
 * 相对速度只差 1，快的只能一个一个格子的去追慢的，必然在一个格子相遇。
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head.next;
        ListNode slow = head;
        while (first != slow){
            if (first == null || first.next == null) return false;
            first = first.next.next;
            slow = slow.next;
        }
        return true;
    }


    // 2023.04.18 解法
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }
}
