# without-me
## Java
已包含内容：
- Java的虚引用、弱引用...(com.sxw.learn.jvm.ref)
- ExecutorCompletionService
- InheritableThreadLocal
- CompletableFuture
- LockSupport
- wait notify(WaitNotifyCase) 
- Java中的按值传递(CallByValue)
- Java的反射(ReflectTest)
- Volatile(VolatileDemo)
- Lambda(LambdaTest)
- JDK动态代理(JdkDynamicProxyTest)
- Synchronized(SynchronizedDemo)

## 设计模式
- 工厂模式(Factory、SimpleFactoryDesignTest)
- 单例模式(SingletonTest)
- 装饰器模式(DecoratorDesignTest) 

## 其它
- 布隆过滤器BloomFilter(BloomFilterDemo)
- 限流算法(RateLimiterTest)
- Guava的常见用法(GuavaTest)
- SpringBoot 启动时自动执行代码的几种方式(com.sxw.learn.spring.startrun)

# 一些面试题： 
#### CompletableFuture 的join和get有什么区别？
join在编辑期不会抛出受检异常 

#### 为什么任何一个对象都可以成为一个锁？
每个对象都有一个监视器

#### 非公平锁的优点
减少线程的切换，更能充分的利用CPU