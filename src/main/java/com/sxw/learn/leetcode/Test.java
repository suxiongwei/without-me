package com.sxw.learn.leetcode;

import com.google.common.collect.Lists;
import com.sxw.learn.leetcode.linkedlist.ListNode;

import java.util.*;

public class Test {

    public static List<String> solution(int[] nums){
        List<String> res = new ArrayList();
        if(nums == null || nums.length == 0){
            return res;
        }
        int curIndex = 0;
        int len = nums.length;
        while(curIndex < len){
            int beginIndex = curIndex;
            // 下一个数和当前数是连续的，指针会走到下一个数
            while(curIndex < len - 1 && nums[curIndex + 1] == (nums[curIndex] + 1)){
                curIndex++;
            }

            if(curIndex - beginIndex <= 1){
                for(int i = beginIndex; i <= curIndex; i++){
                    res.add(nums[i] + "");
                }
            }else {
                res.add(nums[beginIndex] + "-" + nums[curIndex]);
            }
            curIndex++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12,13,15,16,17};
        List<String> res = solution(nums);
        for(int i = 0; i < res.size(); i++){
             System.out.println(res.get(i));
        }
    }
}
