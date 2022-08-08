package com.sxw.learn.leetcode.other;

import java.util.Stack;

/**
 * [题目]: 在数组中想找到一个数，左边和右边比这个数大、且离这个数最近的位置。
 * 如果对每一个数都想求这样的信息，能不能整体代价达到O(N)？
 * [解法]: 需要使用到单调栈结构
 * 整体逻辑：用一个栈辅助，栈里存着索引，对应的值是单调的，栈底到栈顶的元素从大到小排列。
 * 如果说stack.top<arr[i]，弹出此时的栈顶index = stack.pop()（记录下来作为某点index），然后它的右边最近比它大的数，就是arr[i]，
 * 左边最近的比它大的数，就是弹出它自身后，前面一个（也就是此时的栈顶，如果此时栈为空，说明左面没有比它小的数，返回-1）
 *
 * https://blog.csdn.net/e01528/article/details/86499605
 */
public class GetNearLess {
    // 无重复值的情况，有重复值的将栈中存储的元素处理为链表即可
    public static int[][] getNearMoreNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int popIndex = stack.pop();
                int leftMoreIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftMoreIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        // 扫尾阶段
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftMoreIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftMoreIndex;
            res[popIndex][1] = -1;//右边必然是0
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 6, 1, 2, 0};
        int[][] nearMoreNoRepeat = getNearMoreNoRepeat(arr);
        for (int i = 0; i < nearMoreNoRepeat.length; i++) {
            System.out.print("当前元素:" + arr[i] + ",对应结果下标:");
            printArray(nearMoreNoRepeat[i]);
        }
    }
}
