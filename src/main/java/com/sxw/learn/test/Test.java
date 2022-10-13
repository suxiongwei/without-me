package com.sxw.learn.test;

import com.google.common.base.Joiner;

import java.util.*;

public class Test {
    public static List<List<Integer>> res = new ArrayList();

    public static List<List<Integer>> getResult(int[] nums, int target){
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        process(nums, target, nums.length, 0, new ArrayDeque<>());
        return res;
    }

    public static void process(int[] nums, int target, int len, int begin, Deque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new LinkedList(path));
            return;
        }
        for(int i = begin; i < len; i++){
            if(target - nums[i] < 0) break;
            path.addLast(nums[i]);
            process(nums, target - nums[i], len, i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
//        System.out.println("hello world");
        Test main = new Test();
        int[] nums = {2,2,2,2,2};
        main.getResult(nums, 8);
        res.forEach(i -> System.out.println(Joiner.on(",").join(i)));
    }

}
