package com.sxw.learn.leetcode.dp;

import java.util.Arrays;

/**
 * 486. 预测赢家
 * 给你一个整数数组 nums。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 * <p>
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 * <p>
 * 如果玩家 1 能成为赢家，返回 true。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true。你可以假设每个玩家的玩法都会使他的分数最大化。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5。
 * 因此，玩家 1 永远不会成为赢家，返回 false。
 * <p>
 * 示例 2：
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 解释：玩家 1 一开始选择 1。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。
 */
public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 先手取得的分数
        int first = calScore(nums, 0, nums.length - 1);
        if (first >= sum - first){
            return true;
        }
        return false;
    }

    /**
     * 递归函数，用户在当前的数字范围内能获取到的最大分数
     */
    public static int calScore(int[] nums, int start, int end) {
        // 递归就是找到一个程序的出口，然后判断所有可能出现的情况，然后选择最优解
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {// 判断这个是为了防止数组越界，因为下面需要进行 index - 2的操作
            return Math.max(nums[start], nums[end]);
        } else { // end - start > 1
            // 当前选了左边的数，那么后手一定回留给先手小的那个数
            int selectLeft = nums[start] + Math.min(calScore(nums, start + 2, end), calScore(nums, start + 1, end - 1));
            int selectRight = nums[end] + Math.min(calScore(nums, start + 1, end - 1), calScore(nums, start, end - 2));
            return Math.max(selectLeft, selectRight);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        int score = calScore(nums, 0, nums.length - 1);
        System.out.println(score);
    }
}
