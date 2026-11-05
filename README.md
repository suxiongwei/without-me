# Java 后端与数据平台学习笔记

围绕 Java、数据库、分布式系统与数据平台持续学习。这里包含技术原理、图解、边界分析、SQL 与算法练习，以及可定位到源码的示例。

[开始阅读](doc/LEARNING_PATHS.md) · [50 道技术问答](doc/技术学习笔记.md) · [6 道综合练习](doc/practice.md) · [技术边界速查](doc/quick-reference.md) · [版本与资料](doc/references.md)

全部文章按主题在下方展开；算法、代码练习与运行诊断可以穿插学习。

## 选择阅读路线

| 路线 | 推荐顺序 | 入口 |
| --- | --- | --- |
| 后端基础 | Java → 并发/JVM → Spring → MySQL → Redis/Kafka → 分布式设计 | [后端基础路线](doc/LEARNING_PATHS.md#后端基础路线) |
| 数据平台 | SQL → Kafka → Flink → ClickHouse → 数据质量与调度 | [数据平台路线](doc/LEARNING_PATHS.md#数据平台路线) |
| 问题排查 | CPU/内存 → 接口延迟 → 慢 SQL → 消息积压 → 反压与对账 | [问题排查路线](doc/LEARNING_PATHS.md#问题排查路线) |

## 分类导航

点击分类定位到本页明细，点击文章或知识点直接阅读正文。

| 分类 | 内容 | 本页明细 |
| --- | --- | --- |
| Java 与 JVM | 集合、并发、线程池、异步结果与 JVM | [3 篇文档](#java-与-jvm) |
| Spring 与数据访问 | 容器、依赖注入、配置、代理、事务与 Web 调用链 | [7 篇文档](#spring-与数据访问) |
| 数据库与 SQL | 索引、事务、锁、窗口函数、聚合与对账 | [8 篇文档](#数据库与-sql) |
| Redis 与分布式锁 | 缓存一致性、缓存故障、租约锁与延迟队列 | [3 篇文档](#redis-与分布式锁) |
| 消息队列与可靠消息 | Kafka、RocketMQ、Outbox、Inbox 与消息故障恢复 | [4 篇文档](#消息队列与可靠消息) |
| 数据平台与分析存储 | 采集、Flink、ClickHouse、数仓与数据质量 | [7 篇文档](#数据平台与分析存储) |
| 分布式设计与架构 | 幂等、状态机、事务、一致性、平台与设计模式 | [10 篇文档](#分布式设计与架构) |
| 计算机基础与网络 | TCP、网络协议、进程与虚拟内存 | [3 篇文档](#计算机基础与网络) |
| 算法与数据结构 | 排序、链表、树、图、动态规划、贪心与资源约束 | [14 篇文档](#算法与数据结构) |
| 工具与运行诊断 | JVM、接口性能、命令与容量评估 | [3 篇文档](#工具与运行诊断) |
| 学习导航与参考资料 | 问答总览、练习、图解、版本与文档维护 | [9 篇文档](#学习导航与参考资料) |
| 个人资料与成长 | 个人资料与成长记录 | [2 篇文档](#个人资料与成长) |

## 笔记明细

以下按主题列出全部 **73 篇文档**（含分类页、练习和参考资料），并展开 50 道技术问答、6 道练习的直达入口。

### Java 与 JVM

- [Java 基础、并发与 JVM 学习目录](doc/interview_java.md)
- [Java 集合与并发（Q01–Q06）](doc/topics/java-concurrency.md)
  - [Q01 HashMap 的原理和使用风险是什么](doc/topics/java-concurrency.md#q01-hashmap-的原理和使用风险是什么)
  - [Q02 ConcurrentHashMap 线程安全 为什么先判断再写仍有问题](doc/topics/java-concurrency.md#q02-concurrenthashmap-线程安全-为什么先判断再写仍有问题)
  - [Q03 volatile synchronized 和 CAS 怎么选](doc/topics/java-concurrency.md#q03-volatile-synchronized-和-cas-怎么选)
  - [Q04 线程池怎么执行任务 参数怎么确定](doc/topics/java-concurrency.md#q04-线程池怎么执行任务-参数怎么确定)
  - [Q05 CompletableFuture 并行调用要注意什么](doc/topics/java-concurrency.md#q05-completablefuture-并行调用要注意什么)
  - [Q06 ThreadLocal 为什么可能导致内存或上下文问题](doc/topics/java-concurrency.md#q06-threadlocal-为什么可能导致内存或上下文问题)
- [Future 与异步结果获取](doc/Future.md)

### Spring 与数据访问

- [Spring 与数据访问学习目录](doc/interview_spring.md)
- [Spring 事务与数据访问（Q07–Q10）](doc/topics/spring-data-access.md)
  - [Q07 Spring 事务为什么会看起来不生效](doc/topics/spring-data-access.md#q07-spring-事务为什么会看起来不生效)
  - [Q08 REQUIRED 与 REQUIRES_NEW 有什么区别](doc/topics/spring-data-access.md#q08-required-与-requires_new-有什么区别)
  - [Q09 Spring AOP 代理有什么边界](doc/topics/spring-data-access.md#q09-spring-aop-代理有什么边界)
  - [Q10 MyBatis 中参数绑定 缓存与查询数量怎么检查](doc/topics/spring-data-access.md#q10-mybatis-中参数绑定-缓存与查询数量怎么检查)
- [Autowired 与 Resource 的依赖注入规则](doc/@Autowired和@Resource注解的区别.md)
- [Autowired 自动装配实现](doc/@Autowired的实现原理.md)
- [配置类与普通组件中的 Bean 方法](doc/ConfigurationAndComponent.md)
- [Servlet Filter 与 Spring MVC Interceptor](doc/FILTERANDINTERCEPTOR.md)
- [Spring 多数据源与事务边界](doc/spring_dynamic_datasource.md)

### 数据库与 SQL

- [MySQL 与数据库原理学习目录](doc/interview_mysql.md)
- [数据库原理与 SQL 优化（Q13–Q20）](doc/topics/database-sql.md)
  - [Q13 一条慢 SQL 你会怎么优化](doc/topics/database-sql.md#q13-一条慢-sql-你会怎么优化)
  - [Q14 联合索引如何设计 为什么有索引也没用上](doc/topics/database-sql.md#q14-联合索引如何设计-为什么有索引也没用上)
  - [Q15 MVCC 隔离级别和锁是什么关系](doc/topics/database-sql.md#q15-mvcc-隔离级别和锁是什么关系)
  - [Q16 乐观锁 悲观锁与唯一约束分别解决什么](doc/topics/database-sql.md#q16-乐观锁-悲观锁与唯一约束分别解决什么)
  - [Q17 深分页和大批量导出怎么设计](doc/topics/database-sql.md#q17-深分页和大批量导出怎么设计)
  - [Q18 Oracle 和 MySQL 的关键行为差异是什么](doc/topics/database-sql.md#q18-oracle-和-mysql-的关键行为差异是什么)
  - [Q19 如何修复线上错误数据](doc/topics/database-sql.md#q19-如何修复线上错误数据)
  - [Q20 报表金额为什么可能被关联查询放大](doc/topics/database-sql.md#q20-报表金额为什么可能被关联查询放大)
- [SQL 与分析查询、配套练习](doc/SQL.md)
  - [E01 每个订单取最新一条状态记录](doc/practice.md#e01-每个订单取最新一条状态记录)
  - [E02 查询每个部门支付金额排名前三的客户](doc/practice.md#e02-查询每个部门支付金额排名前三的客户)
  - [E03 对账发现一边缺记录 或金额不同](doc/practice.md#e03-对账发现一边缺记录-或金额不同)
  - [E06 报表金额变成业务库的两倍 如何定位](doc/practice.md#e06-报表金额变成业务库的两倍-如何定位)
- [SQL 窗口函数](doc/window-function.md)
- [乐观更新、悲观锁与库存约束](doc/mysql_lock.md)
- [数据库 ACID 四大特性](src/main/java/com/sxw/learn/leetcode/md/数据库ACID四大特性.md)
- [redo log 与 binlog 为什么需要两阶段提交](src/main/java/com/sxw/learn/leetcode/md/redolog与binlog为什么需要两阶段提交？.md)
- [稀疏索引](src/main/java/com/sxw/learn/leetcode/md/稀疏索引.md)

### Redis 与分布式锁

- [Redis 缓存与租约锁（Q21–Q23）](doc/topics/redis-cache.md)
  - [Q21 缓存与数据库如何保持一致](doc/topics/redis-cache.md#q21-缓存与数据库如何保持一致)
  - [Q22 缓存穿透 击穿和雪崩怎么处理](doc/topics/redis-cache.md#q22-缓存穿透-击穿和雪崩怎么处理)
  - [Q23 Redis 分布式锁能保证什么](doc/topics/redis-cache.md#q23-redis-分布式锁能保证什么)
- [Redis 分布式锁实现与边界](doc/DISTRIBUTED_LOCK.md)
- [Redis 延迟队列](doc/DELAY_QUEUE.md)

### 消息队列与可靠消息

- [Transactional Outbox、RocketMQ 与 Inbox 幂等消费](doc/topics/outbox-rocketmq-inbox.md)
  - [事务边界与整体链路](doc/topics/outbox-rocketmq-inbox.md#整体链路与两个本地事务)
  - [事件 ID、业务效果键与消息身份](doc/topics/outbox-rocketmq-inbox.md#事件身份业务身份与消息身份)
  - [表结构、去重键与索引](doc/topics/outbox-rocketmq-inbox.md#教学表结构与索引)
  - [Relay 领取、租约、投递与恢复](doc/topics/outbox-rocketmq-inbox.md#relay-如何领取投递与恢复)
  - [Inbox 与消费端业务的原子提交](doc/topics/outbox-rocketmq-inbox.md#消费端如何提交-inbox-与业务)
  - [状态机、业务去重与乱序处理](doc/topics/outbox-rocketmq-inbox.md#状态机如何处理重复与乱序)
  - [消费超时、宕机与故障窗口](doc/topics/outbox-rocketmq-inbox.md#消费超时与服务宕机的完整推演)
  - [重试、死信与人工重放](doc/topics/outbox-rocketmq-inbox.md#重试死信与人工重放)
  - [与事务消息、Saga、TCC 的关系](doc/topics/outbox-rocketmq-inbox.md#与事务消息saga-和-tcc-的关系)
- [Kafka 消费与可靠性（Q24–Q28）](doc/topics/kafka.md)
  - [Q24 Kafka 为什么会重复消费 怎么避免业务重复](doc/topics/kafka.md#q24-kafka-为什么会重复消费-怎么避免业务重复)
  - [Q25 Kafka 顺序性怎么理解](doc/topics/kafka.md#q25-kafka-顺序性怎么理解)
  - [Q26 Kafka 积压怎么定位和处理](doc/topics/kafka.md#q26-kafka-积压怎么定位和处理)
  - [Q27 如何设计失败重试和死信处理](doc/topics/kafka.md#q27-如何设计失败重试和死信处理)
  - [Q28 如何理解 Kafka 的可靠性与恰好一次](doc/topics/kafka.md#q28-如何理解-kafka-的可靠性与恰好一次)
- [Kafka 消费状态与运维命令](doc/kafka.md)
- [为何 Kafka 这么“快”](src/main/java/com/sxw/learn/leetcode/md/为何Kafka这么“快”？.md)

### 数据平台与分析存储

- [数据平台与流式计算学习目录](doc/interview_bigdata.md)
- [数据平台与 Flink（Q29–Q38）](doc/topics/flink.md)
  - [Q29 离线与实时数仓有什么区别 如何选择](doc/topics/flink.md#q29-离线与实时数仓有什么区别-如何选择)
  - [Q30 全量与增量采集如何衔接](doc/topics/flink.md#q30-全量与增量采集如何衔接)
  - [Q31 Event Time Watermark 与迟到数据如何解释](doc/topics/flink.md#q31-event-time-watermark-与迟到数据如何解释)
  - [Q32 Flink State 与 Checkpoint 分别是什么](doc/topics/flink.md#q32-flink-state-与-checkpoint-分别是什么)
  - [Q33 Checkpoint 与 Savepoint 有什么区别](doc/topics/flink.md#q33-checkpoint-与-savepoint-有什么区别)
  - [Q34 开启 Checkpoint 就能保证写入 ClickHouse 不重不丢吗](doc/topics/flink.md#q34-开启-checkpoint-就能保证写入-clickhouse-不重不丢吗)
  - [Q35 反压和数据倾斜怎么区分](doc/topics/flink.md#q35-反压和数据倾斜怎么区分)
  - [Q36 Flink 关联和状态膨胀如何处理](doc/topics/flink.md#q36-flink-关联和状态膨胀如何处理)
  - [Q37 实时任务失败或 Checkpoint 超时怎么排查](doc/topics/flink.md#q37-实时任务失败或-checkpoint-超时怎么排查)
  - [Q38 数据质量 对账和补数怎么设计](doc/topics/flink.md#q38-数据质量-对账和补数怎么设计)
- [Flink 运行架构与作业提交](doc/Flink.md)
- [ClickHouse 分析存储（Q39–Q45）](doc/topics/clickhouse.md)
  - [Q39 为什么 ClickHouse 适合分析查询](doc/topics/clickhouse.md#q39-为什么-clickhouse-适合分析查询)
  - [Q40 MergeTree 排序键 分区与主键如何理解](doc/topics/clickhouse.md#q40-mergetree-排序键-分区与主键如何理解)
  - [Q41 ReplacingMergeTree 会立即去重吗](doc/topics/clickhouse.md#q41-replacingmergetree-会立即去重吗)
  - [Q42 ClickHouse 写入慢或小 part 太多 怎么处理](doc/topics/clickhouse.md#q42-clickhouse-写入慢或小-part-太多-怎么处理)
  - [Q43 ClickHouse 查询慢 怎么分析](doc/topics/clickhouse.md#q43-clickhouse-查询慢-怎么分析)
  - [Q44 物化视图与聚合表有什么容易踩的坑](doc/topics/clickhouse.md#q44-物化视图与聚合表有什么容易踩的坑)
  - [Q45 副本与分片分别解决什么问题](doc/topics/clickhouse.md#q45-副本与分片分别解决什么问题)
- [列式存储与压缩](doc/column-based.md)
- [ROLLUP 与 CUBE 聚合维度](doc/rollup-cube.md)
- [大数据题目与思路](src/main/java/com/sxw/learn/leetcode/bigdata/大数据题目.md)

### 分布式设计与架构

- [缓存与分布式设计学习目录](doc/interview_design.md)
- [分布式一致性与平台设计（Q46–Q50）](doc/topics/distributed-systems.md)
  - [Q46 审批回调如何做到幂等](doc/topics/distributed-systems.md#q46-审批回调如何做到幂等)
  - [Q47 回调乱序 或远程成功但本地超时 怎么办](doc/topics/distributed-systems.md#q47-回调乱序-或远程成功但本地超时-怎么办)
  - [Q48 本地事务与远程调用 如何保证最终一致](doc/topics/distributed-systems.md#q48-本地事务与远程调用-如何保证最终一致)
  - [Q49 设计一个 BI 数据查询 API 平台](doc/topics/distributed-systems.md#q49-设计一个-bi-数据查询-api-平台)
  - [Q50 设计一个调度与补数管理能力](doc/topics/distributed-systems.md#q50-设计一个调度与补数管理能力)
  - [E04 手画一个数据库幂等回调处理流程](doc/practice.md#e04-手画一个数据库幂等回调处理流程)
- [分布式事务：2PC、XA 与 TCC](src/main/java/com/sxw/learn/leetcode/md/分布式事务.md)
- [技术方案检查清单](doc/design-checklist.md)
- [设计模式图解](doc/design-patterns.md)
- [限流算法与容量边界](doc/限流算法.md)
- [扫码登录原理与流程](doc/SCAN_LOGIN.md)
- [秒杀系统设计](doc/SECONDS_KILL_DESIGN.md)
- [一致性 Hash 算法](src/main/java/com/sxw/learn/leetcode/hash/一致性hash算法.md)
- [雪花算法 SnowFlake](src/main/java/com/sxw/learn/leetcode/md/雪花算法(SnowFlake).md)

### 计算机基础与网络

- [计算机基础与网络学习目录](doc/interview_jisuanjijichu.md)
- [虚拟内存原理](src/main/java/com/sxw/learn/leetcode/md/虚拟内存.md)
- [守护进程、僵尸进程与孤儿进程](src/main/java/com/sxw/learn/leetcode/md/守护进程、僵尸进程和孤儿进程的理解.md)

### 算法与数据结构

- [算法题型与代码目录](doc/LeetCode.md)
  - [E05 合并有交集的闭区间](doc/practice.md#e05-合并有交集的闭区间)
- [排序算法](src/main/java/com/sxw/learn/leetcode/sort/sort.md)
- [字符串](src/main/java/com/sxw/learn/leetcode/str/字符串.md)
- [跳表](src/main/java/com/sxw/learn/leetcode/linkedlist/SkipList.md)
- [二叉查找树、平衡树、红黑树、B 树与 B+ 树对比](src/main/java/com/sxw/learn/leetcode/tree/二叉查找树&平衡二叉树&红黑树&B-树&B+树性能对比.md)
- [哈希结构](src/main/java/com/sxw/learn/leetcode/hash/hash.md)
- [图与图算法](src/main/java/com/sxw/learn/leetcode/graph/graph.md)
- [动态规划](src/main/java/com/sxw/learn/leetcode/dp/dp.md)
- [树型 DP 套路](src/main/java/com/sxw/learn/leetcode/dp/树型DP.md)
- [贪心算法](src/main/java/com/sxw/learn/leetcode/greedy/贪心算法.md)
- [单调栈](src/main/java/com/sxw/learn/leetcode/other/单调栈.md)
- [滑动窗口](src/main/java/com/sxw/learn/leetcode/other/滑动窗口.md)
- [观察表法](src/main/java/com/sxw/learn/leetcode/other/观察表法.md)
- [内存受限时统计大文件词频](doc/resource-limits.md)

### 工具与运行诊断

- [工具、命令与运行诊断学习目录](doc/linux.md)
- [Java 运行诊断（Q11–Q12）](doc/topics/runtime-diagnostics.md)
  - [Q11 Java 进程 CPU 高或内存持续增长 怎么排查](doc/topics/runtime-diagnostics.md#q11-java-进程-cpu-高或内存持续增长-怎么排查)
  - [Q12 接口很慢 但数据库不慢 怎么定位](doc/topics/runtime-diagnostics.md#q12-接口很慢-但数据库不慢-怎么定位)
- [容量与性能评估](doc/常见软件的QPS.md)

### 学习导航与参考资料

- [50 道技术问答与 6 道练习总索引](doc/技术学习笔记.md)
- [SQL、编程与故障分析综合练习](doc/practice.md)
- [后端、数据平台与问题排查阅读路线](doc/LEARNING_PATHS.md)
- [技术边界速查](doc/quick-reference.md)
- [适用版本与官方参考资料](doc/references.md)
- [图解目录](doc/DIAGRAMS.md)
- [51 张历史图片素材目录](doc/assets/README.md)
- [文档维护约定](doc/WRITING.md)
- [全部文档与文件位置索引](doc/INDEX.md)

### 个人资料与成长

- [成长记录](doc/interview_chengzhang.md)
- [个人资料](src/main/java/com/sxw/learn/leetcode/简历.md)

## 阅读与维护

每个知识点按问题、示例、原理、边界与练习理解。核心答案直接展示，较长的补充和练习答案可以折叠。新增内容遵循[文档约定](doc/WRITING.md)，图片与原图见[素材目录](doc/assets/README.md)。
