package com.sxw.learn.leetcode.str;

/**
 * [题目]:最后一个单词的长度
 * [题目描述]:给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * [解题思路]:
 * 一般的解题思路为，先去掉末尾的空格，然后从尾向前开始遍历，直到遇到第一个空格处结束。
 * 可以使用语言的原生函数，但是使用了直接G
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int length = s.length();
        int end = length - 1;// 字符串末尾下标
        while (end >= 0 && s.charAt(end) == ' ') end--;// 过滤掉末尾的空格
        if (end < 0) return 0;// 都是空格的情况
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;// 从最后一个单词开始遍历，找到空格就停止，此时start和end之间的字符即为最后一个单词
        return end - start;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        str = "         ";
        System.out.println(LengthOfLastWord.lengthOfLastWord(str));
    }
}
