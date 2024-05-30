package com.sxw.learn.leetcode;

public class Sushu {
    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];// false代表素数
        int count = 0;
        for (int i = 2; i < n; i++){
            if (!isPrime[i]){
                count++;
                // 每次都递增i，也就是从i的倍数逐渐递增，所以逐渐翻倍的数一定是合数
                for (int j = 2 * i; j < n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int eratosthenes = eratosthenes(100);
        System.out.println(eratosthenes);
    }
}
