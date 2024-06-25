package com.sxw.learn;

import com.sxw.learn.leetcode.linkedlist.ListNode;
import com.sxw.learn.leetcode.tree.TreeNode;
import lombok.SneakyThrows;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private Object lock;
    private volatile int TOTAL_NUM = 10;
    private volatile int NUM = 1;

    public class Task implements Runnable{
        @SneakyThrows
        @Override
        public void run() {
            while (NUM <= TOTAL_NUM){
                synchronized(lock){
                    System.out.println(NUM);
                    NUM++;
                    lock.notify();

                    if (NUM <= TOTAL_NUM){
                        lock.wait();
                    }
                }
            }
        }
    }


}
