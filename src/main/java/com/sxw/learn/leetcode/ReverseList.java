package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-15 5:12 下午
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

