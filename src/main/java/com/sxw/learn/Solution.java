package com.sxw.learn;

import com.google.common.collect.Lists;
import com.sxw.learn.leetcode.linkedlist.ListNode;
import com.sxw.learn.leetcode.tree.TreeNode;

import java.util.*;
import java.util.stream.Stream;

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

    public String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;

        int i1 = len1 - 1;
        int i2 = len2 - 1;
        int add = 0;

        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0 || add > 0) {
            int s1 = i1 >= 0 ? char1[i1] - '0' : 0;
            int s2 = i2 >= 0 ? char2[i2] - '0' : 0;
            int curNum = (s1 + s2 + add) % 10;
            add = (s1 + s2 + add) / 10;
            sb.append(curNum);
            i1--;
            i2--;
        }
        return sb.reverse().toString();
    }

    public String add36Strings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;

        int i1 = len1 - 1;
        int i2 = len2 - 1;
        int add = 0;

        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0 || add > 0) {
            int s1 = i1 >= 0 ? fun1(char1[i1]) : 0;
            int s2 = i2 >= 0 ? fun1(char2[i2]) : 0;
            int curNum = (s1 + s2 + add) % 36;
            add = (s1 + s2 + add) / 36;
            sb.append(fun2(curNum));
            i1--;
            i2--;
        }
        return sb.reverse().toString();
    }

    // 36进制转换为10进制
    int fun1(char c) {
        if (c <= '9') {
            return c - '0';
        } else {
            return 10 + c - 'a';
        }
    }

    char fun2(int n) {
        if (n <= 9) {
            return (char) ('0' + n);
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    public String multiply(String num1, String num2) {
        String ans = "0";
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;

        int num2Index = len2 - 1;

        // 以num2作为乘数
        while (num2Index >= 0) {
            int num1Index = len1 - 1;// 乘数每次都是从最低位开始
            StringBuilder sb = new StringBuilder();
            int addZeroCount = len2 - (num2Index + 1);
            while (addZeroCount > 0) {
                sb.append("0");
                addZeroCount--;
            }
            int carry = 0;

            while (num1Index >= 0 || carry > 0) {
                int n1 = num1Index >= 0 ? char1[num1Index] - '0' : 0;
                int n2 = char2[num2Index] - '0';
                sb.append((n1 * n2 + carry) % 10);
                carry = (n1 * n2 + carry) / 10;
                num1Index--;
            }
            ans = addStrings(ans, sb.reverse().toString());
            num2Index--;
        }
        return ans;
    }


    public int minEatingSpeed(int[] piles, int h) {
        // 以速度做二分
        int minSpeed = 1;
        int maxSpeed = Arrays.stream(piles).max().getAsInt();
        while (minSpeed < maxSpeed) {
            int mid = (maxSpeed + minSpeed) >> 1;
            // 当前速度超过了最大限制
            if (canEat(piles, mid, h)) {
                minSpeed = mid + 1;
            } else {
                minSpeed = mid;
            }
        }
        return minSpeed;
    }


    // 超过了最大限制
    public boolean canEat(int[] piles, int speed, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile / speed);
        }
        return sum > h;
    }

    /**
     * 00 01 02 03 04
     * 10 11 12 13 14
     * 20 21 22 23 24
     * 30 31 32 33 34
     * 40 41 42 43 44
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    static int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }

    // 从segStart位置开始找第segId段
    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            // 是一种结果
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }

        if (segStart == s.length()) return;

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int ip = 0;
        for (int i = segStart; i < s.length(); i++) {
            ip = ip * 10 + s.charAt(i) - '0';
            if (ip <= 255) {
                segments[segId] = ip;
                dfs(s, segId + 1, segStart + 1);
            } else {
                break;
            }
        }
    }

    void fun1(int i) {
        System.out.println(i);
    }

    void fun3(int i) {
        fun1(++i);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            if (matrix[i][0] == '1') {
                ans = 1;
            }
        }
        // 列
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            if (matrix[0][i] == '1') {
                ans = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int s = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    ans = Math.max(ans, s);
                    dp[i][j] = s;
                }
            }
        }
        return ans * ans;
    }

    // 13 = 9 + 4
    public int numSquares(int n) {
        // dp[0] = 0, dp[1] = 1 dp[2] = 2 dp[3] = 3 dp[4] = 1
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minV = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minV = Math.min(minV, dp[i - j * j]);
            }
            dp[i] = minV + 1;
        }
        return dp[n];
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        return false;
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

    }
}
