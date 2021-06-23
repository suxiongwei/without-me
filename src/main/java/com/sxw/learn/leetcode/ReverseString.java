package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-16 10:14 上午
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int length = s.length;
        int tmp = length >> 1;
        for (int i = 0; i < tmp; i++) {
            char tmpChar = s[length - 1 - i];
            s[length - 1 - i] = s[i];
            s[i] = tmpChar;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
    }
}
