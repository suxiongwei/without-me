package com.sxw.learn.jvm.ref;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试软引用
 */
public class TestSoftRef {
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
        SoftReference<User> softReference = new SoftReference<>(u);
        u = null;
        System.out.println(softReference.get());
        // 展示gc的时候，softReference不一定会被回收
        System.gc();
        System.out.println("After GC");
        System.out.println(softReference.get());
        List<byte[]> list = new LinkedList<>();

        try {
            for (int i = 0; i < 100; i++){
                System.out.println("******************" + softReference.get());
                list.add(new byte[1024 * 1024 * 1]);
            }
        }catch (Throwable throwable){
            // 抛出异常后打印的，所以softReference已经被垃圾回收回收掉了
            System.out.println("******************" + softReference.get());
        }




    }
}
