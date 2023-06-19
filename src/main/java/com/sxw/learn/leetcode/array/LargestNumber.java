package com.sxw.learn.leetcode.array;

import java.util.Arrays;

/**
 * [题目]: 最大数(179)
 * [题目描述]:
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * [解题思路]:
 * 将数组内元素逐个转化为字符串后，直接通过compareTo方法比较
 * 因为字符串的比较方式是：从头开始比较对应字符的大小(ASCII码顺序)
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        int n = nums.length;
        String[] numsToWord = new String[n];
        for (int i = 0; i < nums.length; i++) {
            numsToWord[0] = String.valueOf(nums[0]);
        }
        /**
         * Comparator接收返回值为正数，就会交换a和b
         * a = 3 b = 30 (303 compareTo 330 = -1) 那就是a和b不需要交换顺序，也是我们需要的结果
         */
        Arrays.sort(numsToWord, (a, b) -> (b + a).compareTo(a + b));
        if (numsToWord[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numsToWord[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";

        // 303 330

        System.out.println(s1.compareTo(s2));
    }
}
