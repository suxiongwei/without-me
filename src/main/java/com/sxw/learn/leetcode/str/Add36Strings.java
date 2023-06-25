package com.sxw.learn.leetcode.str;

/**
 * [题目]: 36进制加法
 * [题目描述]:
 * 36进制由0-9，a-z，共36个字符表示。
 * 要求按照加法规则计算出任意两个36进制正整数的和，如:
 * 1b + 2x = 48  （解释：47+105=152）
 * b为11， x为33
 *
 * 1b = 11 * 36^0 + 1 * 36 ^ 1 = 47
 * 2x = 33 * 36 ^ 0 + 2 * 36 ^ 1 = 105
 *
 * 要求：不允许使用先将36进制数字整体转为10进制，相加后再转回为36进制的做法
 * https://mp.weixin.qq.com/s/XcKQwnwCh5nZsz-DLHJwzQ
 * [解题思路]:
 * 代码与 LC 415 字符串相加 基本一致
 * 将每一位转换为十进制计算后，再把结果转换为36进制
 *
 * int 与 char的对应
 * 48 ～ 57 对应 0 ～ 9
 * 97 ～ 122 对应 a ～ z
 */
public class Add36Strings {
    public String add36Strings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            int y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int sum = x + y + carry;
            sb.append(getChar(sum % 36));
            carry = sum / 36;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    // 将十进制整数转化为 36进制字符
    public char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }

    // 将36进制字符转化为10进制整数
    public int getInt(char c) {
        if (c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }

    public static void main(String[] args) {
//        Add36Strings solution = new Add36Strings();
//        String a = "1b", b = "2x";
//        String c = solution.add36Strings(a, b);
//        System.out.println(c);
        for (int i  = 0; i < 150; i++){
            System.out.println(i + "=" + (char) i);
        }
    }
}
