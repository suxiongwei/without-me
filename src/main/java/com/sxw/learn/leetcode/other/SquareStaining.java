package com.sxw.learn.leetcode.other;

/**
 * [题目]: 红和绿
 * [题目描述]: 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 * 牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。
 * 牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR
 * 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 * [题目分析]:
 * [解题思路]: 预处理法
 * 使用两个变量分别记录分割线左右两边出现的R和G的次数。定义lCount记录分割线左边出现的G的次数，定义rCount记录分割线右边出现的R。
 */
public class SquareStaining {
    public static int squareStaining(String s){
        int lCount = 0;// 分割线左边出现的G的次数
        int rCount = 0;// 分割线右边出现的R的次数
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            rCount += chars[i] == 'R' ? 1 : 0;
        }
        int res = rCount;
        for (int i = 0; i < chars.length; i++) {
            lCount += chars[i] == 'G' ? 1 : 0;
            rCount += chars[i] == 'R' ? 1 : 0;
            res = Math.min(res, lCount + rCount);
        }
        res = Math.min(res, lCount);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(squareStaining("RRRRR"));
    }
}
