package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-02 4:46 下午
 */
public class DoubleLinkedList {
    private static class Node{
        Object value;
        Node prev = this;
        Node next = this;

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head = new Node(null);

    private int size;

    public boolean addFirst(Object o) {
        addAfter(new Node(o), head);
        return true;
    }

    public boolean addLast(Object o) {
        addBefore(new Node(o), head);
        return true;
    }

    public boolean add(Object o) {
        return addLast(o);
    }

    public boolean add(int index, Object o) {
        addBefore(new Node(o), getNode(index));
        return true;
    }

    public boolean remove(int index) {
        removeNode(getNode(index));
        return true;
    }

    public boolean removeFirst() {
        removeNode(head.next);
        return true;
    }

    public boolean removeLast() {
        removeNode(head.prev);
        return true;
    }

    public Object get(int index) {
        return getNode(index).value;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node node = head.next;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public void addBefore(Node newNode, Node node){
        // 修改了当前节点
        newNode.next = node;
        newNode.prev = node.prev;
        // 修改前后节点的连接属性
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    public void addAfter(Node newNode, Node node){
        newNode.prev = node;
        newNode.next = node.next;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    public String toString()
    {
        StringBuffer s = new StringBuffer("[");
        Node node = head;
        for (int i = 0; i < size; i++)
        {
            node = node.next;
            if (i > 0)
                s.append(", ");
            s.append(node.value);
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        //添加
        dll.add("张曼玉");
        dll.add("钟楚红");
        dll.add("刘嘉玲");
        System.out.println(dll);

        //添加到最前
        dll.addFirst("林青霞");
        System.out.println(dll);

        //添加到最后，同添加
        dll.addLast("梅艳芳");
        System.out.println(dll);
    }
}
