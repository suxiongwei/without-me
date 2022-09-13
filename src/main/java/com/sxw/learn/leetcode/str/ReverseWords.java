package com.sxw.learn.leetcode.str;

/**
 * [题目]: 颠倒字符串中的单词
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * [示例]:
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
 */
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

    /**
     * 以下是反转字符串中的单词III(557)
     * 给定一个字符串s，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例 1：
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * 提示：
     * 1 <= s.length <= 5 * 104
     * s包含可打印的 ASCII 字符。
     * s不包含任何开头或结尾空格。
     * s里 至少 有一个词。
     * s中的所有单词都用一个空格隔开。
     */
    public static String reverseWords1(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = reverseWords1("Let's take LeetCode contest");
        System.out.println(s);
    }
}

