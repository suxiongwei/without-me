package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-07 2:17 下午
 */
public class MySqrt {
    public int sqrt(int x){
        if (x == 0) return 0;
        long left = 1;
        long right = x >> 1;
        while (left < right){
            long mid = ((left + right) >> 1) + 1;// 先算数运算符 后位移运算符
            if (mid > x / mid){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        MySqrt solution = new MySqrt();
        int sqrt = solution.sqrt(10);
        System.out.println(sqrt);
    }
}
