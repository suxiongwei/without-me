package com.sxw.learn.leetcode.str;

/**
 * [题目]: 阿拉伯数字转化为中文读法
 * [题目描述]:
 * 给出一个五位阿拉伯数字，请写出它的中文读法，如：
 * 12345 —> 一万两千三百四十五
 * 10000 —> 一万
 *
 * [解题思路]:
 * 建立映射表，重点在于零的处理
 */
public class NumToChinese {
    static char[] numArr = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    static String[] unitArr = {"", "十", "百", "千", "万"};

    public String numToChinese(int num) {
        char[] newNum = String.valueOf(num).toCharArray();
        int len = newNum.length;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int temp = Integer.parseInt(String.valueOf(newNum[i]));
            boolean zeroFlag = temp == 0 ? true : false;
            if (zeroFlag) {
                while (i < len - 1 && newNum[i + 1] == '0') {
                    i++;
                }
                if (i != len - 1) {// 当前没有到达末尾位置
                    res.append(numArr[0]);
                }
            } else {
                res.append(numArr[temp]);
                res.append(unitArr[len - i - 1]);
            }
        }
        return res.toString();
    }

    public String numToChinese1(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = chars.length;
        while (i < len) {
            boolean zeroFlag = chars[i] == '0' ? true : false;
            if (zeroFlag) {
                // 和当前元素的下一个元素相比
                while (i < len - 1 && chars[i + 1] == '0') {
                    i++;
                }
                if (i != len - 1) {// 当前没有到达末尾位置
                    sb.append(numArr[chars[i] - '0']);
                }
            } else {
                sb.append(numArr[chars[i] - '0']);
                sb.append(unitArr[len - i - 1]);
            }
            i++;// 当前元素处理完了，继续往下走到下一个元素
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumToChinese solution = new NumToChinese();
        String toChinese = solution.numToChinese1(10034);
        System.out.println(toChinese);
    }
}
