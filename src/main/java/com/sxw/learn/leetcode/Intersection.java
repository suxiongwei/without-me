package com.sxw.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-16 4:46 下午
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set nums1Set = new HashSet();
        Set nums2Set = new HashSet();
        for (int i : nums1) nums1Set.add(i);
        for (int i : nums2) nums2Set.add(i);
        return getIntersection(nums1Set, nums2Set);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) getIntersection(set2, set1);
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (Integer i : set1) if (set2.contains(i)) intersectionSet.add(i);
        int[] res = new int[intersectionSet.size()];
        int j = 0;
        for (Integer i : intersectionSet) res[j++] = i;
        return res;
    }
}
