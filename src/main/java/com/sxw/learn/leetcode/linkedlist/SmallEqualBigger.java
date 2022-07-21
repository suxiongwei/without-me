package com.sxw.learn.leetcode.linkedlist;

/**
 * [题目概览]：将单向链表按某值划分为左边小，中间相等，右边大的形式
 * [具体描述]：给定一个单链表的头节点head，节点的值类型是整型，再给定一个数pivot。实现一个调整链表的函数
 * 将链表调整为左部分值都是小于pivot的节点，中间部分都是等于pivot的节点，右部分都是大于pivot的节点
 *
 * [进阶]在实现原问题的基础之上增加如下的要求
 * - 调整后所有小于pivot的节点之间的相对次序和调整之前一致
 * - 调整后所有等于pivot的节点之间的相对次序和调整之前一致
 * - 调整后所有大于pivot的节点之间的相对次序和调整之前一致
 * - 时间复杂度请达到O(N),额外空间复杂度请达到O(1)
 *
 * [解法]
 * 解法一：与数组中的一道题(DutchFlag)相似，可以先将链表转换为数组，数组排好序之后，再恢复为链表结构
 * 解法二：本题解
 */
public class SmallEqualBigger {
    public static ListNode listPartition(ListNode head, int pivot){
        ListNode sH = null;// 小于区域的头节点
        ListNode sT = null;// 小于区域的尾节点
        ListNode eH = null;// 等于区的头节点
        ListNode eT = null;// 等于区的尾节点
        ListNode mH = null;// 大于区的头节点
        ListNode mT = null;// 大于区的尾节点
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.val < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.val > pivot){
                if (mH == null){
                    mH = head;
                    mT = head;
                }else {
                    mT.next = head;
                    mT = head;
                }
            }else {
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }
            head = next;
        }
        // 上面while执行完之后，sH、eH、mH都可能存在为null的情况
        if (sT != null){// 存在小于区
            sT.next = eH;// 不管等于区是否存在，先连上再说
            eT = eT == null ? sT : eT;// 下一步谁去连大于区域的头
        }
        if (eT != null){
            eT.next = mH;// 不管大于区是否存在，先连上再说
        }
        return sH != null ? sH : eH != null ? eH : mH;// 至此，链表已经重新连接，判断返回哪个区域的头节点
    }

    public static void main(String[] args) {
        ListNode l1Node1 = new ListNode(2);
        ListNode l1Node2 = new ListNode(4);
        ListNode l1Node3 = new ListNode(7);
        ListNode l1Node4 = new ListNode(1);
        ListNode l1Node5 = new ListNode(3);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;
        l1Node4.next = l1Node5;

        ListNode listNode = listPartition(l1Node1, 3);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
