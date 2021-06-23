package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-22 11:14 上午
 */
public class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = n - 1;
        while (l <= r){
            // 二分查找
            int mid = (l + r) >> 1;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[0]) {// mid 左边的有序
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {// mid 右边的有序
                if (target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int search1 = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(search1);
    }


}
