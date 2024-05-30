package com.sxw.learn.leetcode.queue;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 表演评分
 *
 * 描述：
 * 在演讲比赛中，评委对参赛者的表演 进行评分。评分方法:给定n个正整数评分，删除最大的n1个和最小的n2个评分，将其余评分的平均值作为参赛者的最终成绩。请给出参赛者的最终成绩。
 *
 * 输入: 输入包含几个测试用例，每个测试用例都包含两行:
 * 第1行包含3个整数n1 、n2 和n(1≤n1 ,n2 ≤10，n1 +n2 <n≤5×106 );
 * 第2行包含n个正整数ai (1≤ai ≤108 ，1≤i ≤n )。
 * 在最后一个测试用例后跟3个0。
 *
 * 输出: 对每个测试用例，都单行输出参赛者的最终成绩，保留小数点后6位。
 */
public class POJ2833 {
    /**
     *
     * @param arr_n 3个整数n1(删除最大的个数) 、n2(删除最小的个数) 和n(评分总个数)
     * @param arr_a n个正整数ai (1≤ai ≤108 ，1≤i ≤n )
     *
     * 例子：arr_n = {1,2,5} arr_a = {1,2,3,4,5} 结果：
     *
     * @return
     */
    public static double calScore(int[] arr_n, int[] arr_a){
        int n1 = arr_n[0];
        int n2 = arr_n[1];
        int n = arr_n[2];

        PriorityQueue<Integer> bigQueue = new PriorityQueue(Comparator.reverseOrder());
        PriorityQueue<Integer> smallQueue = new PriorityQueue();
        int sum = 0;
        for (int i = 0 ; i < arr_a.length; i++){
            int cur = arr_a[i];
            sum += cur;
            // 堆顶元素，实际起一个门槛的作用
            // 筛选最大的n1个数，需要用到小根堆
            if (smallQueue.size() >= n1){
                if (cur > smallQueue.peek()){
                    smallQueue.poll();
                    smallQueue.offer(cur);
                }
            }else {
                smallQueue.offer(cur);
            }
            // 筛选最小的n1个数，需要用到大根堆
            if (bigQueue.size() >= n2){
                if (cur < bigQueue.peek()){
                    bigQueue.poll();
                    bigQueue.offer(cur);
                }
            }else {
                bigQueue.offer(cur);
            }
        }
        int tmp = 0;
        while (!bigQueue.isEmpty()){
            tmp += bigQueue.poll();
        }
        while (!smallQueue.isEmpty()){
            tmp += smallQueue.poll();
        }
        return (double) (sum - tmp) / (n - n1 - n2);
    }

    public static void main(String[] args) {
        double v = calScore(new int[]{1, 2, 5}, new int[]{1, 2, 3, 4, 5});
        System.out.println(v);
    }
}
