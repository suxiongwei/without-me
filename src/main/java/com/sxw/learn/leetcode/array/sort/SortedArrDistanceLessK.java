package com.sxw.learn.leetcode.array.sort;

import java.util.PriorityQueue;

/**
 * 堆排序扩展题目
 * 已知一个基本有序的数组，基本有序是指如果把数组排好序，每个元素移动的距离不超过K，并且K相对于数组长度来说比较小，请选择合适的算法针对这个数据进行排序
 */
public class SortedArrDistanceLessK {
    public static void sortedArrDistanceLessK(int[] arr, int k){
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(k, arr.length); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
