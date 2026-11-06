# 图解目录

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [历史图片素材](assets/README.md)

图形采用 Mermaid，与对应正文共同维护。GitHub 可以直接展示；若本地阅读器不支持，可查看代码围栏和相邻的文字/时序表。

| 图解 | 阅读位置 | 理解重点 |
| --- | --- | --- |
| ConcurrentHashMap 竞争时序 | [Q02](topics/java-concurrency.md#q02-concurrenthashmap-线程安全-为什么先判断再写仍有问题) | 多次调用之间可交错 |
| 线程池任务流转 | [Q04](topics/java-concurrency.md#q04-线程池怎么执行任务-参数怎么确定) | 创建线程、入队和拒绝策略 |
| Spring 事务调用 | [Q07](topics/spring-data-access.md#q07-spring-事务为什么会看起来不生效) | 代理入口与事务边界 |
| Servlet Filter 与 MVC 调用链 | [Web 调用链](FILTERANDINTERCEPTOR.md#请求经过哪些层) | 外层过滤与 Handler 拦截 |
| MVCC 读取时间线 | [Q15](topics/database-sql.md#q15-mvcc-隔离级别和锁是什么关系) | 快照读与锁定读 |
| Kafka 分区与消费组 | [Q25](topics/kafka.md#q25-kafka-顺序性怎么理解) | 组内分配、组间独立和 offset |
| Watermark 与迟到数据 | [Q31](topics/flink.md#q31-event-time-watermark-与迟到数据如何解释) | 时间进度和迟到策略 |
| Checkpoint 与恢复 | [Q32](topics/flink.md#q32-flink-state-与-checkpoint-分别是什么) | 状态、输入进度和重放 |
| Flink 运行组件 | [架构与作业提交](Flink.md#从程序到运行组件) | Dispatcher、JobMaster、资源与执行 |
| Outbox 与未知结果 | [Q48](topics/distributed-systems.md#q48-本地事务与远程调用-如何保证最终一致) | 本地原子提交与远程幂等 |
| Outbox、MQ 与 Inbox 全链路 | [两个本地事务](topics/outbox-rocketmq-inbox.md#整体链路与两个本地事务) | 生产事务、投递和消费事务的边界 |
| Relay 投递状态机 | [领取与恢复](topics/outbox-rocketmq-inbox.md#relay-如何领取投递与恢复) | 租约、领取身份、重复发送和挂起恢复 |
| 提交成功但 ACK 丢失 | [Inbox 去重时序](topics/outbox-rocketmq-inbox.md#唯一约束如何处理两个消费者并发) | 重投核对已提交结果，不重复产生效果 |
| 履约业务状态机 | [合法迁移与乱序](topics/outbox-rocketmq-inbox.md#状态机如何处理重复与乱序) | 期待序号、取消与发货的业务约束 |
| 区间合并 | [E05](practice.md#e05-合并有交集的闭区间) | 排序与扫描不变量 |
| 支付尝试状态机 | [状态机与成功协议](topics/payment-idempotency.md#状态机与成功协议) | 超时进入未知状态，确认结果后再推进 |
| 支付成功但响应丢失 | [超时不能直接判为支付失败](topics/payment-idempotency.md#超时不能直接判为支付失败) | 稳定请求身份、查询与回调收敛 |
| 跨服务 Saga 编排 | [编排式与协同式](topics/saga-tcc-workflow.md#编排式与协同式) | 本地提交与持久命令、结果 |
| TCC 分支状态机 | [库存预留的 TCC 语义](topics/saga-tcc-workflow.md#库存预留的-tcc-语义) | 预留、确认、取消与空回滚 |
| 租约过期与旧执行者 | [完整题目与不变量](topics/lease-fencing.md#完整题目与不变量) | 过期不会终止旧进程 |
| 同库 Epoch 仲裁 | [同库领取与写入协议](topics/lease-fencing.md#同库领取与写入协议) | 接管与业务写入竞争同一保护记录 |
| 导出任务状态机 | [数据模型与任务状态](topics/resumable-export.md#数据模型与任务状态) | 快照、分片与发布的阶段 |
| 导出取消与发布竞争 | [上传、发布与取消的竞争](topics/resumable-export.md#上传发布与取消的竞争) | 版本条件仲裁，文件上传不等于发布 |
| 一致快照与 CDC 边界 | [快照与日志位点必须成对建立](topics/snapshot-cdc.md#快照与日志位点必须成对建立) | 快照点与日志起点需要协议配对 |
| 目标应用与确认 | [目标应用与连续完成前沿](topics/snapshot-cdc.md#目标应用与连续完成前沿) | 应用、持久进度与消息确认顺序 |
| 实时计算与外部可见性 | [检查点覆盖哪些资源](topics/flink-clickhouse-consistency.md#检查点覆盖哪些资源) | 检查点不自动覆盖外部写入 |
| 写入后检查点失败重放 | [检查点覆盖哪些资源](topics/flink-clickhouse-consistency.md#检查点覆盖哪些资源) | 相同事实重放不能再次累计 |
| 数据库迁移阶段 | [权威源与控制模型](topics/online-database-migration.md#权威源与控制模型) | 从源库权威到目标库权威 |
| 写切换与最终位点 | [读切换与写切换](topics/online-database-migration.md#读切换与写切换) | 关写、排空、追平与开放新写入 |
| 调度实例与执行尝试 | [调度、领取和执行状态](topics/distributed-scheduling-backfill.md#调度领取和执行状态) | 可恢复运行状态与尝试隔离 |
| 旧 Worker 发布被拒绝 | [旧 Worker 恢复后为什么不能发布](topics/distributed-scheduling-backfill.md#旧-worker-恢复后为什么不能发布) | 产物生成与发布权限分离 |

## 历史配图复用

- [设计模式结构图与使用场景](design-patterns.md)
- [TCP、操作系统与 TLS 示意](interview_jisuanjijichu.md#配套图示)
- [SQL JOIN 示意与多重集边界](SQL.md#join-的集合示意与边界)
- [全部 51 张历史素材](assets/README.md)
