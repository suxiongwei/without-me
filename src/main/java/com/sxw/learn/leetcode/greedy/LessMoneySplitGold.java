package com.sxw.learn.leetcode.greedy;

import java.util.PriorityQueue;

/**
 * [题目]：金条切割问题
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
 * 问：一群人想整分整块金条，怎么分最省铜板？
 * 例如，给定数组{10，20，30}，代表一共三个人，整块金条长度为10+20+30=60。
 * 金条要分成10，20，30。如果先把长度60的金条分成10和50，花费60；再把长度50的金条分成20和30，花费50；一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，花费60；再把长度30金条分成10和20，花费30；一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 *
 * [解题思路]
 * 使用贪心算法
 * 1、准备一个小根堆
 * 2、把所有树放到小根堆中
 * 3、然后依次弹出两个数，求和
 * 4、把和扔到小根堆中
 */
public class LessMoneySplitGold {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();// 默认小根堆，排序后每次都希望花费最小的代价(贪心)
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(LessMoneySplitGold.lessMoney(arr));
    }
}
