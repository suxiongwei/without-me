package com.sxw.learn.leetcode.other;

/**
 * [题目]:
 * 一个完整的括号字符串定义规则如下:
 * 1、空字符串是完整的。
 * 2、如果s是完整的字符串，那么(s)也是完整的。
 * 3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。请问牛牛至少需要添加多少个括号。
 * <p>
 * [输入描述]:
 * 输入包括一行,一个括号序列s,序列长度length(1 ≤ length ≤ 50).
 * s中每个字符都是左括号或者右括号,即'('或者')'.
 * <p>
 * [输出描述]:
 * 输出一个整数,表示最少需要添加的括号数
 * [示例1]
 * 输入:(()(() 输出:2
 */
public class GetNeed {
    public static int getNeed(String s) {
        char[] chs = s.toCharArray();
        int count = 0;//遇到左括号就++，遇到右括号就--
        int ans = 0;// 遍历到最后，如果count == 0，那么ans就是需要填补的左括号的数量
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                count++;
            } else {
                if (count == 0) {
                    ans++;
                } else {
                    count--;
                }
            }
        }
        return ans + count;
    }

    public static void main(String[] args) {
        System.out.println(getNeed("(()(()"));
    }
}
