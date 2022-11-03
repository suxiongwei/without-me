package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 排序奇升偶降链表
 * [题目描述]:
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * 例子：输入: 1->8->3->6->5->4->7->2->NULL
 * [解题思路]:
 * 拆分奇偶链表 + 翻转链表 + 合并链表
 * ps：利用dummy节点
 */
public class SortingAscendingDescendingList {
    public ListNode sortList(ListNode head) {
        // 首先拆分奇偶链表
        ListNode dumyOdd = new ListNode(-1);// 奇数
        ListNode odd = dumyOdd;

        ListNode dumyEven = new ListNode(-1);// 偶数
        ListNode even = dumyEven;

        ListNode curNode = head;
        int curIndex = 1;// 标识起始位置是奇数位
        while (curNode != null) {
            if ((curIndex & 1) == 1) {// 代表当前是奇数位
                odd.next = curNode;
                odd = odd.next;
            } else {
                even.next = curNode;
                even = even.next;
            }
            curNode = curNode.next;
            curIndex++;
        }
        odd.next = null;// 将尾节点置为null
        even.next = null;// 将尾节点置为null

        // 接着翻转偶数链表
        even = ReverseList.reverseList(dumyEven.next);
        odd = dumyOdd.next;

        // 最后合并奇偶链表
        return MergeTwoLists.mergeTwoLists(odd, even);
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(2);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        SortingAscendingDescendingList solution = new SortingAscendingDescendingList();
        ListNode node = solution.sortList(node0);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
