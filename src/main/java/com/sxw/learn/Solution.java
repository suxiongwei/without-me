package com.sxw.learn;

import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    int res = 0;

    // 494. 目标和
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }

    // nums = [1,1,1,1,1], target = 3
    public void dfs(int[] nums, int target, int curStart, int curSum) {
        // 已经遍历完数组
        if (curStart == nums.length) {
            if (target == curSum) {
                res++;
            }
            return;
        }
        // 处理加
        dfs(nums, target, curStart + 1, curSum + nums[curStart]);
        // 处理减
        dfs(nums, target, curStart + 1, curSum - nums[curStart]);
    }

    class Node{
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        dfs(node, p, q);
        return ans;
    }

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if (node == null) return false;
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right, p, q);
        boolean b1 = lSon && rSon;
        boolean b2 = (lSon || rSon) && (node.val == p.val || node.val == q.val);
        if (b1 || b2){
            ans = node;
        }
        return lSon || rSon || node.val == p.val || node.val == q.val;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//
//        solution.rotateRight(node1, 2);
//        int[] nums = {0, 1, 0};
//        int maxLength = solution.findMaxLength(nums);
//        System.out.println(maxLength);

//        solution.fun3(10);

//        char[][] s = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };
//        solution.maximalSquare(s);

//        solution.numSquares(13);

//        System.out.println(Integer.valueOf('0'));

//        System.out.println(Integer.valueOf('a'));

//        for (int i = 0; i < 100; i++) {
//            char s = (char) i;
//            System.out.println(s);
//        }

//        String multiply = solution.multiply("9", "9");

//        List<String> stringList = Lists.newArrayList("s1", "s2", "s3", "s4", "s5");
//        Iterator<String> iterator = stringList.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//            iterator.remove();
//        }

//        System.out.println(Math.sqrt(4));

//        System.out.println((double) 1 / 11);

//        Deque<Integer> deque = new ArrayDeque();
//        deque.offerFirst(1);
//        deque.offerLast(2);
//
//        deque.peekFirst();
//        deque.pollFirst();
//
//        // 遍历队列
//        while (!deque.isEmpty()){
//            System.out.println("开始遍历队列元素");
//            System.out.println(deque.pollFirst());
//        }
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        solution.removeNthFromEnd(head, 2);


//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//
//        node1.left = node2;
//        node1.right = node3;
//
//        node2.left = node4;
//        node2.right = node5;
//
//        node3.left = node6;
//        node3.right = node7;
//
//        solution.sumNumbers(node1);
//        double s = 235d / (25772 + 9136 - 245);
//        System.out.println(s);
//        List<String> strings = solution.letterCombinations("23");
//        System.out.println(strings);

        int[] nums = {1};
        int targetSumWays = solution.findTargetSumWays(nums, 1);
        System.out.println(targetSumWays);

    }
}
