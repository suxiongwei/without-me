package com.sxw.learn.leetcode.other;

/**
 * [题目]: 用 Rand7() 实现 Rand10()
 * [题目描述]:
 * 给定方法rand7可生成 [1,7] 范围内的均匀随机整数，试写一个方法rand10生成 [1,10] 范围内的均匀随机整数。
 * 你只能调用rand7()且不能调用其他方法。请不要使用系统的Math.random()方法。
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 *
 * [解题思路]:
 * 先加工出0、1随机函数再进一步求解
 */
public class Rand10 {
    public int rand10() {
        // 2 ^ 4 =  16
        int res;
        do {
            res = (rand01() << 3) + (rand01() << 2) + (rand01() << 1) + rand01();
        }while (res >= 10);
        return res + 1;
    }

    public int rand01(){
        int res;
        do {
            res = rand7();
        }while (res == 7);
        return res < 4 ? 0 : 1;
    }

    public int rand7(){
        return (int) (Math.random() * 7);
    }

    public static void main(String[] args) {
        Rand10 solution = new Rand10();
        System.out.println(solution.rand10());
    }

}
