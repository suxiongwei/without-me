package com.sxw.learn.leetcode.str;

/**
 * [题目]: 字符串相加(415)
 * [题目描述]:
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * [解题思路]:
 * 按位置相加，对应位没数的置为0，然后利用取模和除法的性质处理进位
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int i1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int j1 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sumResult = i1 + j1 + add;
            sb.append(sumResult % 10);
            add = sumResult / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();// 计算完以后的答案需要翻转过来
    }

    public static void main(String[] args) {
        int i = '5' - '0';
        System.out.println(i);
    }
}
