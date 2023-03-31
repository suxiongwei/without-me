package com.sxw.learn.base;

import java.util.function.BiConsumer;
import com.sxw.learn.annotation.model.User;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        BiConsumer<User, User> biConsumer = (t, u) ->{
            System.out.println(t);
            System.out.println(u);
        };
        biConsumer.accept(new User("1", "苏1"), new User("2", "苏2"));
    }
}
