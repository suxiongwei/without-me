# 缓存与分布式设计

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

先识别状态归属与原子范围，再选缓存、锁、幂等与补偿机制，最后组合为平台能力。

**版本与前提：** 方案的事务、租约、重试与幂等分别依赖数据库、协调服务及远程协议，按每篇专题的前提理解。

## 推荐阅读

- [Q21 缓存与数据库如何保持一致](topics/redis-cache.md#q21-缓存与数据库如何保持一致)
- [Q22 缓存穿透 击穿和雪崩怎么处理](topics/redis-cache.md#q22-缓存穿透-击穿和雪崩怎么处理)
- [Q23 Redis 分布式锁能保证什么](topics/redis-cache.md#q23-redis-分布式锁能保证什么)
- [Q46 审批回调如何做到幂等](topics/distributed-systems.md#q46-审批回调如何做到幂等)
- [Q47 回调乱序 或远程成功但本地超时 怎么办](topics/distributed-systems.md#q47-回调乱序-或远程成功但本地超时-怎么办)
- [Q48 本地事务与远程调用 如何保证最终一致](topics/distributed-systems.md#q48-本地事务与远程调用-如何保证最终一致)
- [Q49 设计一个 BI 数据查询 API 平台](topics/distributed-systems.md#q49-设计一个-bi-数据查询-api-平台)
- [Q50 设计一个调度与补数管理能力](topics/distributed-systems.md#q50-设计一个调度与补数管理能力)
- [E04 手画一个数据库幂等回调处理流程](practice.md#e04-手画一个数据库幂等回调处理流程)

## 配套专题与练习

- [支付超时、重复请求与结果确认](topics/payment-idempotency.md)
- [Saga 编排、资源预留与跨服务补偿](topics/saga-tcc-workflow.md)
- [Transactional Outbox、RocketMQ 与 Inbox 幂等消费](topics/outbox-rocketmq-inbox.md)
- [一致性 Hash](../src/main/java/com/sxw/learn/leetcode/hash/一致性hash算法.md)
- [分布式事务方案](../src/main/java/com/sxw/learn/leetcode/md/分布式事务.md)
- [分布式锁实现边界](DISTRIBUTED_LOCK.md)
- [延迟队列](DELAY_QUEUE.md)
- [限流算法](限流算法.md)
- [设计模式图解](design-patterns.md)
- [扫码登录](SCAN_LOGIN.md)
- [秒杀系统](SECONDS_KILL_DESIGN.md)

## 补充笔记与代码

- [平时的项目技术设计时主要考虑的点，如何保证技术方案的可行性和扩展性](design-checklist.md)
- [一个2G左右的文本文件，统计其中某个单词出现的次数，JVM只要512M，给出实现思路](resource-limits.md)
- [布隆过滤器BloomFilter](../src/main/java/com/sxw/learn/guava/BloomFilterDemo.java)
- [限流算法](../src/main/java/com/sxw/learn/guava/RateLimiterTest.java)
- [常见软件的QPS](常见软件的QPS.md)
- [领域驱动设计在互联网业务开发中的实践](https://tech.meituan.com/2017/12/22/ddd-in-practice.html)
- [一般实现分布式锁都有哪些方式？使用 Redis 如何设计分布式锁？使用 zk 来设计分布式锁可以吗？这两种分布式锁的实现方式哪种效率比较高？](https://github.com/doocs/advanced-java/blob/main/docs/distributed-system/distributed-lock-redis-vs-zookeeper.md)
- [接口鉴权](../src/main/java/com/sxw/learn/auth/AuthUtils.java)
- [工厂模式](../src/main/java/com/sxw/learn/design/factory)
- [单例模式](../src/main/java/com/sxw/learn/design/singleton)
- [装饰器模式](../src/main/java/com/sxw/learn/design/decorator)

### 淘宝的订单系统怎么设计?

1. 业务主体分析，相同主体且有er关系的表使用相同的分片规则，这样就能避免分布式事务问题。
2. 分片键设计，比如订单及订单商品等表按照会员id后x位分片。同时订单id需要带上会员id后x位。（淘宝后6位是用户id，不变）
3. 全局索引设计，比如订单表除了根据会员id分片之外还需要根据店铺id分片。并且全局索引最好能够覆盖查询所需的字段，避免回表。
4. 数据均衡分析，主要是测试作为分片键的值在按照一定的库表数拆分后，能否均衡地落到每个库表。
5. 功能分析，主要分析被分片的表的高频查询能否都带上分片键去查。如根据会员id分页查询订单数据。新增订单。修改订单状态。根据订单id查询订单。根据商户id分页查询订单。根据订单id查询订单商品。
6. 分布式id生成方案：如订单号使用雪花id+会员id后6位。同时会员id后6位需要保证是高区分度递增的。
7. 全局搜索设计：一般采用cdc技术同步到搜索引擎。
8. 统计查询-olap：一般同步到mmp数据库。
9. 扩容方案：一般是两倍扩容
10. 数据迁移方案：一般是全量迁移+实时同步。

### [为何Kafka这么"快"?](../src/main/java/com/sxw/learn/leetcode/md/为何Kafka这么“快”？.md)

### [雪花算法(SnowFlake)](../src/main/java/com/sxw/learn/leetcode/md/雪花算法(SnowFlake).md)
