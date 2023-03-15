package com.sxw.learn;

import com.google.common.collect.Lists;
import com.sxw.learn.leetcode.linkedlist.ListNode;
import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.*;

public class Solution {

    List<String> res = new ArrayList<>();
    List<Character> characterList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // base case
        if (digits == null || digits.equals("")) return res;

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        dfs(digits, phoneMap, 0);
        return res;
    }

    // 当前处理到目标字符串digits的index位置
    private void dfs(String digits, Map<Character, String> phoneMap, int index) {
        if (index == digits.length()){
            StringBuilder sb = new StringBuilder();
            characterList.stream().forEach(i -> sb.append(i));
            res.add(sb.toString());
            return;
        }
        Character curNum = digits.charAt(index);
        String curNumChar = phoneMap.get(curNum);
        for (int curNumIndex = 0; curNumIndex < curNumChar.length(); curNumIndex++) {
            characterList.add(curNumChar.charAt(curNumIndex));
            dfs(digits, phoneMap, index + 1);
            characterList.remove(characterList.size() - 1);
        }
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
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);


    }
}
