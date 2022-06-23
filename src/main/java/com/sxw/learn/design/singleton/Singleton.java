package com.sxw.learn.design.singleton;

/**
 * DCL双端锁
 */
public class Singleton {
    private static volatile Singleton singleton;

    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    /**
                     * 不加volatile的话，多线程环境下，由于重排序,该对象可能还未完成初始化就被别的线程读取到
                     * 正常情况下：
                     * 1、memory = allocate(); // 分配对象的内存空间
                     * 2、ctorInstance(memory); // 初始化对象
                     * 3、instance = memory(); // 设置instance指向刚分配的内存地址
                     *
                     * 由于指令重排序，2，3可能颠倒，这样的话就会读取到未完全初始化的对象
                     */
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
