package com.sxw.learn.leetcode.other;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * [题目]:生成最大窗口数组
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑倒最右边，窗口每次向右边划一个位置。
 * 例如：
 * 数组为 [4,3,5,4,3,3,6,7],窗口大小为3时：
 * [4 3 5] 4 3 3 6 7 窗口的最大值为5
 * 4 [3 5 4] 3 3 6 7 窗口的最大值为5
 * 4 3 [5 4 3] 3 6 7 窗口的最大值为5
 * 4 3 5 [4 3 3] 6 7 窗口的最大值为4
 * 4 3 5 4 [3 3 6] 7 窗口的最大值为6
 * 4 3 5 4 3 [3 6 7] 窗口的最大值为7
 *
 * 如果数组的长度为 n ，窗口大小为 w ，则一共可以产生 n - w + 1个窗口最大值。
 *
 * 请实现一个函数
 * 输入：整型数组 arr, 窗口大小为 w。
 * 输出：一个长度为 n - w + 1的数组 res ,res[i]表示每一种窗口状态下的最大值，以本题为例，结果应该返回 [5,5,5,4,6,7]。
 */
public class GetMaxWindow {
    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1  || arr.length < w) return null;
        LinkedList<Integer> qmax = new LinkedList<>();// 存储的是数组的下标，存储的值是从大到小
        int res[] = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){// 相当与窗口的R，会一直右移
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) qmax.pollLast();
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) qmax.pollFirst();// 过期的下标需要从窗口中移出去
            if (i >= w - 1) res[index++] = arr[qmax.peekFirst()];// 窗口形成了，返回结果
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(arr, 3);
        Arrays.stream(res).boxed().forEach(System.out::println);
    }

}
