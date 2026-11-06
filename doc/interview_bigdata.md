# 数据平台与流式计算

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

前置知识：SQL 与数据库事务。按采集 → Kafka → Flink → ClickHouse → 数据质量的路径学习。

**版本与前提：** Flink 图解参考 1.20，旧 Kafka 命令含 3.5.0 示例；各组件的连接器和部署版本单独确认。

## 推荐阅读

- [Q24 Kafka 为什么会重复消费 怎么避免业务重复](topics/kafka.md#q24-kafka-为什么会重复消费-怎么避免业务重复)
- [Q25 Kafka 顺序性怎么理解](topics/kafka.md#q25-kafka-顺序性怎么理解)
- [Q26 Kafka 积压怎么定位和处理](topics/kafka.md#q26-kafka-积压怎么定位和处理)
- [Q27 如何设计失败重试和死信处理](topics/kafka.md#q27-如何设计失败重试和死信处理)
- [Q28 如何理解 Kafka 的可靠性与恰好一次](topics/kafka.md#q28-如何理解-kafka-的可靠性与恰好一次)
- [Q29 离线与实时数仓有什么区别 如何选择](topics/flink.md#q29-离线与实时数仓有什么区别-如何选择)
- [Q30 全量与增量采集如何衔接](topics/flink.md#q30-全量与增量采集如何衔接)
- [Q31 Event Time Watermark 与迟到数据如何解释](topics/flink.md#q31-event-time-watermark-与迟到数据如何解释)
- [Q32 Flink State 与 Checkpoint 分别是什么](topics/flink.md#q32-flink-state-与-checkpoint-分别是什么)
- [Q33 Checkpoint 与 Savepoint 有什么区别](topics/flink.md#q33-checkpoint-与-savepoint-有什么区别)
- [Q34 开启 Checkpoint 就能保证写入 ClickHouse 不重不丢吗](topics/flink.md#q34-开启-checkpoint-就能保证写入-clickhouse-不重不丢吗)
- [Q35 反压和数据倾斜怎么区分](topics/flink.md#q35-反压和数据倾斜怎么区分)
- [Q36 Flink 关联和状态膨胀如何处理](topics/flink.md#q36-flink-关联和状态膨胀如何处理)
- [Q37 实时任务失败或 Checkpoint 超时怎么排查](topics/flink.md#q37-实时任务失败或-checkpoint-超时怎么排查)
- [Q38 数据质量 对账和补数怎么设计](topics/flink.md#q38-数据质量-对账和补数怎么设计)
- [Q39 为什么 ClickHouse 适合分析查询](topics/clickhouse.md#q39-为什么-clickhouse-适合分析查询)
- [Q40 MergeTree 排序键 分区与主键如何理解](topics/clickhouse.md#q40-mergetree-排序键-分区与主键如何理解)
- [Q41 ReplacingMergeTree 会立即去重吗](topics/clickhouse.md#q41-replacingmergetree-会立即去重吗)
- [Q42 ClickHouse 写入慢或小 part 太多 怎么处理](topics/clickhouse.md#q42-clickhouse-写入慢或小-part-太多-怎么处理)
- [Q43 ClickHouse 查询慢 怎么分析](topics/clickhouse.md#q43-clickhouse-查询慢-怎么分析)
- [Q44 物化视图与聚合表有什么容易踩的坑](topics/clickhouse.md#q44-物化视图与聚合表有什么容易踩的坑)
- [Q45 副本与分片分别解决什么问题](topics/clickhouse.md#q45-副本与分片分别解决什么问题)

## 配套专题与练习

- [全量快照、CDC 衔接与可恢复数据同步](topics/snapshot-cdc.md)
- [Flink 与 ClickHouse 的重放、去重和汇总一致性](topics/flink-clickhouse-consistency.md)
- [分布式调度、补数与结果发布](topics/distributed-scheduling-backfill.md)
- [Kafka 运维命令](kafka.md)
- [Flink 运行架构](Flink.md)
- [列式存储](column-based.md)
- [聚合维度与上卷](rollup-cube.md)

## 补充笔记与代码

- [窗口函数](window-function.md)

### 谈谈你对hadoop框架的理解？

Hadoop是一个开源的分布式计算框架，用于处理大规模数据集。它主要由以下两个核心组件组成：

- Hadoop分布式文件系统（HDFS）：一个高度容错性、可扩展的分布式文件系统，具有高吞吐量和文件存储能力。
- MapReduce：一种分布式编程模型，用于将大规模数据集映射到一系列的键值对，并将这些键值对整理成一组中间结果，最终将这些中间结果聚合成需要的输出结果。

除此之外，Hadoop还包含了许多其他组件，以便更好地支持不同的业务需求，例如：
- YARN（Yet Another Resource Negotiator）：一个资源管理器，用于为运行在Hadoop集群上的应用程序分配资源；
- Hive：一个基于Hadoop的数据仓库工具，用于SQL查询和数据分析；

总的来说，Hadoop框架提供了一种可靠、可扩展、高效的方式来处理大规模数据集。它可以通过并行计算和分布式存储来提高数据处理的速度，同时也具有很好的容错性和可靠性，因此被广泛用于大数据分析、机器学习等领域。

### 为什么业界现在离线大多用Spark而不用MapReduce

Spark和MapReduce都是大数据处理领域的分布式计算框架。虽然它们都可以用于离线批处理，但Spark在一些方面具有优势，因此在业界中被更广泛地使用。

以下是Spark相对于MapReduce的一些优势：

- 内存计算：Spark的核心是基于内存计算，而不是像MapReduce那样将所有数据写入磁盘。这使得Spark能够在内存中快速处理数据，并且可以避免频繁读写磁盘造成的性能瓶颈。
- DAG执行引擎：Spark使用DAG（有向无环图）执行引擎来管理任务之间的依赖关系，从而最小化任务之间的数据传输。这种方式可以使Spark更高效地执行复杂的数据处理操作。
- 更好的API支持：Spark提供了多种编程语言的API支持，如Scala、Java、Python和R等。这使得开发人员可以使用自己喜欢的语言来编写Spark应用程序，并且还提供了许多高级API，如Spark SQL、Spark Streaming和MLlib等，以支持更广泛的数据处理任务。
- 更丰富的生态系统：Spark拥有一个庞大的生态系统，包括各种适用于不同场景的组件，如GraphX、Spark Streaming、Structured Streaming等。这些组件可以方便地与Spark集成，并提供了更广泛的数据处理功能。

综上所述，Spark相对于MapReduce拥有更高效的内存计算能力、更好的API支持、更丰富的生态系统等优势，这使得它在大数据处理领域被广泛应用。
