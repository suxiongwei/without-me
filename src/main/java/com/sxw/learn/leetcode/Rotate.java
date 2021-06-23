package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-04-12 4:31 下午
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int length = nums.length;
        k = k % length; // 数组length = 5 k = 7 实际上含义是k = 2
        reverseArray(nums, 0, length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, length - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}
