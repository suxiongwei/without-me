package com.sxw.learn.leetcode.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 围栏修复
 *
 * 题目描述(POJ3253):
 * 约翰想修牧场周围的篱笆，需要N 块 (1≤N ≤20000)木板，每块木板的长度都为Li (1≤Li ≤50000，整 数)米。
 * 他购买了一块足够长的木板(长度为Li 的总和，i =1, 2, ..., N )，以便得到N 块木板，切割时木屑损失的长度不计。
 * 唐向约翰收取切割费用，切割一块木板的费用与其长度相同，切割21米的木板需 要21美分。唐让约翰决定切割木板的顺序和位置。
 * 约翰知道以不同的顺序切割木板，将会产生不同的费用。请帮助约翰确定他得到N块木板的最低花费。
 *
 * 输入: 第1行包含整数N ，表示木板的数量。第2..N +1行，每行都包含一个所需木板的长度Li 。
 * 输出: 一个整数，即进行N -1次切割的最低花费。
 *
 * 例：
 * 输入：
 * 3 代表的三块木板
 * 8 代表长度
 * 5 代表长度
 * 8 代表长度
 * 输出：
 * 34 (21 + 13 = 34)
 *
 *
 * 解题方式：
 * 题解: 每次都选择两个最小的合并，直到合并为一棵树。每次合并的结果就是切割的费用。
 * 使用优先级队列求解
 */
public class POJ3253 {
    public static Integer POJ3253(List<Integer> input){
        // 大顶堆
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < input.size(); i++){
            queue.offer(input.get(i));
        }
        int sum = 0;
        while (!queue.isEmpty()){
            Integer val1 = queue.poll();
            if (!queue.isEmpty()){
                Integer val2 = queue.poll();
                int curSum = val2 + val1;
                if (!queue.isEmpty()){
                    queue.offer(curSum);
                }
                sum = sum + curSum;
            }else {
                sum = sum + val1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        List<Integer> input = new ArrayList<>();
//        input.add(3);
//        input.add(8);
//        input.add(5);
//        input.add(8);

//        System.out.println(POJ3253(input));

        PriorityQueue queue = new PriorityQueue(Comparator.reverseOrder());
        queue.offer(3);
        queue.offer(8);
        queue.offer(5);
        queue.offer(8);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
