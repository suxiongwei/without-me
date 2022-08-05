package com.sxw.learn.leetcode.str;

/**
 * Manacher's Algorithm，中文名叫马拉车算法
 * 解决的问题是求最长回文子串，神奇之处在于将算法的时间复杂度精进到了O(N)
 * [算法由来]:
 * 在求解最长回文子串的问题时，一般的思路是以当前字符为中心，向其左右两边扩展寻找回文，但是这种解法的时间复杂度是O(N^2)，那么能不能将时间复杂度再降低一点？做到线性？马拉车算法就完美地解决了这个问题。
 * [预处理]:
 * 回文字符串以其长度来分，可以分为奇回文（其长度为奇数）、偶回文（其长度为偶数），一般情况下需要分两种情况来寻找回文，马拉车算法为了简化这一步，对原始字符串进行了处理，在每一个字符的左右两边都加上特殊字符，让字符串变成一个奇回文。例如：
 * 原字符串：abba，长度为4
 * 预处理后：#a#b#b#a#，长度为9
 *
 * 原字符串：aba，长度为3
 * 预处理后：#a#b#a#，长度为7
 *
 * [解法思路]:
 * R：回文区域的最右边界
 * C：当前回文区域的中间点
 * 伪代码如下：
 * for(int i = 0; i < str.length; i++){
 *     if(i在R的外部){
 *         从i开始往两边暴力扩，R变大
 *     }else{
 *         if(i`回文区域彻底在L..R内){
 *             pArr[i] = 某个O(1)的表达式
 *         }else if(i`回文区域有一部分在L..R外){
 *             pArr[i] = 某个O(1)的表达式
 *         }else{// i`回文区域和L..R的左边界压线
 *             从R之外的字符右扩，然后确定pArr的答案
 *             从第一步扩失败了，R不变
 *             从第一步成功了，R变大
 *         }
 *     }
 * }
 */
public class Manacher {
    public static char[] manacherString(String str){
        char[] charArray = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : charArray[index++];
        }
        return res;
    }

    // TODO


}
