package com.sxw.learn.leetcode.bit;

/**
 * 异或运算
 * * 亦或可以理解为 无进位相加（0+1=1，1+1=0，0+0=0）
 * 有以下性质：
 * 1. 0^N=N N^N=0
 * 2. 满足交换律和结合律
 * 3. 一批数执行异或操作和数字的顺序无关
 * 4. ：
 */
public class Xor {
    /**
     * 在一个数组中，有一种数出现了奇数次，其余数都出现了偶数次，找到这种数
     * 例：
     * [1,1,4] ==> 4
     * [1] ==> 1
     * [2,3,6,3,1,2,1] ⇒ 6
     *
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;// 0^N=N
        if (arr == null) return;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
    }

    /**
     * 有俩种数出现了奇数次，其余数出现了偶数次，求出现了奇数次的俩种数。
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必定有一个位置上为1
        int rightOne = eor & (~eor + 1);// 提取出最右的1
        for (int cur : arr){
            if ((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (onlyOne ^ eor));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,3,1,2,1};
        printOddTimesNum1(arr);
        int[] arr1 = new int[]{2,3,6,3,1,2,1,7};
        printOddTimesNum2(arr1);
    }
}
