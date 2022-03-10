package com.sxw.learn.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {
//    MapperMethod mapperMethod;  // 被代理的对象，实际的方法执行者，模拟mybatis获取mapper的动态代理
    Object target;
//    public LogHandler(MapperMethod mapperMethod) {
//        this.mapperMethod = mapperMethod;
//    }
    public LogHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);  // 调用 target 的 method 方法
//        Object execute = mapperMethod.execute();
        after();
        return result;  // 返回方法的执行结果
//        return execute;  // 返回方法的执行结果
    }

    // 调用invoke方法之前执行
    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    // 调用invoke方法之后执行
    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
