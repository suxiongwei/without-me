package com.sxw.learn.leetcode.array;

/**
 * [题目]: 字母排序
 * [题目描述]:
 *  实现对一组无序的字母进行从小到大排序（区分大小写），当两个字母相同时，
 *  小写字母放到大写字母之前。要求时间复杂度为O(n)
 * [解题思路]:
 * 大小写字母一共52个，开辟大小52的数组charArr，偶数位置存放小写字母，奇数位置存储大写字母 aAbBcC...
 * 遍历原始数组，在charArr对应index位置统计出现次数，然后遍历charArr将结果输出
 */
public class CharacterSort {
    char[] charSort(char[] arr) {
        int[] charArr = new int[52];// 偶数位置存放小写字母，奇数位置存储大写字母 aAbBcC...
        for (char c : arr) {
            if (c - 'a' >= 0) {// 小写字母 -> 偶数位置，小写字母的编码int值要比大写字母大
                int index = (c - 'a') * 2;
                charArr[index]++;
            } else {
                int index = (c - 'A') * 2 + 1;
                charArr[index]++;
            }
        }

        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != 0) {
                if (i % 2 == 0) {// 偶数位置
                    for (int j = 0; j < charArr[i]; j++){// 出现了多少次就打印多少次
                        arr[index++] = (char) ('a' + i / 2);
                    }
                } else {
                    for (int j = 0; j < charArr[i]; j++){
                        arr[index++] = (char) ('A' + (i - 1) / 2);
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        CharacterSort solution = new CharacterSort();
//        char[] letter = {'H', 'e', 'l', 'l', 'o', 'Q', 'L', 'P'};
//        char[] letter = {'A', 'b', 'a'};
        char[] letter = {'A','a','C','F','d','B','c','C'};
        char[] sort = solution.charSort(letter);
        System.out.println(sort);
    }
}
