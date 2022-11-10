package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 奇偶链表(328)
 * [题目描述]:
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 * [解题思路]:
 * 与题目：排序奇升偶降链表，解决思路一致
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);// 奇数节点的链表
        ListNode odd = dummyOdd;

        ListNode dummyEven = new ListNode(-1);// 偶数节点的链表
        ListNode even = dummyEven;

        int curIndex = 1;// 标识起始位置是奇数位
        ListNode curNode = head;
        while (curNode != null){
            if ((curIndex & 1) == 1){// 奇数
                odd.next = curNode;
                odd = odd.next;
            }else {
                even.next = curNode;
                even = even.next;
            }
            curNode = curNode.next;
            curIndex++;
        }
        even.next = null;// 需要将偶数节点的next设置为null，将链表断开，否则可能会成环
        // 将奇数链表与偶数链表连接，注意需要去掉dummy节点
        odd.next = dummyEven.next;
        return dummyOdd.next;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        OddEvenList solution = new OddEvenList();
        ListNode node = solution.oddEvenList(node0);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
