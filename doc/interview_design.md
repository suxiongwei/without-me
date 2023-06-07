## 设计题

- [秒杀系统](https://github.com/suxiongwei/without-me/blob/main/doc/SECONDS_KILL_DESIGN.md)
- [扫码登陆](https://github.com/suxiongwei/without-me/blob/main/doc/SCAN_LOGIN.md)
- [延迟队列](https://github.com/suxiongwei/without-me/blob/main/doc/DELAY_QUEUE.md)
- [分布式锁&Redis相关的一些题目](https://github.com/suxiongwei/without-me/blob/main/doc/DISTRIBUTED_LOCK.md)
- [平时的项目技术设计时主要考虑的点，如何保证技术方案的可行性和扩展性]()
- [一个2G左右的文本文件，统计其中某个单词出现的次数，JVM只要512M，给出实现思路]()
- [布隆过滤器BloomFilter](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/BloomFilterDemo.java)
- [限流算法](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/guava/RateLimiterTest.java)
- [常见软件的QPS](https://github.com/suxiongwei/without-me/blob/main/doc/%E5%B8%B8%E8%A7%81%E8%BD%AF%E4%BB%B6%E7%9A%84QPS.md)
- [领域驱动设计在互联网业务开发中的实践](https://tech.meituan.com/2017/12/22/ddd-in-practice.html)
- [一般实现分布式锁都有哪些方式？使用 Redis 如何设计分布式锁？使用 zk 来设计分布式锁可以吗？这两种分布式锁的实现方式哪种效率比较高？](https://github.com/doocs/advanced-java/blob/main/docs/distributed-system/distributed-lock-redis-vs-zookeeper.md)
- [接口鉴权](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/auth/AuthUtils.java)
- [工厂模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/factory)
- [单例模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/singleton)
- [装饰器模式](https://github.com/suxiongwei/without-me/tree/main/src/main/java/com/sxw/learn/design/decorator)


#### 淘宝的订单系统怎么设计?
<details>
<summary>展开</summary>
1.业务主体分析，相同主体且有er关系的表使用相同的分片规则，这样就能避免分布式事务问题。
2.分片键设计，比如订单及订单商品等表按照会员id后x位分片。同时订单id需要带上会员id后x位。（淘宝后6位是用户id，不变）
3.全局索引设计，比如订单表除了根据会员id分片之外还需要根据店铺id分片。并且全局索引最好能够覆盖查询所需的字段，避免回表。
4.数据均衡分析，主要是测试作为分片键的值在按照一定的库表数拆分后，能否均衡地落到每个库表。
5.功能分析，主要分析被分片的表的高频查询能否都带上分片键去查。如根据会员id分页查询订单数据。新增订单。修改订单状态。根据订单id查询订单。根据商户id分页查询订单。根据订单id查询订单商品。
6.分布式id生成方案：如订单号使用雪花id+会员id后6位。同时会员id后6位需要保证是高区分度递增的。
7.全局搜索设计：一般采用cdc技术同步到搜索引擎。
8.统计查询-olap：一般同步到mmp数据库。
9.扩容方案：一般是两倍扩容
10.数据迁移方案：一般是全量迁移+实时同步。
</details>

#### [为何Kafka这么"快"?](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E4%B8%BA%E4%BD%95Kafka%E8%BF%99%E4%B9%88%22%E5%BF%AB%22%EF%BC%9F.md)
#### [雪花算法(SnowFlake)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E9%9B%AA%E8%8A%B1%E7%AE%97%E6%B3%95(SnowFlake).md)
