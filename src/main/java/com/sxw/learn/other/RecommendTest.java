package com.sxw.learn.other;

public class RecommendTest {
    // https://github.com/truedei/recommenderSystem

    /**
     * 余弦相似度
     *
     * @param o1
     * @param o2
     * @return
     */
    private static Double compare(int[] o1, int[] o2) {
        //分子求和
        Double fenzi = 0.0;

        for (int i = 0; i < o1.length; i++) {
            fenzi += o1[i] * o2[i];
        }

        //分母第一部分
        Double fenmu1 = 0.0;
        for (int i = 0; i < o1.length; i++) {
            fenmu1 += o1[i] * o1[i];
        }

        fenmu1 = Math.sqrt(fenmu1);

        //分母第二部分
        Double fenmu2 = 0.0;
        for (int i = 0; i < o2.length; i++) {
            fenmu2 += o2[i] * o2[i];
        }
        fenmu2 = Math.sqrt(fenmu2);

        return fenzi / (fenmu1 * fenmu2);
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7};
        int[] y = {1,2,3,4,5,6,7};
        int[] z = {1,5,6,7,8,9,0};
        System.out.println(compare(x, z));
        System.out.println(compare(x, y));
    }

}
