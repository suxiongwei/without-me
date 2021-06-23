package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-07 3:20 下午
 */
public class FindMin {
    // private int findMin(int[] arr){
    //     int left = 0;
    //     int right = arr.length - 1;
    //     while (left < right){
    //         int mid = ((right + left) >> 1) + 1;
    //         if (arr[mid] > arr[left]){
    //             left = mid;
    //         }else {
    //             right = mid - 1;
    //         }
    //     }
    //     return arr[(right + 1) % arr.length];
    // }

    public static void main(String[] args) {
        FindMin solution = new FindMin();
        // int min = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        int min = solution.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

}
