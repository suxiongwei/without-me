package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-18 7:20 下午
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
}
