package com.sxw.learn.leetcode;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-02-03 10:52 下午
 */
public class TestIntegerTransmit {
    public static void add(Integer i){
        System.out.println("add i赋值前的地址:" + System.identityHashCode(i));
        i = 1212;
        System.out.println("add i赋值后的值:" + i);
        System.out.println("add i赋值后的地址:" + System.identityHashCode(i));

    }

    public static void main(String[] args) {
        Integer a = 1111;
        System.out.println("a赋值前的地址:" + System.identityHashCode(a));
        add(a);
        System.out.println("main add 后的值:"+ a);
        System.out.println("main a赋值前的地址:" + System.identityHashCode(a));
        a = 1213;
        System.out.println("main a修改值后的地址:" + System.identityHashCode(a));
        System.out.println("main a修改值后的值:" + a);
    }
}
