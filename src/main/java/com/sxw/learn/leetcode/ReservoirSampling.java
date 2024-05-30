package com.sxw.learn.leetcode;

import java.util.Random;


/**
 * 蓄水池算法
 * https://blog.csdn.net/anshuai_aw1/article/details/88750673
 */
public class ReservoirSampling {
    private static int[] pool; // 所有数据
    private static final int N = 100000; // 数据规模
    private static Random random = new Random();

    public static void setUp() {
        // 初始化
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }

    private static int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) { // 前 K 个元素直接放入数组中
            result[i] = pool[i];
        }

        for (int i = K; i < N; i++) { // K + 1 个元素开始进行概率采样
            int rand = random.nextInt(i + 1);
            /**
             * 这里其实就是k/j的体现
             * case: i = k + 1
             * 被替换的数据(小于k的)，每个被随机选中的概率是 1 / k，当前 k + 1 要被选中去执行替换的概率 k / k + 1
             * 即对于k中的某个元素被替换的概率 1 / k * k / k + 1 = 1 / k + 1
             * 即不被替换的概率 1 - 1 / k + 1 = k / k + 1
             *
             * case: i = k + 2
             * 被替换的数据(小于k的)，每个被随机选中的概率是 1 / k，当前 k + 2 要被选中去执行替换的概率 k / k + 2
             * 即对于k中的某个元素被替换的概率 1 / k * k / k + 2 = 1 / k + 2
             * 即不被替换的概率 1 - 1 / k + 2 = k + 1 / k + 2
             *
             * 最终 循环完，执行相乘后
             * 1 * k / k + 1 * k + 1 / k + 2 * ... * n - 1 / n = k / n
             */
            if (rand < K) { // k / n 包含了 选中 k中元素的概率，即 1 / k, 又包含了当前元素去替换的概率 k / k + 1
                result[rand] = pool[i];
            }
        }

        return result;
    }

    // 蓄水池算法的类似题目
    /**
     * 给定一个字符串 abcdabgh，给个字符 a，随机返回 a 下标，比如这个是 0 4。要求返回的概率必须一样，空间复杂度要求 O1 即不能开任何空间存储下标，并且只能遍历一次。
     */
    public static int randomIndex(String str, char target) {
        char[] chars = str.toCharArray();
        int count = 0;
        int result = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target){
                count++;
                int rand = random.nextInt();
                if (rand == 0){
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        setUp();
        for (int i : sampling(100)) {
            System.out.println(i);
        }
    }
}
