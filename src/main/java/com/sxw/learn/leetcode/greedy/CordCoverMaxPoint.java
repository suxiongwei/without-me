package com.sxw.learn.leetcode.greedy;

import java.util.Arrays;

/**
 * [题目]: (贪心-数轴覆盖)给定一个有序数组arr，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n-1]。给定一个正数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点。
 * [思路]:
 * 1. 以数组中第一个点为绳子的开头，往后一个一个遍历，看能够覆盖多少个点。以第二个点为开头，往后依次遍历，记录覆盖的点的个数，依次遍历，寻找最大值。 -> 时间复杂度：O(N^2)
 * 2. 采用二分思想，当数组中每个点都为绳子的结尾，绳子长度为L时，寻找开头的位置。如arr[3]=9，L=9，寻找>=arr[3]-L 的最左边的点的位置。 -> 时间复杂度：O(NlogN)
 * 3. 以A为开头，最后一个不超过L的位置为结尾B，以第一个点为A，找满足条件的最远的B的位置，然后将A往前移动一个位置，B从当前位置继续往下遍历，寻找满足的结尾。-> LR不用回退，时间复杂度：O(N)
 *
 * 整体上是一种贪心的策略，只是在其之上加了点技巧
 * 窗口问题，如果左右边界都可以不回退，算法就只和左右边界的距离有关，基本上是O(N)的时间复杂度
 */
public class CordCoverMaxPoint {
    public static int maxPoint(int[] arr, int L) {
        int leftIndex = 0,rightIndex = 0,max = 0;
        int N = arr.length;
        while (leftIndex < N){
            while (rightIndex < N && arr[rightIndex] - arr[leftIndex] <= L){
                rightIndex++;
            }
            max = Math.max(rightIndex - leftIndex, max);// rightIndex - leftIndex 结果不需要减1，是因为上面while的rightIndex++越界了，所以需要将index回退，刚好抵消
            leftIndex++;
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = generateArray(7, 50);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("-------------------");
        System.out.println(maxPoint(arr, 13));
    }
}
