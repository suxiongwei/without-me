package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-05 5:08 下午
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (canEat(piles, mid, H)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 以当前的速度吃 是否超过了最大限制时间H
     *
     * @param piles
     * @param speed
     * @param H
     * @return
     */
    private boolean canEat(int[] piles, int speed, int H) {
        int sum = 0;
        for (int pile : piles) {
            // //向上取整
            sum += Math.ceil(pile * 1.0 / speed);
        }
        return sum > H;
    }

    public static void main(String[] args) {
        MinEatingSpeed solution = new MinEatingSpeed();
        int i = solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        System.out.println(i);
    }
}
