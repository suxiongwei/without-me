package com.sxw.learn.thread;

public class ThreadLocalDemo {
    public static void function(){
        // 新建了一个ThreadLocal对象，t1强引用此对象
        ThreadLocal<String> t1 = new ThreadLocal<>();
        /**
         * 调用set方法，新建了一个Entry，通过源码可知Entry的key是弱引用指向这个对象
         * static class Entry extends WeakReference<ThreadLocal<?>> {
         *   Object value;
         *
         *   Entry(ThreadLocal<?> k, Object v) {
         *      super(k);
         *      value = v;
         *   }
         * }
         * 此时 key:t1 value:sxw@126.com
         */
        t1.set("sxw@126.com");
        t1.get();

        /**
         * ThreadLocalMap:
         * 保存ThreadLocal对象的map(以ThreadLocal为key)，不过是经过了两次包装的ThreadLocal对象
         * 1、第一层是经过WeakReference将ThreadLocal对象变成一个弱引用的对象
         * 2、第二层是定义Entry来扩展WeakReference<ThreadLocal<?>>
         *
         * 为什么源代码用弱引用？
         * 当function执行完毕，栈帧销毁，强引用t1也就不存在了。
         * 但此时线程ThreadLocalMap里某个Entry的key引用还指向这个对象
         * - 若key是强引用，就会导致key指向的ThreadLocal对象和v指向的对象不能被gc回收，造成内存泄漏
         * - 若key是弱引用，保证了key指向的ThreadLocal对象能被顺利回收且Entry的key引用指向null
         *
         *   在gc的时候，根据可达性分析算法，ThreadLocal没有任何一条链路引用到，因此被回收。
         *   这样的话ThreadLocalMap就会出现key为null的Entry，就没有办法访问key为null的value
         *   如果当前线程迟迟不结束的话(在线程池的使用场景下 )，这些key为null的Entry就会存在一条引用链：
         *   Thread Ref -> Thread -> ThreadLocalMap -> Entry -> value
         *   导致内存泄漏
         *
         *   当然在线程正常结束的时候，还是会被GC回收掉的
         *
         *   如何防止在线程迟迟不结束时可能出现的内存泄漏？
         *   在调用get、set方法时会检查
         *   最好的使用方式是在使用结束之后，手动调用remove()
         */
    }

    public static void main(String[] args) {
        ThreadLocalDemo.function();
    }

}
