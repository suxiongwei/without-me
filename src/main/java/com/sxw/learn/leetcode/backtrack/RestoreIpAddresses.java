package com.sxw.learn.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [题目]: 复原IP地址(93)
 * [题目描述]:
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是有效IP地址，但是"0.011.255.245"、"192.168.1.312"和"192.168@1.1"是无效IP地址。
 * 给定一个只包含数字的字符串s，用以表示一个IP地址，返回所有可能的有效IP地址，这些地址可以通过在s中插入'.'来形成。你不能重新排序或删除s中的任何数字。你可以按任何顺序返回答案。
 * [解题思路]:
 * 递归 + 回溯
 */
public class RestoreIpAddresses {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];// 在回溯的时候，不需要手动对已设置位置的值清除，因为在后续的递归中会将之前设置的值覆盖掉

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    // 表示从segStart位置开始找第segId段
    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
                System.out.println("已经找到了四段IP地址,segments:" + Arrays.toString(segments));
                return;
            }else {
                System.out.println("已经找到了四段IP地址,但是不是正确答案,segStart:" + segStart + ",segments" + Arrays.toString(segments));
                return;
            }
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            System.out.println("还没有找到4段IP地址就已经遍历完了字符串,那么提前回溯");
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            System.out.println("当前数字为0,直接赋值,进入下一轮递归:segStart=" + segStart + ",segments" + Arrays.toString(segments));
            dfs(s, segId + 1, segStart + 1);
            System.out.println("当前数字为0,退出递归:segStart=" + segStart + ",segments" + Arrays.toString(segments));
            return;// 提前结束回溯，不需要走下面的一般情况，这不加return就需要在下面的add判断中加上 addr > 0
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr <= 255) {
                segments[segId] = addr;
                System.out.println("一般情况,枚举每一种可能性并递归,进入下一轮递归:segStart=" + segEnd + ",segments" + Arrays.toString(segments));
                dfs(s, segId + 1, segEnd + 1);
                System.out.println("一般情况,枚举每一种可能性并递归,退出递归:segStart=" + segEnd + ",segments" + Arrays.toString(segments));
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        RestoreIpAddresses solution = new RestoreIpAddresses();
        solution.restoreIpAddresses("25525511135");
    }
}
