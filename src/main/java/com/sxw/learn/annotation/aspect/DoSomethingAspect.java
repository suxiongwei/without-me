package com.sxw.learn.annotation.aspect;

import com.sxw.learn.annotation.DoSomething;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-08-23 1:55 下午
 */
@Component
@Aspect
public class DoSomethingAspect {
    @Around("@annotation(dst)")
    public Object doAround(ProceedingJoinPoint pjp, DoSomething dst) throws Throwable {
        System.out.println("---------------开始增强--------------");

        Object user;
        String key = getKey(dst.key(), pjp);
        String cacheName = dst.cacheName();
        // 从缓存中获取数据 模仿redis不存在 获取的为null
        System.out.println("---------------从缓存中获取用户信息---------------");
        user = null;
        if (null == user){
            user = pjp.proceed();
        }

        // 记录日志
        boolean needLog = dst.needLog();
        if (needLog){
            System.out.println("打印日志了" + pjp.getSourceLocation().getWithinType().getName());
        }

        System.out.println("key:" + key);
        System.out.println("cacheName:" + cacheName);
        System.out.println("needLog:" + needLog);

        System.out.println("---------------增强结束--------------");
        return user;
    }

    private String getKey(String key, ProceedingJoinPoint pjp) {
        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            parameterNames[i] = parameters[i].getName();
        }
        return SpelParser.getKey(key, parameterNames, pjp.getArgs());
    }
}
