package com.sxw.learn.leetcode.str;

/**
 * [题目]: 字符串相乘(43)
 * [题目描述]:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * [解题思路]:
 * 做加法
 * 模拟「竖式乘法」的方法计算乘积。从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        // base case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        // num1:1234 num2:567
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--) {// 以num2作为乘数，从低位开始运算
            StringBuffer curr = new StringBuffer();

            int addZeroCount = len2 - (i + 1);// 模拟乘法加和的方式，除了最低位以外需要补零
            while (addZeroCount > 0) {
                curr.append("0");
                addZeroCount--;
            }

            int y = num2.charAt(i) - '0';// num2需要乘的数
            int carry = 0;
            int num1Index = len1 - 1;// 乘数每次都是从最低位开始
            while (num1Index >= 0 || carry > 0) {// 循环num1，作为被乘数，进行运算
                int x = num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0;
                curr.append((x * y + carry) % 10);
                carry = (x * y + carry) / 10;
                num1Index--;
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Multiply solution = new Multiply();
        String multiply = solution.multiply("1234", "567");
        System.out.println(multiply);
    }

}
