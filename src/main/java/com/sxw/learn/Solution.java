package com.sxw.learn;

import com.sxw.learn.leetcode.linkedlist.ListNode;
import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = len - 1;
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                if (second == third) break;
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> tmpRes = new ArrayList<>();
                    tmpRes.add(nums[first]);
                    tmpRes.add(nums[second]);
                    tmpRes.add(nums[third]);
                    res.add(tmpRes);
                }
            }

        }
        return res;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    // -2,1,-3,4,-1,2,1,-5,4
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[0]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
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

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        solution.maxSubArray(nums);
    }
}
