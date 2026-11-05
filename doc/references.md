# 适用版本与参考资料

[首页](../README.md) · [问答索引](技术学习笔记.md) · [文档维护约定](WRITING.md)

## 阅读前先核对版本

| 领域 | 本仓库学习基线 | 使用时需要额外确认 |
| --- | --- | --- |
| Java | `pom.xml` 声明 Java 8；并发示例参照 Java 8 API | 不同 JDK 的集合实现、GC、诊断命令与线程模型 |
| Spring | 工程 Spring Boot 2.2.6.RELEASE；事务原理参考 Spring Framework 5.2.5 | 代理类型、事务管理器、异常规则及升级后的方法可见性支持 |
| MyBatis | MyBatis 3 文档；不是该工程已集成版本的承诺 | Mapper 参数、缓存作用域和插件行为 |
| MySQL | 窗口 SQL 使用 MySQL 8.x；InnoDB 原理参考 8.4 手册 | 隔离级别、索引、字符集、SQL mode 与执行计划 |
| Redis | 工程 Jedis 3.3.0、Redisson 3.13.1 | 服务端版本、锁租约、续期和故障切换 |
| Kafka | 旧命令示例含 3.5.0；设计资料固定到 4.1 | 客户端与 Broker 版本、分区器、消费组协议、事务配置 |
| RocketMQ | 可靠消息专题参考官方 5.0 文档；4.x / 5.x 客户端语义分开说明，工程未接入客户端 | 消费类型、确认、重试、顺序单元、事务消息及持久化配置 |
| Flink | 图解固定参考 1.20 文档 | 连接器、状态兼容性、窗口和 Checkpoint 配置 |
| ClickHouse | 原理按官方 MergeTree 系列资料学习，未锁定部署版本 | 引擎、排序键、去重和物化视图具体语义 |

工程依赖记录与独立技术主题分开理解：文档涉及某个组件，不代表仓库已经配置并验证该组件。资料核对日期：2026-11-05；运行环境与命令执行结果需自行记录。

## 官方资料

以下为官方参考资料。涉及配置、连接器和版本特性时，按实际使用版本核对。

<a id="s01"></a>

[S01 Oracle Java 8 HashMap API](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

<a id="s02"></a>

[S02 Oracle Java 8 ConcurrentHashMap API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)

<a id="s03"></a>

[S03 Oracle Java 8 ThreadPoolExecutor API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html)

<a id="s04"></a>

[S04 Oracle Java 8 CompletableFuture API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)

<a id="s05"></a>

[S05 Spring Framework Using Transactional](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/data-access.html#transaction-declarative-annotations)

<a id="s06"></a>

[S06 Spring Framework Transaction Propagation](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/data-access.html#tx-propagation)

<a id="s07"></a>

[S07 MyBatis Mapper XML Files](https://mybatis.org/mybatis-3/sqlmap-xml.html)

<a id="s08"></a>

[S08 MySQL 8.4 EXPLAIN Statement](https://dev.mysql.com/doc/refman/8.4/en/explain.html)

<a id="s09"></a>

[S09 MySQL 8.4 InnoDB Transaction Isolation Levels](https://dev.mysql.com/doc/refman/8.4/en/innodb-transaction-isolation-levels.html)

<a id="s10"></a>

[S10 Apache Kafka Design](https://kafka.apache.org/41/design/design/)

<a id="s11"></a>

[S11 Apache Flink Timely Stream Processing](https://nightlies.apache.org/flink/flink-docs-release-1.20/docs/concepts/time/)

<a id="s12"></a>

[S12 Apache Flink Fault Tolerance](https://nightlies.apache.org/flink/flink-docs-release-1.20/docs/learn-flink/fault_tolerance/)

<a id="s13"></a>

[S13 ClickHouse MergeTree](https://clickhouse.com/docs/reference/engines/table-engines/mergetree-family/mergetree)

<a id="s14"></a>

[S14 ClickHouse ReplacingMergeTree](https://clickhouse.com/docs/reference/engines/table-engines/mergetree-family/replacingmergetree)

<a id="s15"></a>

[S15 ClickHouse Incremental Materialized Views](https://clickhouse.com/docs/materialized-view/incremental-materialized-view)

<a id="s16"></a>

[S16 Redis Distributed Locks](https://redis.io/docs/latest/develop/clients/patterns/distributed-locks/)

<a id="s17"></a>

[S17 RocketMQ Sending Retry](https://rocketmq.apache.org/docs/featureBehavior/05sendretrypolicy/)

<a id="s18"></a>

[S18 RocketMQ Consumption Retry](https://rocketmq.apache.org/docs/featureBehavior/10consumerretrypolicy/)

<a id="s19"></a>

[S19 RocketMQ Basic Best Practices](https://rocketmq.apache.org/docs/bestPractice/01bestpractice/)

<a id="s20"></a>

[S20 RocketMQ Transaction Message](https://rocketmq.apache.org/docs/featureBehavior/04transactionmessage/)

<a id="s21"></a>

[S21 Transactional Outbox Pattern](https://microservices.io/patterns/data/transactional-outbox.html)

<a id="s22"></a>

[S22 Idempotent Consumer Pattern](https://microservices.io/patterns/communication-style/idempotent-consumer.html)

<a id="s23"></a>

[S23 MySQL 8.4 Locking Reads](https://dev.mysql.com/doc/refman/8.4/en/innodb-locking-reads.html)

## 配图与 Markdown

- [GitHub Mermaid 图解](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-diagrams)
- [GitHub 相对链接](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes)
