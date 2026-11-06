# 阅读路线

[首页](../README.md) · [全部问答](技术学习笔记.md) · [图解目录](DIAGRAMS.md)

按知识依赖阅读，不设固定完成期限。第一次阅读先建立模型；第二次用反例和边界检查理解；最后独立完成练习，再回看代码。各路线共享专题，交叉部分直接跳转到同一篇正文。

## 后端基础路线

| 顺序 | 学习内容 | 需要能够解释 | 实践入口 |
| --- | --- | --- | --- |
| 1 | [Java 集合与并发](topics/java-concurrency.md) | 单次操作安全、复合操作原子性、可见性和任务排队 | [JUC 示例](../src/main/java/com/sxw/learn/juc) |
| 2 | [JVM 与补充知识](interview_java.md#补充笔记与代码) | 对象、引用、GC Roots 与运行时行为的版本边界 | [JVM 示例](../src/main/java/com/sxw/learn/jvm) |
| 3 | [Spring 与数据访问](topics/spring-data-access.md) | 代理、事务传播和 SQL 访问是否落在同一事务中 | [Spring 示例](../src/main/java/com/sxw/learn/spring) |
| 4 | [数据库与 SQL](topics/database-sql.md) | 访问路径、快照读、锁与查询粒度 | [SQL 练习](SQL.md) |
| 5 | [缓存](topics/redis-cache.md)与[消息](topics/kafka.md) | 失效窗口、重复处理、顺序和下游容量 | [锁的实现细节](DISTRIBUTED_LOCK.md) |
| 6 | [分布式一致性与平台设计](topics/distributed-systems.md) | 本地原子提交、远程未知状态和对账 | [幂等练习 E04](practice.md#e04-手画一个数据库幂等回调处理流程) |

进阶串联：[Transactional Outbox、RocketMQ 与 Inbox](topics/outbox-rocketmq-inbox.md)。把本地事务、消息重投、唯一约束和状态机放进一条完整链路，按故障位置逐步推演。

## 数据平台路线

| 顺序 | 学习内容 | 需要能够解释 |
| --- | --- | --- |
| 1 | [SQL 与窗口函数](SQL.md) | 明细粒度、聚合粒度、排名并列与 JOIN 放大 |
| 2 | [Kafka](topics/kafka.md) | 分区、消费组、offset 与重复消费 |
| 3 | [采集、时间和状态](topics/flink.md) | 全量增量衔接、Watermark、Checkpoint 与 Sink 边界 |
| 4 | [ClickHouse](topics/clickhouse.md) | 排序键、part、去重与增量物化视图 |
| 5 | [平台与调度](topics/distributed-systems.md#q49-设计一个-bi-数据查询-api-平台) | 参数和权限、调度实例、重试、补数与质量规则 |
| 6 | [报表金额排查 E06](practice.md#e06-报表金额变成业务库的两倍-如何定位) | 沿展示、汇总、明细、计算和源数据定位差异 |

## 问题排查路线

| 看到的症状 | 先读什么 | 先收集什么 |
| --- | --- | --- |
| CPU 高、内存增长 | [Java 运行诊断](topics/runtime-diagnostics.md) | 时间窗口、进程线程、栈、GC 与对象保留路径 |
| 接口慢 | [Q12 调用链定位](topics/runtime-diagnostics.md#q12-接口很慢-但数据库不慢-怎么定位) | 排队、连接池等待、下游耗时和重试次数 |
| SQL 慢 | [Q13 SQL 优化](topics/database-sql.md#q13-一条慢-sql-你会怎么优化) | 实际 SQL、参数、执行计划、行数与等待 |
| Kafka 积压 | [Q26 积压定位](topics/kafka.md#q26-kafka-积压怎么定位和处理) | 各分区 lag、输入速率、消费耗时与下游错误 |
| 重复消息、消费超时或宕机后结果未知 | [可靠消息故障窗口](topics/outbox-rocketmq-inbox.md#故障窗口对照表) | Outbox 状态、事件 ID、Inbox 终态、数据库提交与消费确认记录 |
| Flink 反压或恢复失败 | [Q35–Q37](topics/flink.md#q35-反压和数据倾斜怎么区分) | 算子指标、分区分布、Checkpoint 时长与失败原因 |
| 金额、条数不一致 | [E03 对账](practice.md#e03-对账发现一边缺记录-或金额不同)与[E06 口径排查](practice.md#e06-报表金额变成业务库的两倍-如何定位) | 相同时间/状态/币种范围下的业务键与金额 |

## 系统设计扩展路线

先完成事务、唯一约束、消息重投和状态机基础，再按下表串联。每篇均提供完整题目、协议示例、故障窗口、参考回答与手工推演；先独立回答，再用反例检查保证范围。

| 顺序 | 专题 | 需要能够解释 |
| --- | --- | --- |
| 1 | [支付超时、重复请求与结果确认](topics/payment-idempotency.md) | 支付意图与尝试分离；未知结果查询；业务仲裁和回调幂等 |
| 2 | [Saga 编排、资源预留与跨服务补偿](topics/saga-tcc-workflow.md) | 持久编排、补偿语义；资源预留；空回滚与防悬挂 |
| 3 | [租约失效、Fencing 与旧执行者隔离](topics/lease-fencing.md) | 资源端拒绝旧 Epoch；同库仲裁；跨资源保证边界 |
| 4 | [大规模异步导出、一致性与断点恢复](topics/resumable-export.md) | 持久快照、稳定分页；不可变分片；完整结果发布 |
| 5 | [全量快照、CDC 衔接与可恢复数据同步](topics/snapshot-cdc.md) | 一致快照与日志边界；连续应用进度；删除墓碑和 DDL |
| 6 | [Flink 与 ClickHouse 的重放、去重和汇总一致性](topics/flink-clickhouse-consistency.md) | 检查点与外部写入边界；最新事实；汇总修正与结果版本 |
| 7 | [不停机数据库迁移、切换与回退](topics/online-database-migration.md) | 写入权威隔离；最终位点与对账；新库写入后的回退条件 |
| 8 | [分布式调度、补数与结果发布](topics/distributed-scheduling-backfill.md) | 运行与尝试身份；接管和取消；补数隔离与发布仲裁 |

## 算法穿插练习

从[数组与链表](LeetCode.md)开始，逐步学习树、图、动态规划和贪心。每道题写清输入约束、边界、时间空间复杂度以及是否修改输入；先做[区间合并 E05](practice.md#e05-合并有交集的闭区间)，体会“先排序，再维护不变量”。
