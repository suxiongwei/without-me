package com.sxw.learn.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 复制带随机指针的链表(138)
 * [题目描述]: 构造这个链表的 深拷贝
 * [解题思路]:
 * 递归 + 回溯 + 哈希表
 */
public class CopyRandomList {
    private Map<Node, Node> map = new HashMap<>();// 建立旧节点与新节点的映射关系

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (map.containsKey(head)) return map.get(head);
        Node newNode = new Node(head.val);
        map.put(head, newNode);// 即使没完全创建，也需要添加到map中，防止死循环
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
