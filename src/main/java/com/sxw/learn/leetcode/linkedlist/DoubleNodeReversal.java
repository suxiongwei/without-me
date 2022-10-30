package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目]: 双向链表反转
 * [题目描述]:
 * [解题思路]:
 */
public class DoubleNodeReversal {
    // 把自己的前驱变后继，把后继变前驱
    private static DoubleNode reversalList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class DoubleNode{
        public int value;
        //前驱
        public DoubleNode pre;
        //后继
        public DoubleNode next;
        public DoubleNode(int value) {
            this.value = value;
        }
    }

    //遍历打印节点信息
    private static void print(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value);           //优化打印日格式
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        //构建一个双向链表1 2 3 4
        DoubleNode mid1 = new DoubleNode(2);
        DoubleNode mid2 = new DoubleNode(3);
        DoubleNode tail = new DoubleNode(4);
        head.next = mid1;
        mid1.next = mid2;
        mid2.next = tail;

        System.out.println("反转前");
        print(head);
        head = reversalList(head);
        System.out.println("反转后");
        print(head);
    }
}
