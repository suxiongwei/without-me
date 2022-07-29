package com.sxw.learn.leetcode.stack;

import java.util.Stack;

/**
 * [题目]：在不使用额外数据结构的情况下逆序栈
 * [题目描述]:只能使用递归函数
 */
public class ReverseStack {
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int i = f(stack);// 依次返回1、2、3
        reverse(stack);
        stack.push(i);// 到达栈底的时候，3最先压栈，其次2，其次1
    }


    // 移除并返回栈底元素
    public static int f(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = f(stack);
            stack.push(result);
            return last;// last是层层往上抛
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);// 栈底元素为 1
        stack.add(2);
        stack.add(3);
//        int f = f(stack);
//        System.out.println("栈底元素为:" + f);
//        System.out.println("逆序栈前的结果");
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
        reverse(stack);
        System.out.println("逆序栈后的结果");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
