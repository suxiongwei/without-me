## 一些面试题
### Java

##### String为什么要定义为不可变的？
<details>
<summary>展开</summary>

优点：
- 线程安全性
- 节省空间，提高效率

缺点：
- 修改性能不高
</details>

##### String是怎么实现不可变的？
<details>
<summary>展开</summary>
保存字符串的数组被 final 修饰且为私有的，并且String 类没有提供/暴露修改这个字符串的方法。

String 类被 final 修饰导致其不能被继承，进而避免了子类破坏 String 不可变。
</details>

##### 为什么任何一个对象都可以成为一个锁？
<details>
<summary>展开</summary>
每个对象都有一个监视器
</details>

##### 非公平锁的优点
<details>
<summary>展开</summary>
减少线程的切换，更能充分的利用CPU
</details>

##### [两个线程交替打印0-100的奇偶数](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/thread/TurningRunner.java)

##### 可以用作GC Roots的对象
<details>
<summary>展开</summary>

> https://blog.csdn.net/u010798968/article/details/72835255

1. 虚拟机栈（栈帧中的本地变量表）中引用的对象；
2. 方法区中的类静态属性引用的对象；
3. 方法区中常量引用的对象；
4. 本地方法栈中JNI（即一般说的Native方法）中引用的对象
</details>

##### TLAB
<details>
<summary>展开</summary>

**什么是 TLAB （Thread Local Allocation Buffer）?**

从内存模型而不是垃圾回收的角度，对 Eden 区域继续进行划分，JVM 为每个线程分配了一个私有缓存区域，它包含在 Eden 空间内多线程同时分配内存时，
使用 TLAB 可以避免一系列的非线程安全问题，同时还能提升内存分配的吞吐量，因此我们可以将这种内存分配方式称为快速分配策略

**为什么要有 TLAB ?**

堆区是线程共享的，任何线程都可以访问到堆区中的共享数据，由于对象实例的创建在 JVM 中非常频繁，因此在并发环境下从堆区中划分内存空间是线程不安全的，为避免多个线程操作同一地址，需要使用加锁等机制，进而影响分配速度

尽管不是所有的对象实例都能够在 TLAB 中成功分配内存，但 JVM 确实是将 TLAB 作为内存分配的首选。在程序中，可以通过 -XX:UseTLAB 设置是否开启 TLAB 空间。

默认情况下，TLAB 空间的内存非常小，仅占有整个 Eden 空间的 1%，一旦对象在 TLAB 空间分配内存失败时，JVM 就会尝试着通过使用加锁机制确保数据操作的原子性，从而直接在 Eden 空间中分配内存。

</details>

##### 逃逸分析
<details>
<summary>展开</summary>

逃逸分析的基本行为就是分析对象动态作用域：当一个对象在方法中被定义后，它可能被外部方法所引用，例如作为调用参数传递到其他地方中，称为方法逃逸。

用途：
- 同步省略
- 标量替换 (栈上内存分配其实是依靠标量替换来实现的) -> 可以大大减少堆内存的占用
- 栈上分配
</details>

##### JIT(即时编译)
<details>
<summary>展开</summary>

引入了 JIT 技术后，Java程序还是通过解释器进行解释执行，当JVM发现某个方法或代码块运行特别频繁的时候，就会认为这是“热点代码”（Hot Spot Code)。
然后JIT会把部分“热点代码”翻译成本地机器相关的机器码，并进行优化，然后再把翻译后的机器码缓存起来，以备下次使用

链接：https://juejin.cn/post/6844903639308304397

</details>


##### 是不是所有的对象和数组都会在堆内存分配空间？
<details>
<summary>展开</summary>

> http://www.hollischuang.com/archives/2398

不一定，随着JIT编译器的发展，在编译期间，如果JIT经过逃逸分析，发现有些对象没有逃逸出方法，那么有可能堆内存分配会被优化成栈内存分配。

但是这也并不是绝对的。就像我们前面看到的一样，在开启逃逸分析之后，也并不是所有User对象都没有在堆上分配。

</details>


##### HashMap中为何链表长度大于8才转换成红黑树？
<details>
<summary>展开</summary>
如果 hashCode 分布良好，也就是 hash 计算的结果离散好的话，那么红黑树这种形式是很少会被用到的，因为各个值都均匀分布，很少出现链表很长的情况。

在理想情况下，链表长度符合泊松分布，各个长度的命中概率依次递减，当长度为 8 的时候，概率仅为 0.00000006。

这是一个小于千万分之一的概率，通常我们的 Map 里面是不会存储这么多的数据的，所以通常情况下，并不会发生从链表向红黑树的转换。
</details>

##### 如何动态修改线程池参数
<details>
<summary>展开</summary>
JDK提供了方法去修改
- setCorePoolSize
- setMaximumPoolSize
- setKeepAliveTime
- setRejectedExecutionHandler

以上修改方式再加上Apollo配置中心，就可以额实现不重启进程对线程池参数的修改

https://blog.csdn.net/woshixuye/article/details/115617910
</details>

##### execute和submit的区别
<details>
<summary>展开</summary>
execute和submit都属于线程池的方法，execute只能提交Runnable类型的任务，无返回值。

而submit既能提交Runable类型的任务，返回值为null，也能提交Callable类型的任务，返回值为Future。

execute会直接抛出任务执行时异常，submit则不会抛出异常，但可以通过Future的get方法将任务执行时的异常重新抛出。
</details>


#### volatile&内存屏障
<details>
<summary>展开</summary>
内存屏障是硬件之上、操作系统或JVM之下，对并发作出的最后一层支持。再向下是是硬件提供的支持；向上是操作系统或JVM对内存屏障作出的各种封装。内存屏障是一种标准，各厂商可能采用不同的实现。

volatile标记，可以解决编译器层面的可见性与重排序问题。而内存屏障则解决了硬件层面的可见性与重排序问题

内存屏障 主要是借助与一些指令实现
- Store：将处理器缓存的数据刷新到内存中。
- Load：将内存存储的数据拷贝到处理器的缓存中。

通过这些指令可以生成一些屏障类型，如sfence(Store Barrier)，主要作用如下：

强制所有在sfence指令之前的store指令，都在该sfence指令执行之前被执行，发送缓存失效信号，并把store buffer中的数据刷出到CPU的L1 Cache中；所有在sfence指令之后的store指令，都在该sfence指令执行之后被执行。即，禁止对sfence指令前后store指令的重排序跨越sfence指令，使所有Store Barrier之前发生的内存更新都是可见的。


volatile如何解决内存可见性与处理器重排序问题？

- 在写volatile变量v之后，插入一个sfence。这样，sfence之前的所有store（包括写v）不会被重排序到sfence之后，sfence之后的所有store不会被重排序到sfence之前，禁用跨sfence的store重排序；且sfence之前修改的值都会被写回缓存，并标记其他CPU中的缓存失效。
- 在读volatile变量v之前，插入一个lfence。这样，lfence之后的load（包括读v）不会被重排序到lfence之前，lfence之前的load不会被重排序到lfence之后，禁用跨lfence的load重排序；且lfence之后，会首先刷新无效缓存，从而得到最新的修改值，与sfence配合保证内存可见性。

https://monkeysayhi.github.io/2017/12/28/%E4%B8%80%E6%96%87%E8%A7%A3%E5%86%B3%E5%86%85%E5%AD%98%E5%B1%8F%E9%9A%9C/
</details>

#### 序列化
<details>
<summary>展开</summary>
前提：序列化最终的目的是为了对象可以跨平台存储和进行网络传输。
而我们进行跨平台存储和网络传输的方式就是IO，而我们的IO支持的数据格式就是字节数组

序列化：把对象转化为可传输的字节序列过程称为序列化。

反序列化：把字节序列还原为对象的过程称为反序列化。

https://zhuanlan.zhihu.com/p/40462507
</details>

### Spring

#### Spring中的bean为什么默认设置为单例的
<details>
<summary>展开</summary>
首先 单例的性能好，开销低

其次 一般业务系统的组件以无状态的组件居多，这些组件比初始化是有一定开销的，基于这些bean的使用场景单例的系统开销最小，占据了bean的绝大多数配置场景，其他scope级别的使用场景是极其有限的。

基于以上的客观事实，默认配置为单例很大程度上还是为了减少人工确认配置的工作量，防止人工配置遗漏而带来的不必要的系统开销和风险，方便使用。
</details>


#### SpringBoot是什么&特点
<details>
<summary>展开</summary>
是什么：
为了简化Spring繁琐的XML配置，本质上还是Spring，理念是约定大于配置

特点：
- 供了固定的配置来简化配置，即约定大于配置
- 尽可能地自动配置 Spring 和第三方库，即能自动装配
</details>


#### SpringBoot自动配置的原理
<details>
<summary>展开</summary>
@SpringBootApplication里的核心注解，包含以下两部分：

- @SpringBootConfiguration（里面就是@Configuration，标注当前类为配置类，其实只是做了一层封装改了个名字而已）
- @EnableAutoConfiguration（开启自动配置）

@EnableAutoConfiguration 是SpringBoot中的重点部分，包含以下两部分：

- @AutoConfigurationPackage（将主配置类（@SpringBootApplication 标注的类）所在的包下面所有的组件都扫描注冊到 spring 容器中）
- @Import({AutoConfigurationImportSelector.class})（自动配置类的导入选择器，有选择的导入类）

SpringFactoriesLoader工厂加载机制是Spring内部提供的一个约定俗成的加载方式，只需要在模块的META-INF下创建spring.factories文件，
这个Properties格式的文件中的key是接口、注解、或抽象类的全名，value是以逗号 “ , “ 分隔的实现类，使用SpringFactoriesLoader来实现相应的实现类注入Spirng容器中。

链接：https://juejin.cn/post/7046554366068654094
</details>


### MySQL
##### B-树和B+树的区别
<details>
<summary>展开</summary>
https://www.jianshu.com/p/ace3cd6526c4<br/>
1. B+树内节点不存储数据，所有 data 存储在叶节点导致查询时间复杂度固定为 log n。而B-树查询时间复杂度不固定，与 key 在树中的位置有关，最好为O(1)。
2. B+树叶节点两两相连可大大增加区间访问性，可使用在范围查询等，而B-树每个节点 key 和 data 在一起，则无法区间查找。
3. B+树更适合外部存储。由于内节点无 data 域，每个节点能索引的范围更大更精确
</details>

##### MySQL意向锁的作用是什么？
<details>
<summary>展开</summary>
因为 mysql 存在行锁，而行锁与表锁存在互斥的关系，当执行一条 sql 语句出现行锁时，会修改表头的一个标志位，也就是所谓的意向锁。
此时，如果需要锁表时，会去判断标志位，从而迅速知道能否锁表。
##### 意向锁和哪些锁有互斥关系？

https://juejin.cn/post/6844903666332368909 <br/>
意向锁和自家兄弟互相兼容，但是它会与普通的排他/共享锁互斥(表锁)<br/>
*意向锁不会与行级的共享 / 排他锁互斥！！！*
</details>
##### 什么是间隙锁(Gap Locks)？
<details>
<summary>展开</summary>
间隙锁，它封锁索引记录中的间隔，或者第一条索引记录之前的范围，又或者最后一条索引记录之后的范围。<br/>
在 InnoDB，RR 条件下：<br/>
```sql
select * from lock_example where id between 8 and 15 for update;
```
这个SQL语句会封锁区间(8，15)，以阻止其他事务插入id位于该区间的记录。<br/>
间隙锁的主要目的，就是为了防止其他事务在间隔中插入数据，以导致“不可重复读”。<br/>
如果把事务的隔离级别降级为读提交(Read Committed， RC)，间隙锁则会自动失效。
</details>

##### 什么是MVCC？
<details>
<summary>展开</summary>
https://zhuanlan.zhihu.com/p/52977862<br/>
核心：
- 事务版本号
- 表的隐藏列
- undo log
- read view

MVCC是在并发访问数据库时，通过对数据做多版本管理，避免因为写数据时要加写锁而阻塞读取数据的请求，造成写数据时无法读取数据的问题。<br/>
通俗的讲就是MVCC通过保存数据的历史版本(undo log)，根据比较**数据的版本号**来决定数据的是否显示(MVCC快照读：根据版本号获取快照数据版本)，
在不需要加读锁的情况就能达到事务的隔离效果，最终可以在读取数据的时候可以同时进行修改，修改数据时候可以同时读取，极大的提升了事务的并发性能。
</details>

##### MVCC是否有解决幻读问题？
<details>
<summary>展开</summary>
快照读的情况下可以避免幻读问题，在当前读的情况下则需要使用间隙锁来解决幻读问题的
</details>

##### MySQL 行锁和表锁的含义及区别
<details>
<summary>展开</summary>
**MyISAM只支持表锁**，MyISAM在执行查询语句（select）前，会自动给涉及的所有表加读锁，在执行增删改操作前，会自动给涉及的表加写锁。

**InnoDB引擎支持行锁**

行锁是通过索引加载的，也就是说，行锁是加在索引响应的行上的，要是对应的SQL语句没有走索引，则会全表扫描，行锁则无法实现，取而代之的是表锁，此时其它事务无法对当前表进行更新或插入操作。

insert，delete，update在事务中都会自动默认加上排它锁。

https://segmentfault.com/a/1190000023662810
</details>

### 分布式

### 计算机基础&网络
##### TCP和UDP的区别
<details>
<summary>展开</summary>

TCP/IP协议是一个协议簇。里面包括很多协议的，UDP只是其中的一个， 之所以命名为TCP/IP协议，因为TCP、IP协议是两个很重要的协议，就用他两命名了。

TCP/IP协议集包括应用层,传输层，网络层，网络访问层。

- 1、基于连接与无连接； 
- 2、对系统资源的要求（TCP较多，UDP少）； 
- 3、UDP程序结构较简单； 
- 4、流模式与数据报模式 ； 
- 5、TCP保证数据正确性，UDP可能丢包； 
- 6、TCP保证数据顺序，UDP不保证。

https://zhuanlan.zhihu.com/p/24860273
</details>

##### ping命令是基于什么协议
<details>
<summary>展开</summary>
ping命令是用来探测主机到主机之间是否可通信，如果不能ping到某台主机，表明不能和这台主机建立连接。

ping命令是使用 IP 和网络控制信息协议 (ICMP)，**因而没有涉及到任何传输协议(UDP/TCP) 和应用程序**。它发送icmp回送请求消息给目的主机。

ICMP协议规定：目的主机必须返回ICMP回送应答消息给源主机。如果源主机在一定时间内收到应答，则认为主机可达。
控制消息是指网络通不通、主机是否可达、路由是否可用等网络本身的消息。这些控制消息虽然并不传输用户数据，但是对于用户数据的传递起着重要的作用。
</details>

##### 数据链路层的主要功能是什么?
<details>
<summary>展开</summary>
1. 将数据组合成数据块，封装成帧
2. 差错控制
3. 流量控制
4. 链路控制
5. MAC寻址
6. 区分数据和控制信息
7. 透明传输
</details>

##### 四次挥手
每个方向都需要一个FIN和一个ACK，因此通常需要四个分节，所以我们称他为四次挥手。

##### TCP四次挥手可以变成三次吗？
<details>
<summary>展开</summary>
可以的

服务端将FIN和ack合并成一条进行发送。为什么会进行合并呢？是因为在关闭的时候，服务端没有数据发送给客户端，然后优化后就会将FIN和ack合并在一起发送给客户端
</details>

##### TCP time_wait
<details>
<summary>展开</summary>
服务器端发送一个FIN时，客户端会处于time_wait状态。当处于time_wait状态时，我们无法创建新的连接，因为端口被占用
</details>

##### time_wait有什么作用？
<details>
<summary>展开</summary>
> 主动断开方在TIME-WAIT状态必须等待2MSL

1. 可靠的终止TCP连接,能确保被动方顺利进入到CLOSED状态。只有这样，双方都能够确保关闭。

若处于time_wait的客户端发送给服务器确认报文段丢失的话，服务器将在此重新发送FIN报文段，那么客户端必须处于一个可接收的状态就是time_wait状态而不是close状态。

2. 保证让迟来的TCP报文段有足够的时间识别并丢弃

linux中一个TCP端口不能被打开两次或两次以上，当客户端处于time_wait状态时我们将无法使用此端口建立新连接。

主动断开方在发送完最后一个ACK报文后，再经过2MSL，才能最终关闭和释放端口，这就意味着，相同端口的新TCP新连接，需要在2MSL的时间之后，才能够正常的建立。
2MSL这段时间内，旧连接所产生的所有数据报文，都已经从网络中消失了，从而，确保了下一个新的连接中不会出现这种旧连接请求报文。
</details>

##### 一定是客户端才有time_wait状态吗？
<details>
<summary>展开</summary>
**不是**，当客户端进行主动关闭时，time_wait存在于客户端
</details>

##### CLOSE_WAIT
为什么这么多CLOSE_WAIT ？

CLOSE_WAIT就是连接被动关闭端的应用没调socket.close

CLOSE_WAIT是被动关闭端在等待应用进程的关闭

https://plantegg.github.io/2021/04/06/%E4%B8%BA%E4%BB%80%E4%B9%88%E8%BF%99%E4%B9%88%E5%A4%9ACLOSE_WAIT/

##### 如果已经建立了连接，但是Client端突然出现故障了怎么办？
<details>
<summary>展开</summary>
CP还设有一个保活计时器，Client端如果出现故障，Server端不能一直等下去，这样会浪费系统资源。每收到一次Client客户端的数据帧后，Server端都的保活计时器会复位。
计时器的超时时间通常是设置为2小时，若2小时还没有收到Client端的任何数据帧，Server端就会发送一个探测报文段，以后每隔75秒钟发送一次。
若一连发送10个探测报文仍然没反应，Server端就认为Client端出了故障，接着就关闭连接。
如果觉得保活计时器的两个多小时的间隔太长，可以自行调整TCP连接的保活参数。
</details>

##### select和epoll
<details>
<summary>展开</summary>
>  select/poll/epoll 是用来实现多路复用的，即一个线程利用它们即可 hold 住多个 socket

https://www.zhihu.com/question/22863976/answer/2360953876
</details>

##### Java中的线程与操作系统的线程有什么区别？
<details>
<summary>展开</summary>
> Java 中线程的本质，其实就是操作系统中的线程，其线程库和线程模型很大程度上依赖于操作系统（宿主系统）的具体实现

首先，日常开发中都是会使用线程池来获取或者创建线程的，而线程在创建时，其实是先创建一个java线程，等到本地存储、程序计数器、缓冲区等都分配好以后，JVM会调用操作系统的方法，创建一个与java线程绑定的原生线程。
线程的调度是由操作系统负责的。</br>
当操作系统为线程分配好时间片以后，就会调用java线程的run方法执行线程。</br>
当线程结束后，会释放java线程和原生线程所占用的资源
</details>

##### TCP具体是通过怎样的方式来保证数据的顺序化传输呢？
<details>
<summary>展开</summary>
> 每个数据包会被分配一个序列号，接收方按顺序接受并确认

具体步骤如下：</br>
（1）为了保证数据包的可靠传递，发送方必须把已发送的数据包保留在缓冲区；</br>
（2）并为每个已发送的数据包启动一个超时定时器；</br>
（3）如在定时器超时之前收到了对方发来的应答信息（可能是对本包的应答，也可以是对本包后续包的应答），则释放该数据包占用的缓冲区;</br>
（4）否则，重传该数据包，直到收到应答或重传次数超过规定的最大次数为止。</br>
（5）接收方收到数据包后，先进行CRC校验，如果正确则把数据交给上层协议，然后给发送方发送一个累计应答包，表明该数据已收到，如果接收方正好也有数据要发给发送方，应答包也可方在数据包中捎带过去</br>
</details>

##### TCP传输数据时的优化策略
<details>
<summary>展开</summary>
TCP 的传输速度，受制于发送窗口与接收窗口，以及网络设备传输能力。

发送缓冲区的大小 约等于 带宽时延积

带宽时延积 BDP = RTT * 带宽

> TCP 提供一种机制可以让「发送方」根据「接收方」的实际接收能力控制发送的数据量，这就是滑动窗口的由来。
</details>

##### 简述Cookie是什么？
<details>
<summary>展开</summary>
1. Cookie是浏览器访问服务器后，服务器传给浏览器的一段数据。
2. 浏览器需要保存这段数据，不得轻易删除。
3. 此后每次浏览器访问该服务器，都必须带上这段数据。
</details>

##### 如何理解Java线程优先级
<details>
<summary>展开</summary>
高优先级的线程大概率比低优先的线程优先获得 CPU 资源。
</details>

##### 请求转发和重定向的区别
<details>
<summary>展开</summary>
**请求转发**：客户浏览器发送http请求，web服务器接受此请求，调用内部的一个方法在容器内部完成请求处理和转发动作，将目标资源发送给客户;
在这里，转发的路径必须是同一个web容器下的url，其不能转向到其他的web路径上去，中间传递的是自己的容器内的request。
在客户浏览器路径栏显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。

**重定向过程**：客户浏览器发送http请求，web服务器接受后发送**302状态码**响应及对应新的location给客户浏览器，
客户浏览器发现是302响应，则自动再发送一个新的http请求，请求url是新的location地址，服务器根据此请求寻找资源并发送给客户。
在这里location可以重定向到任意URL，既然是浏览器重新发出了请求，则就没有什么request传递的概念了。在客户浏览器路径栏显示的是其重定向的路径，客户可以观察到地址的变化的。重定向行为是浏览器做了至少两次的访问请求的。
</details>

### 其它

### Java面试被问到项目中的难点如何回答？
数据分析API性能优化</br>

_讲述优化前存在的问题_</br>

架构的升级：
> 存储介质，调研选型，mysql -> ck </br>
> Java 程序的优化，接口鉴权 + 限流 + 熔断 + 降级 + 缓存 + 异步

限流：Hystrix、Sentinel



### 成长类
数据采集，数据仓库，数据服务和数据产品

如果我们再把『服务』这个词具象化，又可以拆解为数据接口，数据报表，数据产品和数据大屏这 4 类

**TL 需要具备的一些素养** 

一是如何在不影响业务交付的前提下对应用进行持续的技术升级。我认为这是一个『意愿大于能力』的事情，也是对技术 TL 追求卓越的真实考验。

如果一个技术团队只有做业务的能力，而不具备持续升级技术的能力，那这个技术团队注定是走不远的。

第二个经验是技术 TL 应该如何看待『重复造轮子』。

诚然，如上文中提到的，团队在过去两年中的技术积累一点都不 fancy，在相关领域或许也都有更成熟的解决方案。

但我认为，对于一个超过 10 人的技术团队，在开发规范和工具链上是需要给予团队成员一定自由度的。

一方面是因为总有些特殊的业务需求，是开源或其他团队现有工具覆盖不到的，在团队底层工具链中保持一定的自主性和灵活性，是能够更好服务业务的基础。

另一方面这也可以给团队成员带来更多成长的机会，让他们有机会去造一些重复却又具有一定创新的轮子。

我们反对的，是毫无新意的重复造轮子，对于面向解决具体业务域问题的重复造轮子，技术 TL 还是要给与适当的鼓励与引导，这也是在保护未来团队有机会能够做出一些自主创新的土壤。


技术难题除了技术方案设计及落地外，背后还有一系列的其他工作。例如上线后对效果的观测、重点项目对于上下游改造和风险的了解程度、对于整个技改后续的计划（二期、三期的优化思路）等。


是基于业务对于时效性保障、稳定性、可扩展性和普适性的取舍。