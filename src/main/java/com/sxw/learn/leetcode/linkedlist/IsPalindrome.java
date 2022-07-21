package com.sxw.learn.leetcode.linkedlist;


/**
 * 判断链表是否为回文结构
 * 要求，时间复杂度为O(N),空间复杂度为O(1)
 *
 * 解法：可以借助栈来解决，但是需要额外空间
 * 本解法是通过反转后半部分链表来实现
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
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

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null){
            ListNode tmpNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNode;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
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

    public static void main(String[] args) {
        ListNode l1Node1 = new ListNode(2);
        ListNode l1Node2 = new ListNode(4);
        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4);
        ListNode l1Node5 = new ListNode(2);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;
        l1Node4.next = l1Node5;

        System.out.println(isPalindrome(l1Node1));
    }
}
