package com.sxw.learn.leetcode.array.sort;


/**
 * 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
            // 比如 L = 3，R = 5,需要生成的随机数为 3～5， 也就是 3 + （随机的0～2）, Math.random() 随机选取大于等于0.0且小于1.0的伪随机 double 值
            swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] partition = partition(arr, L, R);
            quickSort(arr, L, partition[0] - 1);
            quickSort(arr, partition[1] + 1, R);
        }
    }

    /**
     * 默认以arr[R]作为划分值
     * 返回等于区域(左边界和右边界)
     */
    public static int[] partition(int[] arr, int L, int R){
        // 小于区右边界
        int less = L - 1;
        // 大于区左边界，之所以不是R - 1,是因为最后一个数是需要比较的数字
        int more = R;
        while (L < more){
            if (arr[L] < arr[R]){// arr[L]表示
                swap(arr, ++less, L++);
            }else if (arr[L] > arr[R]){
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        // 将需要比较的数字放在合适的位置
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    /**
     * 交换两个元素的位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,3,5,6,1,3};
//        partition(a, 0, a.length - 1);
//        quickSort(a);
//        System.out.println(Arrays.toString(a));
    }
}
