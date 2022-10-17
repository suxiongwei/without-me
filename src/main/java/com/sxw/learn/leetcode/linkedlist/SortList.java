package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 排序链表(148)
 * [题目描述]:
 * 给你链表的头结点 head ，请将其按 升序 排列并返回排序后的链表 。
 *
 * 进阶：你可以在 O(NLogN) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * [解题思路]:
 * 题目的进阶问题要求达到 O(nlogn) 的时间复杂度和 O(1) 的空间复杂度，时间复杂度是 O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)
 * 其中最适合链表的排序算法是归并排序。
 *
 * 自顶向下归并排序，由于会使用到栈空间，空间复杂度为：O(logn)，不符合题目要求的O(1)
 * 因此使用 自底向上归并排序，也就是本解法
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);// 定义哑节点
        int length = getListNodeLength(head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {// 分段去拆分，注意初始是1
            ListNode prev = dummy;// 每个小段(subLength)的拆分合并都从队列头部开始
            ListNode curr = prev.next;// 只移动curr节点
            while (curr != null) {
                ListNode head1 = curr;// 拆分出第一段
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;// 和后面的链表断开连接
                curr = head2;// 拆分出第一段
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;   // next用于记录 拆分完两个链表的结束位置
                    curr.next = null;   // 断开连接
                }
                ListNode merged = mergeTwoList(head1, head2);
                prev.next = merged;
                while (prev.next != null) {// 由于是单向链表，无法通过curr找到prev，又因为合并后的链表与整个链表是断开的，因此直接遍历到末尾就是prev
                    prev = prev.next;
                }
                curr = next;// curr移动到下一段到开始位置
            }
        }
        return dummy.next;
    }

    // 求链表的长度
    private int getListNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    // 按顺序合并两个链表
    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 == null) cur.next = node2;
        if (node2 == null) cur.next = node1;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4, node0);
        ListNode node3 = new ListNode(3, node4);
        ListNode node5 = new ListNode(5, node3);
        ListNode node1s = new ListNode(-1, node5);

        SortList solution = new SortList();
        ListNode listNode = solution.sortList(node1s);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
