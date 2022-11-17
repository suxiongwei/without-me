package com.sxw.learn.leetcode;

import java.util.Arrays;

/**
 * [题目]: 爱吃香蕉的珂珂(875)
 * [题目描述]:
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * [解题思路]:
 * 二分法，以吃的速度做二分
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {
        int minSpeed = 1;// 最小的速度，以速度做二分
        int maxSpeed = Arrays.stream(piles).max().getAsInt();// 最大的速度
        int right = maxSpeed;
        while (minSpeed < right) {
            int mid = (minSpeed + right) >> 1;
            if (canEat(piles, mid, H)) {
                minSpeed = mid + 1;
            } else {
                right = mid;
            }
        }
        return minSpeed;
    }

    // 以当前的速度吃 是否超过了最大限制时间H
    private boolean canEat(int[] piles, int speed, int H) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile * 1.0 / speed);// 向上取整
        }
        return sum > H;
    }

    public static void main(String[] args) {
        MinEatingSpeed solution = new MinEatingSpeed();
        int i = solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        System.out.println(i);
    }
}
