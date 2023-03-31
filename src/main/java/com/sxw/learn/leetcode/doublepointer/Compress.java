package com.sxw.learn.leetcode.doublepointer;

/**
 * [题目]: 压缩字符串(443)
 * [题目描述]:
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *     如果这一组长度为1，则将字符追加到 s 中。
 *     否则，需要向 s 追加字符，后跟这一组的长度。
 *
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 * [解题思路]:
 * 双指针，测试用例未通过
 */
public class Compress {
    public int compress(char[] chars) {
        int res = 0;

        if (chars == null || chars.length == 0) {
            return res;
        }
        int len = chars.length;

        int left = 0;
        int right = 0;
        while (right < len){
            while (right < len && chars[right] == chars[left]){
                right++;
            }
            if (right == left){
                res++;
            }else {
                right--;
                int tmpCount = right - left + 1;
                res = res + countNumberDigits(tmpCount) + 1;
            }
            left = right + 1;
            right = left;
        }
        return res;
    }

    // 查看位数
    public int countNumberDigits(int num){
        int count = 0;
        while (num != 0){
            count++;
            num = num / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        Compress solution = new Compress();
        int compress = solution.compress(chars);
        System.out.println(compress);
    }
}
