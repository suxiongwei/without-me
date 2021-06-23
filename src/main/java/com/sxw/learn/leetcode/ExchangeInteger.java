package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-03 9:18 下午
 */
public class ExchangeInteger {
    public static void main(String[] args){
        int A = 2;
        int B = 3;
        System.out.println("main A的地址:" + System.identityHashCode(A));
        System.out.println("main B的地址:" + System.identityHashCode(B));
        swap(A,B);
        System.out.println("A:" + A +"\nB:" + B);
    }

    public static void swap(int A,int B){
        // 传递进来的是地址，由于这里对该地址的值进行任何操作，所以不会影响原值
        int C = A;
        System.out.println("swap C的地址:" + System.identityHashCode(C));
        B = C;
        System.out.println("swap B的地址:" + System.identityHashCode(B));
        A = B;
        System.out.println("swap A的地址:" + System.identityHashCode(A));
        System.out.println("swap A:" + A + " B:"+ B);
    }
}
