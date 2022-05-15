package com.sxw.learn.thread;

public class InheritableThreadLocalTest {
    /**
     * 京东一面：子线程如何获取父线程 ThreadLocal 的值？
     * https://mp.weixin.qq.com/s/NvbhVUf262tfeZ3lKY865A
     * @param args
     */
    public static void main(String[] args) {
        Thread parentThread = new Thread(() -> {
            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            threadLocal.set(1);

            InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
            inheritableThreadLocal.set(2);

            // 创建子线程
            new Thread(() -> {
                System.out.println("父线程threadLocal的值" + threadLocal.get());
                System.out.println("父线程inheritableThreadLocal的值" + inheritableThreadLocal.get());
                /**
                 * 输出结果：
                 * 父线程threadLocal的值null
                 * 父线程inheritableThreadLocal的值2
                 * 跟进 new Thread() 方法，其构造方法调用了init方法, init方法把inheritThreadLocals值设置为了true
                 *
                 * 核心代码如下：
                 * 当inheritThreadLocals的值为true并且其父线程的inheritableThreadLocals不为null时,
                 * 把其父线程inheritableThreadLocals 赋值给当前线程的inheritableThreadLocals
                 * if (inheritThreadLocals && parent.inheritableThreadLocals != null)
                 *             this.inheritableThreadLocals =
                 *                 ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);
                 */
            }).start();
        }, "父线程");
        parentThread.start();
    }
}
