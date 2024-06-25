package com.sxw.learn.leetcode;

import com.google.common.collect.Lists;
import com.sxw.learn.leetcode.linkedlist.ListNode;

import java.util.*;

public class Test {

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int maxArea = 0;
        while (left < right){
            if (height[left] <= height[right]){
                maxArea = (right - left) * height[left];
                left++;
            }else {

            }
        }
        return 0;
    }


    /**
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     */
    public static void sortColors(int[] nums) {
        int len = nums.length;
        int more = len - 1;
        int less = 0;
        int midNum = 1;
        int index = 0;
        while (index <= more){
            int num = nums[index];
            if (num < midNum){
                swap(nums, index, less);
                index++;
                less++;
            }else if (num == midNum){
                index++;
            }else {
                swap(nums, index, more);
                more--;
            }
        }
    }

    public static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    /**
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     */
    public void nextPermutation(int[] nums) {
        // 右边的最大数 与 左边的最小数交换
        int len = nums.length;
        int leftSmallIndex = 0;
        for(int i = len - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                leftSmallIndex = i;
                break;
            }
        }
        if (leftSmallIndex == 0){
            // reverse
        }
        int rightLargerIndex = 0;
        for (int i = len - 1; i > leftSmallIndex; i--){
            if (nums[i] > nums[leftSmallIndex]){
                rightLargerIndex = i;
                break;
            }
        }
        swap(nums, leftSmallIndex, rightLargerIndex);
    }

    List<String> res = new ArrayList<>();
    int[] ipSegment = new int[4];
    /**
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    public List<String> restoreIpAddresses(String s) {

        return Lists.newArrayList();
    }

    // 代表从start位置开始寻找第ipSegment段(ipSegment 从1开始)
    public void dfs(char[] chars, int ipSegmentIndex, int start){
        if (start == chars.length && ipSegmentIndex == 5){
            String ip = ipSegment[0] + "." + ipSegment[1] + "." + ipSegment[2] + "." + ipSegment[3];
            res.add(ip);
            return;
        }
        if (ipSegmentIndex > 4){
            return;
        }
        if (start >= chars.length){
            return;
        }
        if(chars[start] == '0'){
            ipSegment[ipSegmentIndex] = 0;
            dfs(chars, ++ipSegmentIndex, ++start);
        }
        int curIp = 0;
        for (int i = start; curIp <= 255 && i < chars.length; i++){
            curIp = curIp * 10 + chars[i] - '0';
            ipSegment[ipSegmentIndex] = curIp;
            dfs(chars, ++ipSegmentIndex, ++i);
        }
    }

    /**
     * 1 2 3 4 5 6 7 8
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    // 模拟乘法
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String res = "0";
        // 以第一个数作为乘数
        for (int i = len1 - 1; i >= 0; i--){
            StringBuilder curSb = new StringBuilder();
            int addZeroCount = (len1 - 1) - i;
            while (addZeroCount > 0){
                curSb.append("0");
                addZeroCount--;
            }
            int curNum1 = num1.charAt(i) - '0';
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--){
                int curNum2 = num2.charAt(j) - '0';
                int curMultiply = curNum1 * curNum2 + carry;
                curSb.append(curMultiply % 10);
                carry = curMultiply / 10;
            }
            if (carry > 0){
                curSb.append(carry);
            }
            res = addString(res, curSb.reverse().toString());
        }
        return res;
    }

    public static String addString(String str1, String str2){
        int len1 = str1.length() - 1;
        int len2 = str2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || carry > 0){
            int num1 = len1 >= 0 ? str1.charAt(len1) - '0' : 0;
            int num2 = len2 >= 0 ? str2.charAt(len2) - '0' : 0;
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            sb.append(sum);
            len1--;
            len2--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        int[] nums = {2,0,2,1,1,0};
//        sortColors(nums);
//        System.out.println(Arrays.toString(nums));
        String s = multiply("123", "456");
        System.out.println(s);
    }
}
