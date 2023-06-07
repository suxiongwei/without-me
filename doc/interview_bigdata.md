## 大数据

- [列式存储](https://github.com/suxiongwei/without-me/blob/main/doc/column-based.md)
- [窗口函数](https://github.com/suxiongwei/without-me/blob/main/doc/window-function.md)
- [CH上卷/下钻](https://github.com/suxiongwei/without-me/blob/main/doc/rollup-cube.md)
- [Flink](https://github.com/suxiongwei/without-me/blob/main/doc/Flink.md)

##### 谈谈你对hadoop框架的理解？
<details>
<summary>展开</summary>
Hadoop是一个开源的分布式计算框架，用于处理大规模数据集。它主要由以下两个核心组件组成：

- Hadoop分布式文件系统（HDFS）：一个高度容错性、可扩展的分布式文件系统，具有高吞吐量和文件存储能力。
- MapReduce：一种分布式编程模型，用于将大规模数据集映射到一系列的键值对，并将这些键值对整理成一组中间结果，最终将这些中间结果聚合成需要的输出结果。

除此之外，Hadoop还包含了许多其他组件，以便更好地支持不同的业务需求，例如：
- YARN（Yet Another Resource Negotiator）：一个资源管理器，用于为运行在Hadoop集群上的应用程序分配资源；
- Hive：一个基于Hadoop的数据仓库工具，用于SQL查询和数据分析；

总的来说，Hadoop框架提供了一种可靠、可扩展、高效的方式来处理大规模数据集。它可以通过并行计算和分布式存储来提高数据处理的速度，同时也具有很好的容错性和可靠性，因此被广泛用于大数据分析、机器学习等领域。
</details>

##### 为什么业界现在离线大多用Spark而不用MapReduce
<details>
<summary>展开</summary>
Spark和MapReduce都是大数据处理领域的分布式计算框架。虽然它们都可以用于离线批处理，但Spark在一些方面具有优势，因此在业界中被更广泛地使用。

以下是Spark相对于MapReduce的一些优势：

- 内存计算：Spark的核心是基于内存计算，而不是像MapReduce那样将所有数据写入磁盘。这使得Spark能够在内存中快速处理数据，并且可以避免频繁读写磁盘造成的性能瓶颈。
- DAG执行引擎：Spark使用DAG（有向无环图）执行引擎来管理任务之间的依赖关系，从而最小化任务之间的数据传输。这种方式可以使Spark更高效地执行复杂的数据处理操作。
- 更好的API支持：Spark提供了多种编程语言的API支持，如Scala、Java、Python和R等。这使得开发人员可以使用自己喜欢的语言来编写Spark应用程序，并且还提供了许多高级API，如Spark SQL、Spark Streaming和MLlib等，以支持更广泛的数据处理任务。
- 更丰富的生态系统：Spark拥有一个庞大的生态系统，包括各种适用于不同场景的组件，如GraphX、Spark Streaming、Structured Streaming等。这些组件可以方便地与Spark集成，并提供了更广泛的数据处理功能。

综上所述，Spark相对于MapReduce拥有更高效的内存计算能力、更好的API支持、更丰富的生态系统等优势，这使得它在大数据处理领域被广泛应用。
</details>

