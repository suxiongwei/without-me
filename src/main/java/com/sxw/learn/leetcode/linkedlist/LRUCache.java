package com.sxw.learn.leetcode.linkedlist;

import java.util.HashMap;

/**
 * [题目]: LRU缓存(146)
 * [题目描述]:
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * [解题思路]:
 * Map + 自定义的双向链表
 */
public class LRUCache {
    private HashMap<Integer, DLinkedNode> cache;
    private DLinkedNode head;// 定义虚拟头节点
    private DLinkedNode tail;// 定义虚拟尾节点
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode res = cache.get(key);
        if (res == null) {
            return -1;
        } else {
            removeNode(res);
            addToHead(res);
            return res.value;
        }
    }


    public void put(int key, int value) {
        DLinkedNode res = cache.get(key);
        if (res == null) {// 不存在，执行添加，添加的过程中检查是否已经超出容量
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tailPrevNode = tail.prev;
                removeNode(tailPrevNode);
                cache.remove(tailPrevNode.key);
                size--;
            }
        } else {
            res.value = value;// 只是key存在，value需要覆盖成新的value
            removeNode(res);
            addToHead(res);
        }
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;// 修改next指针
        node.next.prev = node.prev;// 修改prev指针
    }


    private void addToHead(DLinkedNode node) {
        // 在连接的时候要考虑当前节点、前面节点、后面节点的连接关系(双向连接)
//        node.prev = head;// 先设置node，不改变head的指针情况
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;

        // 存储头节点的下一个节点，因为后续会调整head的next指针，因此先存储下来，防止替换
        DLinkedNode tmpNode = head.next;
        // 连接head 与 node节点
        head.next = node;
        node.prev = head;

        // 连接node节点与旧的队列头部实际节点
        node.next = tmpNode;
        tmpNode.prev = node;
    }

    class DLinkedNode {
        private int key;
        private int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
