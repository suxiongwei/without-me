package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 环形链表II(142)
 * [题目描述]:
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 *
 * 不允许修改链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * [解题思路]:
 * 定义以下变量：
 * a：head到入环的节点处长度
 * b：环的长度
 * s：慢节点走的路程
 * f：快节点走的路程
 *
 * 则快慢节点相遇时：
 * f = s + nb (相遇时，刚好多走了n圈)
 * f = 2s (快指针每次2步，路程刚好2倍)
 *
 * 可以推导出 s = nb
 *
 * 而从head到入环节点需要走 a + nb，而s已经走了nb(注意nb的距离中包含走的a的那一段，因此此时s走到了环的某一处)，再走a步就到了入环节点
 * 如何知道slow刚好走了a步？ 从head开始，和slow指针一起走，相遇时刚好就是a步
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (true){// 不能为while (fast != slow)，因为第一次循环的时候fast=slow=head
            if (fast == null || fast.next == null) return null;// 没有环直接就return了
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;// 证明有环，就可以利用上面公式的性质
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        DetectCycle solution = new DetectCycle();
        ListNode node = solution.detectCycle(node0);
        System.out.println(node == null ? null : node.val);
    }
}
