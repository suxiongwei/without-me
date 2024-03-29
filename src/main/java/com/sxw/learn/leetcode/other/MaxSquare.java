package com.sxw.learn.leetcode.other;
/**
 * [题目]:
 * 给定一个N*N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度。
 * 例如：
 * 0  1  1  1  1
 * 0  1  0  0  1
 * 0  1  0  0  1
 * 0  1  1  1  1
 * 0  1  0  1  1
 * 其中边框全是1的最大正方形的大小为4*4，return 4。
 * [题目分析]:思路：
 * 方法一：
 * 1.矩阵中一共有N*N个位置。O(N^2)
 * 2.对每一个位置都可以成为边长为N~1的正方形左上角。比如，对于(0,0)位置，依次检查是否是边长为5的正方形的左上角，然后检查边长为4、3等。O(N)
 * 3.如何检查一个位置是否可以成为边长为N的正方形的左上角？遍历这个边长为N的正方形边界看是否只由1组成，也就是走过四个边的长度(4N)。O(N)
 * 总的时间复杂度：O(N^2)*O(N)*O(N)=O(N^4)
 *
 * 方法二：
 * 时间复杂度为O(N^3)
 * 1.预处理过程是根据matrix得到两个矩阵right和down，right[i][j]的值表示从位置(i,j)向右出发有多少个连续的1。down[i][j]的值表示从位置(i,j)向下出发有多少个连续的1。
 * [解题思路]: 预处理法
 * 使用方法二，利用预处理的方式降低时间复杂度
 */
public class MaxSquare {
}
