package com.sxw.learn.leetcode.linkedlist;

import com.sxw.learn.leetcode.linkedlist.ListNode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-31 5:10 下午
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);// 找到前半部分的尾节点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);// 反转后半部分链表

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null){
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);// 还原链表并返回结果
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null){
            ListNode tmpNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNode;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode first = head, slow = head;
        while (first.next != null && first.next.next != null){
            first = first.next.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int revertedNumber = 0;
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
