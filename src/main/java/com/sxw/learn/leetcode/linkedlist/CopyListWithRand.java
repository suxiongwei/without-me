package com.sxw.learn.leetcode.linkedlist;

/**
 * [问题]：复制含有随机指针节点的链表
 * 节点的数据结构参见代码 Node
 * [问题描述]：rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可以指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点
 * [要求]：时间复杂度O(N)，额外空间复杂度O(1)
 *
 * [解法]
 * 解法一：利用map结构 key存node，value存克隆出来的节点
 * 空间复杂度不满足题目的要求
 *
 * 解法二：在每一个节点的后面复制一个节点
 */
public class CopyListWithRand {
    static class Node{
        int val;
        Node next;
        Node rand;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node copyListWithRand(Node head){
        if (head == null) return head;
        Node cur = head;
        Node next = null;
        while (cur != null){// 为每个节点构建一个影子节点并连接到当前节点后面 1 -> 1' -> 2 -> 2'
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null){// 设置复制节点的rand值
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        while (cur != null){// 拼接新的链表，并且恢复原有链表的值
            next = cur.next.next;
            curCopy = cur.next;// 最初循环赋值的就是res节点的值，然后一直往后next 就拼接出新的链表
            cur.next = next;
            curCopy.next = next != null ? next.next : null;

            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node l1Node2 = new Node(2);
        Node l1Node3 = new Node(3);
        Node l1Node4 = new Node(4);
        Node l1Node5 = new Node(5);
        head.next = l1Node2;
        head.rand = l1Node3;

        l1Node2.next = l1Node3;

        l1Node3.next = l1Node4;
        l1Node3.rand = l1Node4;

        l1Node4.next = l1Node5;

        Node copyNode = copyListWithRand(head);
        while (copyNode != null){
            System.out.println("----------------begin------------------");
            System.out.println("val:" + copyNode.val);
            if (copyNode.rand != null){
                System.out.println("rand:" + copyNode.rand.val);
            }
            System.out.println("----------------end------------------");
            copyNode = copyNode.next;
        }
    }


}
