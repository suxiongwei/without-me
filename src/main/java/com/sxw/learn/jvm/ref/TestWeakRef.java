package com.sxw.learn.jvm.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

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
        User u = new User(1, "苏雄伟");
        WeakReference<User> weakReference = new WeakReference<>(u);
        u = null;
        System.out.println(weakReference.get());
        // 展示gc的时候，weakReference会被回收
        System.gc();
        System.out.println("After GC");
        System.out.println(weakReference.get());
    }
}
