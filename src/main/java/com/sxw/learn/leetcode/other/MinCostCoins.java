package com.sxw.learn.leetcode.other;

/**
 * [题目]: 土豪打榜
 * [题目描述]:
 * CC里面有一个土豪很喜欢一位女直播Kiki唱歌，平时就经常给她点赞、送礼、私聊。最近CC直播平台在举行中秋之星主播唱歌比赛，
 * 假设一开始该女主播的初始人气值为start， 能够晋升下一轮人气需要刚好达到end，
 * 土豪给主播增加人气的可以采取的方法有：
 * a. 点赞 花费x C币，人气 + 2
 * b. 送礼 花费y C币，人气 * 2
 * c. 私聊 花费z C币，人气 - 2
 * 其中 end 远大于start且end为偶数， 请写一个程序帮助土豪计算一下，最少花费多少C币就能帮助该主播
 * Kiki将人气刚好达到end，从而能够晋级下一轮？
 * 输入描述：
 * 第一行输入5个数据，分别为：x y z start end，每项数据以空格分开。
 * 其中：0＜x, y, z＜＝10000， 0＜start, end＜＝1000000
 * 输出描述：
 * 需要花费的最少C币。
 * 示例1:
 * 输入
 * 3 100 1 2 6
 * 输出
 * 6
 *
 * [解题思路]:
 * 递归
 * 递归需要有base case结束递归，这里已知的一个结束条件是base case4，但是只有这个的话，递归不会结束
 * 因此需要自己找出别的base case，也就是找频繁解
 *
 * 解题技巧：在递归限制条件不够的时候使用
 * 找出频繁解
 *
 * 消耗币最多的方式就是点赞，这样的话币的上限：((end - start) / 2) * add
 */
public class MinCostCoins {
    //start偶数，end偶数  start<=end
    public static int minCoins(int add, int times, int del, int start, int end) {
        if (start > end) {
            return -1;
        }
        return process(0, start, end, add, times, del, ((end - start) / 2) * add);
    }

    /**
     * start 人气向 end 改变
     *
     * @param cost      之前已经花了多少钱【可变】
     * @param start     起始人气【可变】
     * @param end       目标人气 【固定】
     * @param add       点赞花费 C 币 【固定】
     * @param times     送礼花费 C 币 【固定】
     * @param del       私聊花费 C 币 【固定】
     * @param limitCoin 已经使用的币大到什么程度不需要再尝试了 【固定】
     * @return
     */
    public static int process(int cost, int start, int end, int add, int times, int del, int limitCoin) {
        // base case 1
        if (cost > limitCoin) {
            return Integer.MAX_VALUE;
        }
        // base case 2
        if (start < 0) {
            return Integer.MAX_VALUE;
        }
        // base case 3
        if (start > (2 * end)) {
            return Integer.MAX_VALUE;
        }
        // base case 4
        if (start == end) {
            return cost;
        }
        int min = Integer.MAX_VALUE;
        //让人气-2的方式
        int p1 = process(cost + add, start + 2, end, add, times, del, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        //让人气+2的方式
        int p2 = process(cost + del, start - 2, end, add, times, del, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        //让人气*2的方式
        int p3 = process(cost + times, start * 2, end, add, times, del, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }

    public static void main(String[] args) {
        int add = 6;
        int times = 5;
        int del = 1;
        int start = 10;
        int end = 30;
        System.out.println(minCoins(add, times, del, start, end));
    }

}
