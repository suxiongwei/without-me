package com.sxw.learn.leetcode.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] rec = new int[k];
        if (k == 0) return rec;
        PriorityQueue<Integer> queue = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o2 - o1);// 大的放在前面，是个无解队列
        for (int i = 0; i < k; i++) {// 无解队列，遍历到k，保证队列中只有k个元素
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++){// 保证队列中只有k个元素
            if (queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            rec[i] = queue.poll();
        }
        return rec;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers(arr, 5);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
