package com.sxw.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-10 5:29 下午
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap();
        for (int left = 0, right = 0; right < n; right++){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)));
            }
            result = Math.max(result, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int s = solution.lengthOfLongestSubstring("abccbcbb");
        System.out.println(s);
    }
}
