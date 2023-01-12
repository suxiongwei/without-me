package com.sxw.learn.leetcode.array;

/**
 * [题目]: 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0; // 慢指针
        for (int j = 1; j < nums.length; j++) {// j 是快指针，如果遇到重复的，快指针往前走
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;// 因为快指针是从1开始的 而且至少也有一个
    }

    /**
     * 给你一个排序数组 nums，在逻辑上删除其中的重复元素，返回新的数组的长度 len，使得原数组 nums 的前 len 个元素中，每个数字最多出现两次。
     *
     * 如果一个数字出现超过2次，则这个数字最后保留两个。
     *
     * 1,1,1,2,2,3 -> 5
     */
    public static int removeDuplicates1(int[] nums) {
        int res = 0;
        if (nums == null) return res;
        int length = nums.length;
        if(length == 0) return res;
        // 去重后元素的下标
        int index = 0;
        // 当前元素出现的次数
        int count = 1;
        for (int i = 1; i < length; i++){
            // 和已有添加的数据做比较
            if (nums[i] == nums[index]){
                count++;
                if (count <= 2){
                    nums[++index] = nums[i];
                }
            }else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
//        int i = RemoveDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
//        System.out.println(i);
        int i = RemoveDuplicates.removeDuplicates1(new int[]{1,1,1,2,2,3});
        System.out.println(i);
    }
}
