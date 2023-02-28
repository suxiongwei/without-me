## 分布式锁&Redis相关的一些题目

**分布式锁的特点**

- 互斥性：同一时刻只能有一个线程持有锁
- 可重入性：同一节点上的同一个线程如果获取了锁之后能够再次获取锁
- 锁超时：和J.U.C中的锁一样支持锁超时，防止死锁
- 高性能和高可用：加锁和解锁需要高效，同时也需要保证高可用，防止分布式锁失效
- 具备阻塞和非阻塞性：能够及时从阻塞状态中被唤醒

**分布式锁的实现方式**
- 基于数据库
- 基于Redis
- 基于Zookeeper

### Redis实现分布式锁
#### 1. 利用setnx+expire命令 (错误的做法)
setnx和expire是分开的两步操作，不具有原子性，如果执行完第一条指令应用异常或者重启了，锁将无法过期。

一种改善方案就是使用Lua脚本来保证原子性（包含setnx和expire两条指令）

#### 2. 使用Lua脚本（包含setnx和expire两条指令）

#### 3. 使用 set key value [EX seconds][PX milliseconds][NX|XX] 命令 (正确做法)
Redis在 2.6.12 版本开始，为 SET 命令增加一系列选项：
`SET key value[EX seconds][PX milliseconds][NX|XX]`
- EX seconds: 设定过期时间，单位为秒
- PX milliseconds: 设定过期时间，单位为毫秒
- NX: 仅当key不存在时设置值
- XX: 仅当key存在时设置值

set命令的nx选项，就等同于setnx命令

```shell
127.0.0.1:6379> set unique_key 12345 EX 200 NX
OK
127.0.0.1:6379> keys *
1) "unique_key"
127.0.0.1:6379> set unique_key 123456 EX 200 NX
(nil)
```

**value必须要具有唯一性**，我们可以用UUID来做，设置随机字符串保证唯一性，至于为什么要保证唯一性？假如value不是随机字符串，而是一个固定值，那么就可能存在下面的问题：

1. 客户端1获取锁成功
2. 客户端1在某个操作上阻塞了太长时间
3. 设置的key过期了，锁自动释放了
4. 客户端2获取到了对应同一个资源的锁
5. 客户端1从阻塞中恢复过来，因为value值一样，所以执行释放锁操作时就会释放掉客户端2持有的锁，这样就会造成问题

所以通常来说，在释放锁时，我们需要对value进行验证

**释放锁的实现**

释放锁时需要验证value值，也就是说我们在获取锁的时候需要设置一个value，不能直接用del key这种粗暴的方式，因为直接del key任何客户端都可以进行解锁了，所以解锁时，我们需要判断锁是否是自己的，基于value值来判断

> 以上都是针对单节点的实现，如果是集群环境还会出现别的问题
> 比如：比如说A客户端在Redis的master节点上拿到了锁，但是这个加锁的key还没有同步到slave节点，master故障，发生故障转移，一个slave节点升级为master节点，B客户端也可以获取同个key的锁，但客户端A也已经拿到锁了，这就导致多个客户端都拿到锁。

#### 4. Redlock算法 与 Redisson 实现

##### Redlock算法
假设有5个独立的Redis节点（注意这里的节点可以是5个Redis单master实例，也可以是5个Redis Cluster集群，但并不是有5个主节点的cluster集群）：

- 获取当前Unix时间，以毫秒为单位
- 依次尝试从5个实例，使用相同的key和具有唯一性的value(例如UUID)获取锁，当向Redis请求获取锁时，客户端应该设置一个网络连接和响应超时时间，这个超时时间应用小于锁的失效时间，例如你的锁自动失效时间为10s，则超时时间应该在5~50毫秒之间，这样可以避免服务器端Redis已经挂掉的情况下，客户端还在死死地等待响应结果。如果服务端没有在规定时间内响应，客户端应该尽快尝试去另外一个Redis实例请求获取锁
- 客户端使用当前时间减去开始获取锁时间（步骤1记录的时间）就得到获取锁使用的时间，当且仅当从大多数(N/2+1，这里是3个节点)的Redis节点都取到锁，并且使用的时间小于锁失败时间时，锁才算获取成功。
- 如果取到了锁，key的真正有效时间等于有效时间减去获取锁所使用的时间（步骤3计算的结果）
- 如果某些原因，获取锁失败（没有在至少N/2+1个Redis实例取到锁或者取锁时间已经超过了有效时间），客户端应该在所有的Redis实例上进行解锁（即便某些Redis实例根本就没有加锁成功，防止某些节点获取到锁但是客户端没有得到响应而导致接下来的一段时间不能被重新获取锁）

##### Redisson 实现
Redisson实现简单分布式锁

对于Java用户而言，我们经常使用Jedis，Jedis是Redis的Java客户端，除了Jedis之外，Redisson也是Java的客户端，Jedis是阻塞式I/O，而Redisson底层使用Netty可以实现非阻塞I/O，该客户端封装了锁的，继承了J.U.C的Lock接口，所以我们可以像使用ReentrantLock一样使用Redisson，具体使用过程如下。

Redisson可以配置哪些模式？
- 单节点模式
- cluster模式
- 哨兵模式

首先加入POM依赖
```pom
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson</artifactId>
    <version>3.10.6</version>
</dependency>
```
使用Redisson，代码如下(与使用ReentrantLock类似）
```java
// 1. 配置文件
Config config = new Config();
config.useSingleServer()
.setAddress("redis://127.0.0.1:6379")
.setPassword(RedisConfig.PASSWORD)
.setDatabase(0);
//2. 构造RedissonClient
RedissonClient redissonClient = Redisson.create(config);

//3. 设置锁定资源名称
RLock lock = redissonClient.getLock("redlock");
lock.lock();
try {
    System.out.println("获取锁成功，实现业务逻辑");
    Thread.sleep(10000);
} catch (InterruptedException e) {
    e.printStackTrace();
} finally {
    lock.unlock();
}
```

### 一些面试题
**Redis分布式锁过期了但业务还没有执行完，怎么办?**

设置锁成功后，启动一个watchdog，每隔一段时间(比如10s)为当前分布式锁续约，也就是每隔10s重新设置当前key的超时时间。

Redisson 提供了这个机制：

具体原理是：如果客户端1加锁成功，这个分布式锁超时时间默认是30秒(可以通过Config.lockWatchdogTimeout来修改)。

加锁成功后，就会启动一个watchdog，watchdog是一个后台线程，会每隔10秒检查一下客户端1是否还持有锁key，如果是，就延长锁key的生存时间，延长操作就是再次把锁key的超时时间设置成30s。

**如何保证redis中存放的都是热点数据？**

> 配置 redis的数据淘汰策略

限定 Redis 占用的内存，Redis 会根据自身数据淘汰策略，留下热数据到内存。 淘汰策略设置为volatile-lru或者allkeys-lru。

**假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如何将它们全部找出来**

使用keys指令可以扫出指定模式的key列表，但是在key多的时候会出现问题

> 因为redis 是单线程 所以一次性操作大量的数据 可能会导致业务出现卡顿

解决办法

> 使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长.

