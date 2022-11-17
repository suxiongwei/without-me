package com.sxw.learn.leetcode.segment.tree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCalendar {

    public MyCalendar() {}

    public boolean book(int start, int end) {
        // 先查询该区间是否为 0
        log.info("book-start:{}, end:{}", start, end);
        int query = query(root, 0, N, start, end - 1);
        if (query != 0) {
            return false;
        }
        // 更新该区间
        update(root, 0, N, start, end - 1, 1);
        return true;
    }

    // *************** 下面是模版 ***************
    class Node {
        // 左右孩子节点
        Node left, right;
        // 当前节点值，以及懒惰标记的值
        int val, add;
    }

//    private int N = (int) 1e9;
    private int N = 50;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return ;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        pushUp(node);
    }

    public int query(Node node, int start, int end, int l, int r) {
        log.info("query node:{}, start:{}, end:{}, l:{}, r:{}", node.val, start, end, l, r);

        // 区间 [l ,r] 完全包含区间 [start, end]
        // 例如：[2, 4] = [2, 2] + [3, 4]，当 [start, end] = [2, 2] 或者 [start, end] = [3, 4]，直接返回
        if (l <= start && end <= r) {
            log.info("query return node:{}", node.val);
            return node.val;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        int ans = 0;
        if (l <= mid) {
            ans = query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        }
        return ans;
    }

    private void pushUp(Node node) {
        // 每个节点存的是当前区间的最大值
        node.val = Math.max(node.left.val, node.right.val);
    }

    private void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return ;
        }
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    public static void main(String[] args) {
        /**
         * Your MyCalendar object will be instantiated and called as such:
         * MyCalendar obj = new MyCalendar();
         * boolean param_1 = obj.book(start,end);
         */
        MyCalendar obj = new MyCalendar();
        // [10,20],[15,25],[20,30]
        boolean res1 = obj.book(10, 20);
        System.out.println(res1);

        boolean res2 = obj.book(15, 25);
        System.out.println(res2);

        boolean res3 = obj.book(20, 30);
        System.out.println(res3);
    }
}
