package com.sxw.learn.leetcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * [题目]: 连续数组(525)
 * [题目描述]:
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * [解题思路]:
 * 前缀和 + Hash
 * <p>
 * 由于「0 和 1 的数量相同」等价于「1 的数量减去 0 的数量等于 0」，我们可以将数组中的0 视作−1，则原问题转换成「求最长的连续子数组，其元素和为 0」。
 * 当 prefixSums[k]−prefixSums[j]=0 时，即得到 newNums的一个长度为 k−j的子数组元素和为0
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        // 将0处理为-1，是为了兼容前缀和的逻辑匹配
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        int maxLength = 0;
        // 定义截止到当前位置到前缀和
        int curSum = 0;
        // 哈希表存储的是 curSum的每个取值第一次出现的下标
        Map<Integer, Integer> hash = new HashMap<>();
        // 规定空的前缀的结束下标为−1，空的前缀的元素和为0
        hash.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curSum = curSum + nums[i];
            if (hash.containsKey(curSum)) {
                int prevIndex = hash.get(curSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                hash.put(curSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        FindMaxLength solution = new FindMaxLength();
        int[] arr = {0, 1, 0};
        int maxLength = solution.findMaxLength(arr);
        System.out.println(maxLength);
    }
}
