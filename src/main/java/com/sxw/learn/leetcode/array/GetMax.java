package com.sxw.learn.leetcode.array;

/**
 * 求最大值
 * TODO 补充题目详细描述
 */
public class GetMax {
    public static int getMax(int[] nums){
        if (null == nums) return 0;
        return process(nums, 0, nums.length - 1);
    }

    // arr[L..R]范围上求最大值
    public static int process(int[] arr, int L, int R){
        if (L == R){ // arr[L..R]范围上只有一个数，base case 直接返回
            return arr[L];
        }
        /**
         * 求中点，可以理解为固定写法
         * 这种写法的好处：
         * 1、防止计算溢出，比如说L 和 R是个很大的数，求和的方式求中点就会溢出
         * 2、
         */
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    /**
     * master是一个对于递归行为时间复杂度的估算
     * 公式为：T(N) = a * T(N/b) + O(N^d);
     * T(N) 是母问题,T(N/b)是子问题
     *
     * a ： 会有几次调用代码的次数
     * b ： 每次调用代码的规模大小
     * O(N ^ d) : 指除了递归行为之外的行为复杂度
     *
     * 如果log(b,a) < d 时间复杂度为： O(N^d)
     * 如果log(b,a) > d 时间复杂度为 ： O(N^(log(b,a)))
     * 如果log(b,a) == d 时间复杂度为：O(N^d * log(2,n)))
     *
     */

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,1,3,2};
        int max = getMax(a);
        System.out.println(max);
    }
}
