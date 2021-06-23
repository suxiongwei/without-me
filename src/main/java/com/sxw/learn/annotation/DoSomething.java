package com.sxw.learn.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author 苏雄伟[suxiongwei@smzdm.com]
 * @Description
 * @Date 2020-08-23 1:41 下午
 */
@Retention(RUNTIME)// 运行时注解类型
@Target({TYPE, METHOD}) // 约束 只能配在类上或者方法上
public @interface DoSomething {
    /**
     * 缓存的key值
     * @return
     */
    String key();

    /**
     * 缓存逻辑名称
     * @return
     */
    String cacheName();

    /**
     * 是否记录日志
     * @return
     */
    boolean needLog() default false;
}
