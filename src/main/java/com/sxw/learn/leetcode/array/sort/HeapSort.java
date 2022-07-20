package com.sxw.learn.leetcode.array.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆排序
 * 堆的性质：
 * 左孩子：2 * i + 1
 * 右孩子：2 * i + 2
 * 父亲：i - 1 / 2
 *
 * - 堆结构就是用数组实现的完全二叉树结构
 * - 完全二叉树每棵子树的最大值都在顶部就是大根堆
 * - 完全二叉树每棵子树的最小值都在顶部就是小根堆
 * - 堆的经典操作：heapInsert和heapify
 * - 优先级队列结构，就是堆结构 -> PriorityQueue<Integer>
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (null == arr || arr.length < 2) return;
//        for (int i = 0; i < arr.length; i++) {// O(N)
//            heapInsert(arr, i);// O(logN)
//        }
        // 这个方式和上面的方式都是为了使数组变成大跟堆，这种方式会稍微快一点，是O(N)的时间复杂度
        for (int i = arr.length - 1; i >= 0; i--){
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){// O(N)
            heapify(arr, 0, heapSize);// O(logN)
            swap(arr, 0, --heapSize);// O(1)
        }

    }

    // 某个数现在处于index位置，往上移动
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize){
        // 左孩子的下标
        int left = 2 * index + 1;
        while (left < heapSize){// 下方还有孩子
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;// 两个孩子中，谁的值大，把下标给largest,目的是需要将较大的至上浮上去，因为这是大顶堆
            largest = arr[largest] > arr[index] ? largest : index;// 父亲和较大的孩子比较，谁的值大，把下标给largest
            if (largest == index){
                return;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,3,5,6,1,3};
        heapSort(a);
        System.out.println(Arrays.toString(a));

        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    }
}
