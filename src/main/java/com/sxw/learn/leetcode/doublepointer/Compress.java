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
 * 示例 1：
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
 * 示例 3：
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
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




    public int compress1(char[] chars) {
        return 0;
    }
}
