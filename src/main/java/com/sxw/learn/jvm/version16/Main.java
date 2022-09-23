package com.sxw.learn.jvm.version16;

/**
 * https://mp.weixin.qq.com/s/JqyY_Pd84seAhGXPl8il5Q
 */
public class Main {
    // 新增的 record 类型，干掉复杂的 POJO 类
//    public record UserDTO(String id,String nickname,String homepage){}

    public static void main(String[] args) {
        // 接口里可以添加私有接口
        TestInterface testInterface = new TestInterfaceImpl();
//        testInterface.wrapMethod();

        // 匿名内部类也支持钻石（diamond）运算符
        Foo<Integer> foo = t -> System.out.println("test 方法的 [t+1] 的值为：" + (t + 1));
        foo.test(1);

        // 类型推断
//        var message = "Hello, Java 10";
//        System.out.println(message);
//
//        UserDTO user = new UserDTO("1697301681936888","空无","https://juejin.cn/user/1697301681936888");
//        System.out.println(user.id);
//        System.out.println(user.nickname);
//        System.out.println(user.id);
//        System.out.println(user.toString());
    }
}
