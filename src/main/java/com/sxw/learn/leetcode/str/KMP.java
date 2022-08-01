package com.sxw.learn.leetcode.str;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * KMP算法
 * 解决的问题:字符串str1和str2，str1是否包含str2，如果包含返回str2在str1中出现的位置。能否做到时间复杂度O(N)完成？
 * 暴力匹配：KMP是由暴力匹配改进的字符串匹配算法,暴力匹配的时间复杂度O(M*N)
 */
public class KMP {
    public static int getIndexOf(String s, String m){
        if (s == null || m == null || m.length() < 1 || m.length() > s.length()) return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        // O(N)
        while (i1 < str1.length && i2 < str2.length){
            if (str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if (next[i2] == -1){// 也可以写成i2 == 0
                i1++;// 我已经到了零位置了，还和你无法匹配，那你换一个开头吧
            }else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) return new int[]{-1};
        int next[] = new int[ms.length];
        next[0] = -1;// 0、1位置的可以写死
        next[1] = 0;
        int i = 2;// next数组的位置
        int cn = 0;
        while (i < next.length){
            if (ms[i - 1] == ms[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){// 当前跳到cn位置的字符，和i-1的位置的字符匹配不上，继续往前跳
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        /**
         * str1:    a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  e  g  h  j  s  d  s  s  d  g  f  d  s  s  g  h  s  f
         * str2:    a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  f  t  s  k  t
         * index:   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20
         * next:    -1 0  0  0  0  1  2  3  0  0  1  2  3  4  5  6  7  0  0  0  0
         * 1):i1和i2全部推到16位置                                    i1
         *                                                          i2
         *
         * 执行流程：
         * i1和i2的全部推到index 16位置,发现16位置的字符匹配不上
         * i1 不变，i2根据next数组往前跳，跳到7，然后str2 7开始的字符和str1 16开始的字符继续匹配，相当于str2 往右推，如下:
         * str1:    a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  e  g  h  j  s  d  s  s  d  g  f  d  s  s  g  h  s  f
         * str2:                               a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  f  t  s  k  t
         * index:   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20
         *                                     j                    i1
         *                                                          i2
         * 为什么直接跳过0～j，可以用反证法证明
         * str1:    a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  e  g  h  j  s  d  s  s  d  g  f  d  s  s  g  h  s  f
         *                      K              j                    X
         * str2:    a  b  b  t  a  b  b  z  c  a  b  b  t  a  b  b  f  t  s  k  t
         *                                     j                    Y
         * index:   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20
         * 如果存在k开头的str2，则K~X = str2同等长度的字符串，这个字符串比X位置next中的值要大，与next的定义不符合，证明不成立
         */
        String str1 = "abbtabbzcabbtabbeghjsdssdgfdssghsf";
        String str2 = "abbtabbzcabbtabbftskt";
        int[] nextArray = getNextArray(str2.toCharArray());
        String nextArrayStr = Joiner.on(",").join(Arrays.stream(nextArray).boxed().collect(Collectors.toList()));
        System.out.println("nextArray:" + nextArrayStr);
        System.out.println(getIndexOf(str1, str2));
    }
}
