package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-03-09 5:13 下午
 */
public class MaxArea {
    public static int solution(int[] height){
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            // 注意(right - left) 需要放在表达式的前面
            // 如果height[left++]放在前面 那么在后面的right - left时 此时left已经被更改了
            res = height[left] < height[right] ? Math.max(res,(right - left) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(MaxArea.solution(arr));
    }
}
