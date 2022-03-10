package com.sxw.learn.java.version16;

public interface TestInterface {
    /**
     * JAVA 8 对接口增加了默认方法的支持，在 JAVA 9 中对该功能又来了一次升级，现在可以在接口里定义私有方法，然后在默认方法里调用接口的私有方法。
     * 这样一来，既可以重用私有方法里的代码，又可以不公开代码
     */
//    default void wrapMethod(){
//        innerMethod();
//    }
//
//    private void innerMethod(){
//        System.out.println("Java 9 innerMethod");
//    }
}
