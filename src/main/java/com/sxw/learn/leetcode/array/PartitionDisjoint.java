package com.sxw.learn.leetcode.array;

/**
 * [题目]: 分割数组(915)
 * [题目描述]:
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * 用例可以保证存在这样的划分方法。
 *
 * [解题思路]:
 * 一次遍历
 * 通过记录遍历过程中到当前位置的最大元素curMax，更新分界线的位置
 */
public class PartitionDisjoint {
    // case1: [5,0,3,8,6] -> 5,0,3 / 8,6
    // case2: [1,1,1,0,6,12] -> 1,1,1,0 / 6,12
    public int PartitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0];// left分界线左边的最大元素
        int leftPos = 0;// left分界线
        int curMax = nums[0];// 当前最大元素，会随着遍历不断更新，而leftMax在到了划分边界后，就固定下来了
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {// 意味着 leftPos 作为划分位置是非法的，需要更新 leftPos = i
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;// 返回的是左边的元素数量，因此需要在下标的基础上加一
    }
}
