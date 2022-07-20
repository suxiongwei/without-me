package com.sxw.learn.leetcode;

/**
 * 反转字符串(301)
 * 题目描述：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 题目要求：不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class ReverseString {
    // 解法一
    public static void reverseString(char[] s) {
        int length = s.length;
        int tmp = length >> 1;
        for (int i = 0; i < tmp; i++) {
            char tmpChar = s[length - 1 - i];
            s[length - 1 - i] = s[i];
            s[i] = tmpChar;
        }
    }

    // 解法二，使用双指针
    public static void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        ReverseString.reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println("");
        s = new char[]{'h','e','l','l','o'};
        ReverseString.reverseString1(s);
        for (char c : s) {
            System.out.print(c);
        }



    }
}
