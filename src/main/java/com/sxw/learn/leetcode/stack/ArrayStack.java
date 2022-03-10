package com.sxw.learn.leetcode.stack;

/**
 *  用数组实现栈
 *  顺序栈：用数组实现的栈
 *  链式栈：用链表实现的栈
 *
 *  空间复杂度 为O(1),这里存储数据需要一个大小为 n 的数组，并不是说空间复杂度就是 O(n)。
 *  因为，这 n 个空间是必须的，无法省掉。所以我们说空间复杂度的时候，是指除了原本的数据存储空间外，算法运行还需要额外的存储空间。
 *
 *  时间复杂度都是 O(1)
 *
 *  当进一步修改为 动态扩容的顺序栈 时，在push元素时，如果空间不够，需要扩容，此时空间复杂度为O(n)
 *  也就是说，对于入栈操作来说，最好情况时间复杂度是 O(1)，最坏情况时间复杂度是 O(n)。
 */
public class ArrayStack {
    /**
     * 数组来存储元素
     */
    private String[] items;
    /**
     * 栈的深度，即数组的大小
     */
    private int n;
    /**
     * 栈中元素个数
     */
    private int count;

    public ArrayStack(int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    private boolean push(String item){
        // 数组空间不够了，直接返回false，入栈失败
        if (count == n) return false;
        items[count++] = item;
        return true;
    }

    /**
     * 出栈操作
     * @return
     */
    private String pop(){
        if (count == 0) return null;
        String result = items[count - 1];
        count --;
        return result;
    }
}
