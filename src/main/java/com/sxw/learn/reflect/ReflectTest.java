package com.sxw.learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-29 5:02 下午
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class aClass = Class.forName("com.sxw.learn.reflect.Person");
        Person person = (Person) aClass.newInstance();

        Method method = person.getClass().getDeclaredMethod("playGame");
        method.setAccessible(true);
        method.invoke(person);

        Field field = person.getClass().getDeclaredField("userName");
        field.setAccessible(true);
        // 这一步执行完 person 的userName已经赋值成功
        field.set(person, "jinitaimei");
        // 重新调用playGame方法
        method.invoke(person);
    }
}
