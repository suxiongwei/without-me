package com.sxw.learn.jvm.ref;

import java.lang.ref.WeakReference;

/**
 * 测试弱引用
 * 有一个WeakHashMap
 */
public class TestWeakRef {
    public static class User{
        public int id = 0;
        public String name = "";

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        User u = new User(1, "张三");
        WeakReference<User> weakReference = new WeakReference<>(u);
        System.gc();
        System.out.println("第一次GC后value:" + weakReference.get());
        u = null;
        // 显式gc的时候，weakReference会被回收
        System.gc();
        System.out.println("第二次GC后value:" + weakReference.get());
    }
}
