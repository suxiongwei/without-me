package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-11 5:27 下午
 */
public class DeleteDuplicates {
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode cur = head;
    //     while (cur.next != null){
    //         if (cur.val == cur.next.val){
    //             cur.next = cur.next.next;
    //             continue;
    //         }
    //         cur = cur.next;
    //     }
    //     return head;
    // }

    /**
     * 82. 删除排序链表中的重复元素 II
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;// cur next节点已经更新，再一直比较next.val == x
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates(head);
    }
}
