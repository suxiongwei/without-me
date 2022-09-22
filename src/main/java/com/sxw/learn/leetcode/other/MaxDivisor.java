package com.sxw.learn.leetcode.other;

public class MaxDivisor {
    /**
     * 求最小公倍数
     * 最小公倍数在求出最大公约数后，两个数相乘除以最大公约数就是最小公倍数。
     */
    public static long minCommonMultiple(long A, long B) {
        return A * B / maxCommonDivisor(A, B);
    }

    /**
     * 求最大公约数
     * 求最大公约数有两种方法：更相减损法和辗转相除法
     * <p>
     * 更相减损法：拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。
     */
    public static long maxCommonDivisor(long A, long B) {
        if (A == B) return B;
        return maxCommonDivisor(Math.min(A, B), Math.abs(A - B));
    }

    public static void main(String[] args) {
        long l = maxCommonDivisor(10, 25);
        System.out.println(l);

        long l1 = minCommonMultiple(10, 25);
        System.out.println(l1);
    }
}
