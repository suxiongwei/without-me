package com.sxw.learn.leetcode;


import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-20 3:56 下午
 */
public class SpiralOrder {

    public List<Integer> solution(int[][] matrix){
        if (matrix.length == 0){
            return Lists.newArrayList();
        }
        List<Integer> result = Lists.newArrayList();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        int x = 0;
        int y = 0;
        while (avoid(left, right, up, down)){
            y = left;
            while (y <= right && avoid(left, right, up, down)){
                result.add(matrix[x][y]);
                y++;
            }
            y--;
            up++;

            x = up;
            while (x <= down && avoid(left, right, up, down)){
                result.add(matrix[x][y]);
                x++;
            }

            x--;
            right--;

            y = right;
            while (y >= left && avoid(left, right, up, down)){
                result.add(matrix[x][y]);
                y--;
            }

            y++;
            down--;

            x = down;
            while (x >= up && avoid(left, right, up, down)){
                result.add(matrix[x][y]);
                x--;
            }
            x++;
            left++;
        }
        return result;
    }

    private boolean avoid(int left, int right, int up, int down){
        return left <= right && down >= up;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> result = spiralOrder.solution(matrix);
        System.out.println(result);
    }
}
