package com.sxw.learn.reflect;

import com.sxw.learn.bean.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2021-01-29 5:02 下午
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class aClass = Class.forName("com.sxw.learn.bean.Person");
        Person person = (Person) aClass.newInstance();

        Method method = person.getClass().getDeclaredMethod("playGame");
        method.setAccessible(true);
        method.invoke(person);

        Field field = person.getClass().getDeclaredField("userName");
        field.setAccessible(true);
        field.set(person, "jinitaimei");
        method.invoke(person);

    }
}
