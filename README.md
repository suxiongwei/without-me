# Java 后端与数据平台学习笔记

围绕 Java、数据库、分布式系统与数据平台持续学习。这里包含技术原理、图解、边界分析、SQL 与算法练习，以及可定位到源码的示例。

[开始阅读](doc/LEARNING_PATHS.md) · [50 道技术问答](doc/技术学习笔记.md) · [6 道综合练习](doc/practice.md) · [技术边界速查](doc/quick-reference.md) · [版本与资料](doc/references.md)


箭头表示建议的学习衔接；算法、代码练习与运行诊断贯穿各阶段。

## 选择阅读路线

| 路线 | 推荐顺序 | 入口 |
| --- | --- | --- |
| 后端基础 | Java → 并发/JVM → Spring → MySQL → Redis/Kafka → 分布式设计 | [后端基础路线](doc/LEARNING_PATHS.md#后端基础路线) |
| 数据平台 | SQL → Kafka → Flink → ClickHouse → 数据质量与调度 | [数据平台路线](doc/LEARNING_PATHS.md#数据平台路线) |
| 问题排查 | CPU/内存 → 接口延迟 → 慢 SQL → 消息积压 → 反压与对账 | [问题排查路线](doc/LEARNING_PATHS.md#问题排查路线) |

## 分类导航

| 分类 | 主要内容 | 阅读入口 |
| --- | --- | --- |
| Java 与 JVM | 集合、并发、线程池、异步调用、内存与运行时 | [Java](doc/interview_java.md) |
| Spring 与数据访问 | 容器、代理、事务、MyBatis、Web 调用链 | [Spring](doc/interview_spring.md) |
| 数据库与 SQL | 索引、MVCC、锁、分页、窗口函数与对账 | [MySQL](doc/interview_mysql.md) · [SQL](doc/SQL.md) |
| 消息与数据平台 | Kafka、Flink、ClickHouse、采集、补数与质量 | [数据平台](doc/interview_bigdata.md) |
| 分布式设计 | 缓存、租约锁、幂等、最终一致、设计模式 | [分布式设计](doc/interview_design.md) |
| 计算机基础与网络 | TCP、操作系统、I/O、虚拟内存 | [基础与网络](doc/interview_jisuanjijichu.md) |
| 算法与数据结构 | 数组、链表、树、图、动态规划、贪心 | [算法目录](doc/LeetCode.md) |
| 工具与运行诊断 | JVM/接口排查、命令、容量与性能评估 | [工具与诊断](doc/linux.md) |

## 常用速查

- [Outbox + RocketMQ + Inbox：可靠消息、幂等与故障恢复](doc/topics/outbox-rocketmq-inbox.md)
- [全部文档索引](doc/INDEX.md)
- [技术边界：机制能保证什么、还缺少什么](doc/quick-reference.md)
- [图解目录：并发、事务、MVCC、消息与流式处理](doc/DIAGRAMS.md)
- [配套练习：窗口 SQL、对账、幂等与区间合并](doc/practice.md)
- [代码示例目录](src/main/java/com/sxw/learn) · [适用版本与官方资料](doc/references.md)

## 阅读与维护

每个知识点按问题、示例、原理、边界与练习理解。核心答案直接展示，较长的补充和练习答案可以折叠。新增内容遵循[文档约定](doc/WRITING.md)，图片与原图见[素材目录](doc/assets/README.md)。

## 个人资料与成长记录

- [成长记录](doc/interview_chengzhang.md)
- [个人资料](src/main/java/com/sxw/learn/leetcode/简历.md)
