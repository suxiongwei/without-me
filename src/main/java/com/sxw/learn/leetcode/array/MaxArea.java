package com.sxw.learn.leetcode.array;

/**
 * [题目]: 盛最多水的容器(11)
 * [题目描述]:
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * [解题思路]:
 * 双指针
 *
 * 设两指针 i , j ，指向的水槽板高度分别为 h[i], h[j]，此状态下水槽面积为 S(i,j)。由于可容纳水的高度由两板中的 短板 决定
 * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1 变短：
 *
 * 若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
 * 若向内 移动长板 ，水槽的短板 min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
 * 因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
 */
public class MaxArea {
    public static int solution(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]){
                res = Math.max(res, (right - left) * height[left]);
                left++;
            }else {// 如果是两个板相同，移动哪一个读可以，因为移动后产生的结果都不会比当前大，因为移动后最高的板也就是目前高度，而移动后宽度还变小了
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(MaxArea.solution(arr));
    }
}
