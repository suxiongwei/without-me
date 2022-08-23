package com.sxw.learn.leetcode.other;

/**
 * [题目]:
 * 给定一个函数f， 可以1～5的数字等概率返回一个。 请加工出1～7的数字等概率返回一个的函数g。
 * 给定一个函数f， 可以a～b的数字等概率返回一个。 请加工出c～d的数字等概率返回一个的函数g。
 * 给定一个函数f， 以p概率返回0， 以1-p概率返回1。 请加工出等概率返回0和1的函数g
 */
public class Rand5ToRand7 {
    //已知的等概率返回1-5的函数
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    /**
     * 加工出等概率返回0，1的函数
     */
    public static int r01(){
        int res = 0;
        do {
            res = f();
        }while (res == 3);
        return res < 3 ? 0 : 1;
    }

    /**
     * 1～7的数字等概率返回
     * 相当于等概率返回 0~6,然后在结果上加一
     * 0～6 可以用三个二进制位表示，三个二进制位可以表示的数字范围为0～7，排除掉7即可
     */
    public static int f07(){
        int res = 0;
        do {
            res = (r01() << 2) + (r01() << 1) + r01();// 二进制的每一位都是随机的，整体就是随机的
        }while (res != 7);
        return res + 1;
    }

    /*
     * 如果现在给我们一个返回13-21的等概率函数，要求我们做出返回30-59等概率返回的函数
	 * 首先利用13-21函数制造一个等概率返回0和1的函数，然后我们可以利用这个r01(),做出
	 * 0-29，注意，一定要从0开始求，然后求得的值加上30就ok了
	 * 29是包含在111111（32）之内的，所以可以当生成的值大于29就重新生成
	 */

     /*
      * 给定一个函数f， 以p概率返回0， 以1-p概率返回1。 请加工出等概率返回0和1的函数k
      * 让f函数调用两次，如果是1,1重新调用，如果是0，0重新调用，如果是0,1就认为是0返回
      * 如果是1,0就认为是1返回
      */
}