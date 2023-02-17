package com.sxw.learn;

import com.sxw.learn.leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 1,2,3,4,5  k =2
     * 最终结果为：4,5,1,2,3
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
            length++;
        }
        k = k % length;
        ListNode fast = head;
        for (int i = 0; i <= k; i++) {
            fast = fast.next;// 最终fast为4
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;// 最终slow为3
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        tail.next = head;
        return newHead;
    }

    // 0,1,0
    public int findMaxLength(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);

        int preSum = 0;
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            preSum = preSum + nums[i];
            if (map.containsKey(preSum)) {
                maxLength = Math.max(maxLength, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return maxLength;
    }

    public int f(char[] chars, int left, int right, int len) {
        int res = 0;
        if (chars[left] != chars[right]) {
            return 0;
        }
        if (right >= len) {
            return 0;
        }
        while (right < len && chars[left--] == chars[right++]) {
            res++;
        }
        return res;
    }

    // 1,2,3 k = 3
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);

        int preSum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            preSum = preSum + nums[i];
            if (map.containsKey(preSum - k)) {
                res = res + map.get(preSum - k);
            }
            // 更新前缀和及其出现的次数
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        return null;
    }

    public static void main(String[] args) {
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
        Solution solution = new Solution();
//        solution.rotateRight(node1, 2);
        int[] nums = {0, 1, 0};
        int maxLength = solution.findMaxLength(nums);
        System.out.println(maxLength);

    }
}
