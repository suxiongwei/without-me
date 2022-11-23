package com.sxw.learn.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * [题目]: 最大交换(670)
 * [题目描述]:
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * [解题思路]:
 * 将大的数放置在高位，而当有数值相同的多个大数时，我们应当选择低位的数字。
 * 使用idx数组，带来代指 num 后缀中最大值对应的下标
 * <p>
 * https://leetcode.cn/problems/maximum-swap/solutions/1820215/by-ac_oier-jxmh/
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {// 将数字的每一位拆分，加入到list，如2736 -> list {6, 3, 7, 2}
            list.add(num % 10);
            num /= 10;
        }
        int n = list.size(), ans = 0;
        int[] idx = new int[n];// 如2736 -> idx {0,0,2,2},可以看到此时是按照低位到高位来填充最大值位置的，因为在list中顺序已经颠倒了
        int curMaxNumIndex = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > list.get(curMaxNumIndex)) {// 当有数值相同的多个大数时，我们应当选择低位的数字，也就是这里的严格大于
                curMaxNumIndex = i;// 更新最大index的值
            }
            idx[i] = curMaxNumIndex;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(idx[i]) != list.get(i)) {
                int c = list.get(idx[i]);// 根据下标找到那个最大的数
                list.set(idx[i], list.get(i));// 交换数据
                list.set(i, c);// 交换数据
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {// 恢复出调整后的数据
            ans = ans * 10 + list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSwap solution = new MaximumSwap();
        int i = solution.maximumSwap(2736);
        System.out.println(i);
    }
}
