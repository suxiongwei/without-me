> - [个人简历](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E7%AE%80%E5%8E%86.md)
> - [LeetCode/算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/LeetCode%E9%A2%98%E8%A7%A3.md)
> - [SQL题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/SQL.md)
> - [一些面试题](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/%E9%9D%A2%E8%AF%95%E9%A2%98.md)
## Java语言部分
- [死锁发生的原因](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/lock/DeadLockSample.java)
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
- [LongAdder](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/cas/LongAdderDemo.java)
- [偏向锁](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/sync/SynchronizedDemo.java)

## Spring框架
- [@Autowired和@Resource注解的区别](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E5%92%8C%40Resource%E6%B3%A8%E8%A7%A3%E7%9A%84%E5%8C%BA%E5%88%AB.md)
- [@Autowired的实现原理](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E7%9A%84%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)

## MySQL
- [MySQL事务隔离级别]()
- [事务的特性(ACID)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E6%95%B0%E6%8D%AE%E5%BA%93ACID%E5%9B%9B%E5%A4%A7%E7%89%B9%E6%80%A7.md)
- [红黑树和二叉平衡树的特点和区别](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91%26%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91%26%E7%BA%A2%E9%BB%91%E6%A0%91%26B-%E6%A0%91%26B%2B%E6%A0%91%E6%80%A7%E8%83%BD%E5%AF%B9%E6%AF%94.md)
- [MySQL悲观锁和乐观锁](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/MySQL%E6%82%B2%E8%A7%82%E9%94%81%E5%92%8C%E4%B9%90%E8%A7%82%E9%94%81.md)
- [redolog与binlog为什么需要两阶段提交？](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/redolog%E4%B8%8Ebinlog%E4%B8%BA%E4%BB%80%E4%B9%88%E9%9C%80%E8%A6%81%E4%B8%A4%E9%98%B6%E6%AE%B5%E6%8F%90%E4%BA%A4%EF%BC%9F.md)

## 分布式
#### [为何Kafka这么"快"?](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E4%B8%BA%E4%BD%95Kafka%E8%BF%99%E4%B9%88%22%E5%BF%AB%22%EF%BC%9F.md)
#### [雪花算法(SnowFlake)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E9%9B%AA%E8%8A%B1%E7%AE%97%E6%B3%95(SnowFlake).md)


## 计算机网络
- [TCP三次握手和四次挥手]()
- [请说说你对守护进程，僵尸进程和孤儿进程的理解](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E5%AE%88%E6%8A%A4%E8%BF%9B%E7%A8%8B%E3%80%81%E5%83%B5%E5%B0%B8%E8%BF%9B%E7%A8%8B%E5%92%8C%E5%AD%A4%E5%84%BF%E8%BF%9B%E7%A8%8B%E7%9A%84%E7%90%86%E8%A7%A3.md)
- [请解释一下什么是虚拟内存？分段？分页？](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E8%99%9A%E6%8B%9F%E5%86%85%E5%AD%98.md)

## 大数据/数据仓库
- [列式存储]()
- [窗口函数]()

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


