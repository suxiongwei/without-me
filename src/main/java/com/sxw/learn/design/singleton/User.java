package com.sxw.learn.design.singleton;

public class User {

    private User() {
    }

    /**
     * 执行方式：
     * 方法是类加载的初始化阶段就是执行的，它这里的主要逻辑就是创建了两个对象，设置到INSTANCE，INSTANCE1上。
     * 类加载初始化的时候创建的优势：线程安全
     * <p>
     * 在调用getInstance的时候 INSTANCE和INSTANCE1就都会生成，每一个枚举类在执行构造方法的时候都会生成一个新的实例
     * 因此只要保证只有一个枚举类的时候，就能保证单例
     * <p>
     *
     * 枚举可避免反序列化破坏单例
     */
    enum EnumSingleton {
        // 创建一个枚举对象，该对象天生为单例
        INSTANCE,
//        INSTANCE1
        ;
        private User user;

        // 私有化枚举的构造函数，枚举构造函数默认情况下是隐式声明为“private”
        EnumSingleton() {
            user = new User();
        }

        public User getInstance() {
            return user;
        }


    }

    public static User getInstance() {
        return EnumSingleton.INSTANCE.getInstance();
    }

//    public static User getInstance1(){
//        return EnumSingleton.INSTANCE1.getInstance();
//    }

    public static void main(String[] args) {
        User instance0 = User.getInstance();
        User instance1 = User.getInstance();

        System.out.println(instance0 == instance1);
    }
}
