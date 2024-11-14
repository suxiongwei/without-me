package com.sxw.learn.base;

/**
 * 在 JAVA 语言中有8中基本类型和一种比较特殊的类型String。这些类型为了使他们在运行过程中速度更快，更节省内存，都提供了一种常量池的概念。常量池就类似一个JAVA系统级别提供的缓存。
 *
 * 8种基本类型的常量池都是系统协调的，String类型的常量池比较特殊。它的主要使用方法有两种：
 *
 * 直接使用双引号声明出来的String对象会直接存储在常量池中。
 * 如果不是用双引号声明的String对象，可以使用String提供的intern方法。intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
 */
public class TestIntern {
    public static void main(String[] args) {
        String s1 = "abc";
//        String s1 = new String("abc");
        String s2 = s1.intern();
        System.out.println(s1 == s2);// true

        String s3 = new String("def");
        String s4 = s3.intern();
        System.out.println(s3 == s4);// false

        String s5 = "abc";
        System.out.println(s1 == s5);// true

        String s6 = new String("def");
        System.out.println(s3 == s6);// false


    }
}
