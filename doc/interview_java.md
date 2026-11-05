# Java 基础、并发与 JVM

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

基础：集合与对象模型 → 进阶：并发与异步 → 实践：JUC 示例 → 排查：线程与内存。

**版本与前提：** 工程示例以 Java 8 为基线；JVM 补充知识以常见 HotSpot 实现为模型，阈值、优化和线程行为按 JDK 核对。

## 本页目录

<details>
<summary>展开专题与代码目录</summary>

- [推荐阅读](#推荐阅读)
- [配套专题与练习](#配套专题与练习)
- [补充笔记与代码](#补充笔记与代码)
  - [CompletableFuture 的 join 与 get](#completablefuture-的-join-与-get)
  - [String为什么要定义为不可变的？](#string为什么要定义为不可变的)
  - [String是怎么实现不可变的？](#string是怎么实现不可变的)
  - [为什么任何一个对象都可以成为一个锁？](#为什么任何一个对象都可以成为一个锁)
  - [非公平锁的优点](#非公平锁的优点)
  - [两个线程交替打印0-100的奇偶数](#两个线程交替打印0-100的奇偶数)
  - [可以用作GC Roots的对象](#可以用作gc-roots的对象)
  - [TLAB](#tlab)
  - [逃逸分析](#逃逸分析)
  - [JIT(即时编译)](#jit即时编译)
  - [是不是所有的对象和数组都会在堆内存分配空间？](#是不是所有的对象和数组都会在堆内存分配空间)
  - [HashMap中为何链表长度大于8才转换成红黑树？](#hashmap中为何链表长度大于8才转换成红黑树)
  - [如何动态修改线程池参数](#如何动态修改线程池参数)
  - [execute和submit的区别](#execute和submit的区别)
  - [volatile&内存屏障](#volatile内存屏障)
  - [序列化](#序列化)

</details>

## 推荐阅读

- [Q01 HashMap 的原理和使用风险是什么](topics/java-concurrency.md#q01-hashmap-的原理和使用风险是什么)
- [Q02 ConcurrentHashMap 线程安全 为什么先判断再写仍有问题](topics/java-concurrency.md#q02-concurrenthashmap-线程安全-为什么先判断再写仍有问题)
- [Q03 volatile synchronized 和 CAS 怎么选](topics/java-concurrency.md#q03-volatile-synchronized-和-cas-怎么选)
- [Q04 线程池怎么执行任务 参数怎么确定](topics/java-concurrency.md#q04-线程池怎么执行任务-参数怎么确定)
- [Q05 CompletableFuture 并行调用要注意什么](topics/java-concurrency.md#q05-completablefuture-并行调用要注意什么)
- [Q06 ThreadLocal 为什么可能导致内存或上下文问题](topics/java-concurrency.md#q06-threadlocal-为什么可能导致内存或上下文问题)

## 配套专题与练习

- [运行诊断](topics/runtime-diagnostics.md)
- [Future 与异步结果](Future.md)

## 补充笔记与代码

- [死锁发生的原因](../src/main/java/com/sxw/learn/juc/lock/DeadLockSample.java)
- [Java的JUC框架](../src/main/java/com/sxw/learn/juc)
- [Java的虚引用、弱引用](../src/main/java/com/sxw/learn/jvm/ref/package-info.java)
- [ExecutorCompletionService](../src/main/java/com/sxw/learn/thread/ExecutorCompletionServiceTest.java)
- [InheritableThreadLocal](../src/main/java/com/sxw/learn/thread/InheritableThreadLocalTest.java)
- [ThreadLocal](../src/main/java/com/sxw/learn/thread/ThreadLocalDemo.java)
- [CompletableFuture](../src/main/java/com/sxw/learn/juc/future/CompletableFutureApiDemo.java)
- [LockSupport](../src/main/java/com/sxw/learn/juc/lock/LockSupportDemo.java)
- [wait notify](../src/main/java/com/sxw/learn/thread/TestSleepAndWait.java)
- [Java中的按值传递](../src/main/java/com/sxw/learn/base/CallByValue.java)
- [Java的反射](../src/main/java/com/sxw/learn/reflect/ReflectTest.java)
- [Volatile](../src/main/java/com/sxw/learn/jmm/VolatileDemo.java)
- [Lambda](../src/main/java/com/sxw/learn/jvm/lambda/LambdaTest.java)
- [JDK动态代理](../src/main/java/com/sxw/learn/design/proxy)
- [Synchronized](../src/main/java/com/sxw/learn/sync)

- [Wait&Notify](../src/main/java/com/sxw/learn/thread/WaitNotifyCase.java)
- [LongAdder](../src/main/java/com/sxw/learn/juc/cas/LongAdderDemo.java)
- [偏向锁](../src/main/java/com/sxw/learn/sync/SynchronizedDemo.java)
- [Guava的常见用法](../src/main/java/com/sxw/learn/guava/GuavaTest.java)

### CompletableFuture 的 join 与 get

| 获取方式 | 异常与等待 |
| --- | --- |
| `join()` | 失败通常以未检查的 CompletionException 传播，调用签名不要求捕获受检异常 |
| `get()` | 声明 InterruptedException 与 ExecutionException，需要明确处理中断和执行失败 |

两种方式都可能等待任务完成；取消、超时和底层任务停止是不同的问题。详见 [Q05](topics/java-concurrency.md#q05-completablefuture-并行调用要注意什么)。

### String为什么要定义为不可变的？

优点：
- 线程安全性
- 节省空间，提高效率

缺点：
- 修改性能不高

### String是怎么实现不可变的？

保存字符串的数组被 final 修饰且为私有的，并且String 类没有提供/暴露修改这个字符串的方法。

String 类被 final 修饰导致其不能被继承，进而避免了子类破坏 String 不可变。

### 为什么任何一个对象都可以成为一个锁？

每个对象都有一个监视器

### 非公平锁的优点

减少线程的切换，更能充分的利用CPU

### [两个线程交替打印0-100的奇偶数](../src/main/java/com/sxw/learn/thread/TurningRunner.java)

### 可以用作GC Roots的对象

> https://blog.csdn.net/u010798968/article/details/72835255

1. 虚拟机栈（栈帧中的本地变量表）中引用的对象；
2. 方法区中的类静态属性引用的对象；
3. 方法区中常量引用的对象；
4. 本地方法栈中JNI（即一般说的Native方法）中引用的对象

### TLAB

**什么是 TLAB （Thread Local Allocation Buffer）?**

从内存模型而不是垃圾回收的角度，对 Eden 区域继续进行划分，JVM 为每个线程分配了一个私有缓存区域，它包含在 Eden 空间内多线程同时分配内存时，
使用 TLAB 可以避免一系列的非线程安全问题，同时还能提升内存分配的吞吐量，因此我们可以将这种内存分配方式称为快速分配策略

**为什么要有 TLAB ?**

堆区是线程共享的，任何线程都可以访问到堆区中的共享数据，由于对象实例的创建在 JVM 中非常频繁，因此在并发环境下从堆区中划分内存空间是线程不安全的，为避免多个线程操作同一地址，需要使用加锁等机制，进而影响分配速度

尽管不是所有的对象实例都能够在 TLAB 中成功分配内存，但 JVM 确实是将 TLAB 作为内存分配的首选。在程序中，可以通过 -XX:UseTLAB 设置是否开启 TLAB 空间。

默认情况下，TLAB 空间的内存非常小，仅占有整个 Eden 空间的 1%，一旦对象在 TLAB 空间分配内存失败时，JVM 就会尝试着通过使用加锁机制确保数据操作的原子性，从而直接在 Eden 空间中分配内存。

### 逃逸分析

逃逸分析的基本行为就是分析对象动态作用域：当一个对象在方法中被定义后，它可能被外部方法所引用，例如作为调用参数传递到其他地方中，称为方法逃逸。

用途：
- 同步省略
- 标量替换 (栈上内存分配其实是依靠标量替换来实现的) -> 可以大大减少堆内存的占用
- 栈上分配

### JIT(即时编译)

引入了 JIT 技术后，Java程序还是通过解释器进行解释执行，当JVM发现某个方法或代码块运行特别频繁的时候，就会认为这是“热点代码”（Hot Spot Code)。
然后JIT会把部分“热点代码”翻译成本地机器相关的机器码，并进行优化，然后再把翻译后的机器码缓存起来，以备下次使用

参考资料：[juejin.cn](https://juejin.cn/post/6844903639308304397)

### 是不是所有的对象和数组都会在堆内存分配空间？

> http://www.hollischuang.com/archives/2398

不一定，随着JIT编译器的发展，在编译期间，如果JIT经过逃逸分析，发现有些对象没有逃逸出方法，那么有可能堆内存分配会被优化成栈内存分配。

但是这也并不是绝对的。就像我们前面看到的一样，在开启逃逸分析之后，也并不是所有User对象都没有在堆上分配。

### HashMap中为何链表长度大于8才转换成红黑树？

如果 hashCode 分布良好，也就是 hash 计算的结果离散好的话，那么红黑树这种形式是很少会被用到的，因为各个值都均匀分布，很少出现链表很长的情况。

在理想情况下，链表长度符合泊松分布，各个长度的命中概率依次递减，当长度为 8 的时候，概率仅为 0.00000006。

这是一个小于千万分之一的概率，通常我们的 Map 里面是不会存储这么多的数据的，所以通常情况下，并不会发生从链表向红黑树的转换。

### 如何动态修改线程池参数

JDK提供了方法去修改
- setCorePoolSize
- setMaximumPoolSize
- setKeepAliveTime
- setRejectedExecutionHandler

以上修改方式再加上Apollo配置中心，就可以额实现不重启进程对线程池参数的修改

参考资料：[blog.csdn.net](https://blog.csdn.net/woshixuye/article/details/115617910)

### execute和submit的区别

execute和submit都属于线程池的方法，execute只能提交Runnable类型的任务，无返回值。

而submit既能提交Runable类型的任务，返回值为null，也能提交Callable类型的任务，返回值为Future。

execute会直接抛出任务执行时异常，submit则不会抛出异常，但可以通过Future的get方法将任务执行时的异常重新抛出。

### volatile&内存屏障

内存屏障是硬件之上、操作系统或JVM之下，对并发作出的最后一层支持。再向下是是硬件提供的支持；向上是操作系统或JVM对内存屏障作出的各种封装。内存屏障是一种标准，各厂商可能采用不同的实现。

volatile标记，可以解决编译器层面的可见性与重排序问题。而内存屏障则解决了硬件层面的可见性与重排序问题

内存屏障 主要是借助于一些指令实现
- Store：将处理器缓存的数据刷新到内存中。
- Load：将内存存储的数据拷贝到处理器的缓存中。

通过这些指令可以生成一些屏障类型，如sfence(Store Barrier)，主要作用如下：

强制所有在sfence指令之前的store指令，都在该sfence指令执行之前被执行，发送缓存失效信号，并把store buffer中的数据刷出到CPU的L1 Cache中；所有在sfence指令之后的store指令，都在该sfence指令执行之后被执行。即，禁止对sfence指令前后store指令的重排序跨越sfence指令，使所有Store Barrier之前发生的内存更新都是可见的。

volatile如何解决内存可见性与处理器重排序问题？

- 在写volatile变量v之后，插入一个sfence。这样，sfence之前的所有store（包括写v）不会被重排序到sfence之后，sfence之后的所有store不会被重排序到sfence之前，禁用跨sfence的store重排序；且sfence之前修改的值都会被写回缓存，并标记其他CPU中的缓存失效。
- 在读volatile变量v之前，插入一个lfence。这样，lfence之后的load（包括读v）不会被重排序到lfence之前，lfence之前的load不会被重排序到lfence之后，禁用跨lfence的load重排序；且lfence之后，会首先刷新无效缓存，从而得到最新的修改值，与sfence配合保证内存可见性。

参考资料：[monkeysayhi.github.io](https://monkeysayhi.github.io/2017/12/28/%E4%B8%80%E6%96%87%E8%A7%A3%E5%86%B3%E5%86%85%E5%AD%98%E5%B1%8F%E9%9A%9C/)

### 序列化

前提：序列化最终的目的是为了对象可以跨平台存储和进行网络传输。
而我们进行跨平台存储和网络传输的方式就是IO，而我们的IO支持的数据格式就是字节数组

序列化：把对象转化为可传输的字节序列过程称为序列化。

反序列化：把字节序列还原为对象的过程称为反序列化。

参考资料：[zhuanlan.zhihu.com](https://zhuanlan.zhihu.com/p/40462507)

#### 如何理解Java线程优先级

高优先级的线程大概率比低优先的线程优先获得 CPU 资源。

#### Java中的线程与操作系统的线程有什么区别？

> Java 中线程的本质，其实就是操作系统中的线程，其线程库和线程模型很大程度上依赖于操作系统（宿主系统）的具体实现

首先，日常开发中都是会使用线程池来获取或者创建线程的，而线程在创建时，其实是先创建一个java线程，等到本地存储、程序计数器、缓冲区等都分配好以后，JVM会调用操作系统的方法，创建一个与java线程绑定的原生线程。
线程的调度是由操作系统负责的。</br>
当操作系统为线程分配好时间片以后，就会调用java线程的run方法执行线程。</br>
当线程结束后，会释放java线程和原生线程所占用的资源

#### 请求转发和重定向的区别

**请求转发**：客户浏览器发送http请求，web服务器接受此请求，调用内部的一个方法在容器内部完成请求处理和转发动作，将目标资源发送给客户;
在这里，转发的路径必须是同一个web容器下的url，其不能转向到其他的web路径上去，中间传递的是自己的容器内的request。
在客户浏览器路径栏显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。

**重定向过程**：客户浏览器发送http请求，web服务器接受后发送**302状态码**响应及对应新的location给客户浏览器，
客户浏览器发现是302响应，则自动再发送一个新的http请求，请求url是新的location地址，服务器根据此请求寻找资源并发送给客户。
在这里location可以重定向到任意URL，既然是浏览器重新发出了请求，则就没有什么request传递的概念了。在客户浏览器路径栏显示的是其重定向的路径，客户可以观察到地址的变化的。重定向行为是浏览器做了至少两次的访问请求的。
