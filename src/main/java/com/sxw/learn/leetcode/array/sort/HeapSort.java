package com.sxw.learn.leetcode.array.sort;

import com.sxw.learn.leetcode.tree.TreeNode;
import com.sxw.learn.leetcode.tree.TreeNodeShow;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆排序
 * 堆的性质：
 * 左孩子：2 * i + 1
 * 右孩子：2 * i + 2
 * 父亲：i - 1 / 2
 * <p>
 * [1, 2, 3, 4, 5, 6, 7]
 * 1
 * /   \
 * 2       3
 * / \     / \
 * 4   5   6   7
 * <p>
 * - 堆结构就是用数组实现的完全二叉树结构
 * - 完全二叉树每棵子树的最大值都在顶部就是大根堆
 * - 完全二叉树每棵子树的最小值都在顶部就是小根堆
 * - 堆的经典操作：heapInsert和heapify
 * - 优先级队列结构，就是堆结构 -> PriorityQueue<Integer>
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {// heapInsert结束，当前堆就是大根堆，O(N)
            heapInsert(arr, i);// O(logN)
        }
        // 这个方式和上面的方式都是为了使数组变成大跟堆，这种方式会稍微快一点，是O(N)的时间复杂度
//        for (int i = arr.length - 1; i >= 0; i--){
//            heapify(arr, i, arr.length);
//        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);// 将顶部的最大元素移到末尾，并减少堆大小（目的是使剩下的元素参与heapify）
        while (heapSize > 0) {// O(N)
            heapify(arr, 0, heapSize);// O(logN)，将堆顶的元素往下移动，重新构建为大顶堆
            swap(arr, 0, --heapSize);// O(1)
        }

    }

    // 某个数现在处于index位置，往上移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
        // 左孩子的下标
        int left = 2 * index + 1;
        while (left < heapSize) {// 下方还有孩子
            // 两个孩子中，谁的值大，把下标给largest,目的是需要将较大的至上浮上去，因为这是大顶堆
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;// 父亲和较大的孩子比较，谁的值大，把下标给largest
            if (largest == index) {
                return;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 5, 6, 1, 3};
        heapSort(a);
        System.out.println(Arrays.toString(a));

        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // {1,2,3,4,5,6,7,8,9}
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        TreeNodeShow.show(node1);
    }
}
