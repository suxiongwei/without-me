# Talk Is Cheap, Show Me The Code
> - [个人简历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E7%AE%80%E5%8E%86.md)
> - [LeetCode题解](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/LeetCode%E9%A2%98%E8%A7%A3.md)
> - [一些面试题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E9%9D%A2%E8%AF%95%E9%A2%98.md)
## Java语言部分
- [死锁发生的原因]()
- [Java的JUC框架](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/juc)
- [JVM的调优策略]()
- [内存泄漏与内存溢出的区别，何时产生内存泄漏]()
- [Java的虚引用、弱引用](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/jvm/ref/package-info.java)
- [ExecutorCompletionService](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/ExecutorCompletionServiceTest.java)
- [InheritableThreadLocal](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/InheritableThreadLocalTest.java)
- [ThreadLocal](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/ThreadLocalDemo.java)
- [CompletableFuture](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/future/CompletableFutureApiDemo.java)
- [LockSupport](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/lock/LockSupportDemo.java)
- [wait notify](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/TestSleepAndWait.java)
- [Java中的按值传递](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/base/CallByValue.java)
- [Java的反射](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/reflect/ReflectTest.java)
- [Volatile](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/jmm/VolatileDemo.java)
- [Lambda](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/jvm/lambda/LambdaTest.java)
- [JDK动态代理](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/proxy)
- [Synchronized](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/sync)
- CompletableFuture 的join和get有什么区别？<br/>
```dtd
  join()方法抛出的是uncheck异常（即RuntimeException),不会强制开发者抛出<br/>
  get()方法抛出的是经过检查的异常，ExecutionException, InterruptedException 需要用户手动处理（抛出或者 try catch）<br/>
```
- [Wait&Notify](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/WaitNotifyCase.java)
- [LongAdder]()

## Spring框架
- [@Autowired和@Resource注解的区别](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E5%92%8C%40Resource%E6%B3%A8%E8%A7%A3%E7%9A%84%E5%8C%BA%E5%88%AB.md)
- [@Autowired的实现原理](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E7%9A%84%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)

## MySQL
- [MySQL事务隔离级别]()
- [事务的特性(ACID)]()

## 计算机网络
- [TCP三次握手和四次挥手]()

## 设计模式
- [工厂模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/factory)
- [单例模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/singleton)
- [装饰器模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/decorator)

## 系统设计方面
- [高并发下如何生成订单的唯一ID]()
- [平时的项目技术设计时主要考虑的点，如何保证技术方案的可行性和扩展性]()
- [一个2G左右的文本文件，统计其中某个单词出现的次数，JVM只要512M，给出实现思路]()
- [布隆过滤器BloomFilter](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/BloomFilterDemo.java)
- [限流算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/RateLimiterTest.java)
- [常见软件的QPS](https://github.com/suxiongwei/without-me/blob/main/doc/%E5%B8%B8%E8%A7%81%E8%BD%AF%E4%BB%B6%E7%9A%84QPS.md)
- [领域驱动设计在互联网业务开发中的实践](https://tech.meituan.com/2017/12/22/ddd-in-practice.html)
- [一般实现分布式锁都有哪些方式？使用 Redis 如何设计分布式锁？使用 zk 来设计分布式锁可以吗？这两种分布式锁的实现方式哪种效率比较高？](https://github.com/doocs/advanced-java/blob/main/docs/distributed-system/distributed-lock-redis-vs-zookeeper.md)

## 其它(工具)
- [Guava的常见用法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/GuavaTest.java)
- [SpringBoot启动时自动执行代码的几种方式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/spring/startrun/package-info.java)

## 系统设计
- [接口鉴权](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/auth/AuthUtils.java)


