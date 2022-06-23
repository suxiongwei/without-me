package com.sxw.learn.sync;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedDemo {
    /**
     * 利用JOL学习对象内存布局
     * https://www.cnblogs.com/hongdada/p/14087177.html
     */
    public static void objectSizeLearn(){
        Object o = new Object();
        System.out.println(o.hashCode());

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        /**
         * 输出结果：
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
         *   8   4        (object header: class)    0xf80001e5
         *  12   4        (object alignment gap)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         *
         * 结果分析：
         * 对象存储由三部分组成：
         * - 对象头：由Mark Word和类型指针组成，以上结果对象头的 mark+class=12 ，填充四位，所以此时object对象头共占十六个字节
         *   Mark Word用于存储对象自身的运行时数据，如哈希码（HashCode）、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等等。
         *   Mark Word被设计成一个非固定的数据结构以便在极小的空间内存储尽量多的信息，它会根据对象的状态复用自己的存储空间。
         * - 实例数据
         * - 对齐填充
         */
    }

    /**
     * 学习synchronized
     * https://www.cnblogs.com/hongdada/p/14087177.html
     */
    public static void synchronizedLearn(){
        /**
         * Java对象的锁状态一共有四种，级别从低到高依次为: 无锁(01) -> 偏向锁(01) -> 轻量级锁(00) -> 重量级锁(10).
         *
         * 偏向锁:
         * Java15 开始废弃偏向锁
         * 引入偏向锁的主要原因是，经过研究发现，在大多数情况下，锁不仅不存在多线程竞争，而且总是由同一线程多次获得，
         * 因此为了减少同一线程获取锁(会涉及到一些CAS操作,耗时)的代价而引入偏向锁。
         *
         * 轻量级锁:
         * 引入轻量级锁的主要原因是，对绝大部分的锁，在整个同步周期内都不存在竞争，可能是交替获取锁然后执行。
         * (与偏向锁的区别是，引入偏向锁是假设同一个锁都是由同一线程多次获得，而轻量级锁是假设同一个锁是由n个线程交替获得；相同点是都是假设不存在多线程竞争)
         *
         * 重量级锁:
         * 如果存在多个线程同一时间访问同一锁的场合，就会导致轻量级锁膨胀为重量级锁。
         * 开销大：从用户态转化到内核态
         *
         */
    }

    public static void main(String[] args) {
        SynchronizedDemo.objectSizeLearn();
        System.out.println(103478837.36 + 607248.00);
    }
}
