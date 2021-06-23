package com.sxw.learn.leetcode;

public class ReverseWords {
    public String reverseWords(String s) {
        // 去除前后空格及中间多余的空格
        StringBuilder sb = trimSpaces(s);
        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);
        // 翻转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n){
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') end ++;
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            end ++;
        }
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left ++, sb.charAt(right));
            sb.setCharAt(right --, tmp);
        }
    }

    private StringBuilder trimSpaces(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        // 去掉前后的空格
        while (left < right && s.charAt(left) == ' ') left ++;
        while (left < right && s.charAt(right) == ' ') right --;
        // 去掉字符串中间的空格
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                sb.append(c);
            }else if (sb.charAt(sb.length() - 1) != ' '){ // 如果这个字符串是空白字符，那么在前一个字符不是空白字符才添加
                sb.append(c);
            }
            left ++;
        }
        return sb;
    }
}

