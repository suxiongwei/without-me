package com.sxw.learn.spring.test1;
/**
 * 扩展点：
 * 1、BeanPostProcessor
 * Spring的扩展点之一，提供了对Bean的操作扩展
 *
 * 2、InitializingBean、DisposableBean
 * Spring bean 通过实现 InitializingBean ,DisposableBean 接口实现初始化方法和销毁前操作
 * 在 BeanPostProcessor扩展点之后执行
 *
 * 3、Aware接口
 * Spring中提供了各种Aware接口，如果检测到一个bean实现了Aware接口，则能在bean中获取相应的Spring资源；
 * 如果某个对象实现了某个Aware接口，比如需要依赖Spring的上下文容器（ApplicationContext），则可以实现ApplicationContextAware接口。
 * Spring在Bean进行初始化（注意与实例化的区别）之前，会将依赖的ApplicationContext对象通过调用ApplicationContextAware#setApplicationContext注入。
 *
 *
 * https://blog.csdn.net/qq_38826019/article/details/117389466
 *
 */