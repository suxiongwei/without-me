package com.sxw.learn.leetcode;

import com.sxw.learn.leetcode.linkedlist.ListNode;

public class Test {
    /**
     * a:到环
     * b:环的长度
     * s:相遇时慢指针走的路径
     * f:相遇时快指针走的路径
     * 在环中相遇时：
     * f = 2s
     * f - s = nb -> f = nb + s -> s = nb
     *
     * 而 s 在入环的节点需要走 a + nb，因此s再走a步就能到，此时快指针到头部，一起移动走a步就能找到入环的节点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode slow = head;

        while (true){
            if (first.next == null || first.next.next == null) return null;
            first = first.next.next;
            slow = slow.next;
            if (first == slow) break;
        }

        first = head;
        while (first != slow){
            first = first.next;
            slow = slow.next;
        }
        return first;

    }
}
