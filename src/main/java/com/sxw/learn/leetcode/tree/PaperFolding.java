package com.sxw.learn.leetcode.tree;

/**
 * [题目]：折纸问题
 * [题目描述]：
 * 请把一张纸条竖着放在桌子上，然后从纸条的下方向上对折一次，压出折痕后展开。
 * 此时折痕是凹下去的，即折痕凸起的方向指向纸条的背面
 * 如果从纸条的下方连续向上对折两次，压出折痕后展开，此时有三条折痕，从上到下依次为凹、凹、凸
 *
 * 给定一个参数N，代表纸条都从下往上对折N次
 * 请从上至下打印折痕的方向
 *
 * 例：N=1 时 打印 凹
 *    N=2 时 打印 凹 凹 凸
 *    N=3 时 打印 凹 凹 凸 凹 凹 凸 凸
 *
 * [题目分析]：
 * N = 3的情况
 * 从上到下的折痕方向：
 * 3凹 2凹 3凸 1凹 3凹 2凸 3凸 数字代表第几次的折痕
 * 可以发现刚好是一颗二叉树,左节点是凹，右节点是凸，所以最终结果的打印就是二叉树的中序遍历
 * 1凹 left: 2凹 right:2凸
 * 2凹 left: 3凹 right:3凸
 * 2凸 left: 3凹 right:3凸
 *
 */
public class PaperFolding {
    // 打印所有折痕
    public static void printAllFolds(int n){
        printProcess(1, n, true);
    }

    // i代表当前来到了哪一层,递归过程模拟了一颗并不存在的树
    public static void printProcess(int i, int n, boolean down){
        if (i > n) return;
        printProcess(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
