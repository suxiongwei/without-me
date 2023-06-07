### 是什么？
分布式的并行流处理系统

主要是来处理无界数据流

所有的 Flink 程序都可以归纳为由三部分构成：Source、Transformation 和 Sink。
- Source 表示“源算子”，负责读取数据源。
- Transformation 表示“转换算子”，利用各种算子进行处理加工。
- Sink 表示“下沉算子”，负责数据的输出。


### Spark 还是 Flink？
具体到项目应用中，不仅要看是流处理还是批处理，还需要在延迟、吞吐量、可靠性，以及开发容易度等多个方面进行权衡。

如果在工作中需要从 Spark 和 Flink 这两个主流框架中选择一个来进行实时流处理，我们更加推荐使用 Flink，主要的原因有：
- Flink 的延迟是毫秒级别，而 Spark Streaming 的延迟是秒级延迟。
- Flink 提供了严格的精确一次性语义保证。
- Flink 的窗口API 更加灵活、语义更丰富。
- Flink 提供事件时间语义，可以正确处理延迟数据。
- Flink 提供了更加灵活的对状态编程的 API。

### 系统架构
集群中资源的分配和管理、进程协调调度、持久化和高可用的数据存储，以及故障恢复。</br>
对于这些分布式系统的经典问题，业内已有比较成熟的解决方案和服务。</br>
所以 Flink 并不会自己去处理所有的问题，而是利用了现有的集群架构和服务，这样它就可以把精力集中在核心工作——分布式数据流处理上了。

Flink 的运行时架构中，最重要的就是两大组件：
#### 作业管理器（JobManger）
JobManager 是一个 Flink 集群中任务管理和调度的核心，是控制应用执行的主进程。

##### JobMaster
核心组件

在作业提交时：
- 把JobGraph转换成执行图
- 向ResourceManager发起请求，申请必须的资源

运行过程中：
- 负责需要中央协调的操作，比如checkpoints的协调

##### ResourceManager
负责资源的分配和管理

**Flink 内置的 ResourceManager 和其他资源管理平台（比如 YARN）的ResourceManager 区分开。**
Flink 的ResourceManager，针对不同的环境和资源管理平台（比如 Standalone 部署，或者YARN），有不同的具体实现。
- 在 Standalone 部署时，因为 TaskManager 是单独启动的（没有 Per-Job 模式），所以 ResourceManager 只能分发可用TaskManager 的任务槽，不能单独启动新 TaskManager。
- 而在有资源管理平台时，就不受此限制。当新的作业申请资源时，ResourceManager 会将有空闲槽位的 TaskManager 分配给 JobMaster。
如果 ResourceManager 没有足够的任务槽，它还可以向资源提供平台发起会话， 请求提供启动 TaskManager 进程的容器。
另外， ResourceManager 还负责停掉空闲的TaskManager，释放计算资源。

##### Dispatcher
启动并提交任务到JobMaster

#### 任务管理器（TaskManager）

Worker, 是一个 JVM 进程

每一个 TaskManager 都包含了一定数量的任务槽（task slots）。Slot是资源调度的最小单位，slot 的数量限制了TaskManager 能够并行处理的任务数量

### 作业提交到流程
- 一般情况下，由客户端（App）通过分发器提供的 REST 接口，将作业提交给 JobManager。
- 分发器启动 JobMaster，并将作业（包含 JobGraph）提交给 JobMaster。
- JobMaster 将 JobGraph 解析为可执行的ExecutionGraph，得到所需的资源数量，然后向资源管理器请求资源（slots）。
- 资源管理器判断当前是否由足够的可用资源；如果没有，启动新的 TaskManager。
- TaskManager 启动之后，向ResourceManager 注册自己的可用任务槽（slots）。
- 资源管理器通知 TaskManager 为新的作业提供 slots。
- TaskManager 连接到对应的 JobMaster，提供 slots。
- JobMaster 将需要执行的任务分发给TaskManager。
- TaskManager 执行任务，互相之间可以交换数据。

### Flink中的时间语义
- 事件时间：数据产生的时间
  数据一旦产生，这个时间自然就确定了，所以它可以作为一个属性嵌入到数据中。这其实就是这条数据记录的“时间戳”（Timestamp）。

- 处理时间：数据真正被处理的时刻

#### Watermark
在实际应用中，一般会采用事件时间语义。而水位线，就是基于事件时间提出的概念。

在事件时间语义下，我们不依赖系统时间，而是基于数据自带的时间戳去定义了一个时钟， 用来表示当前时间的进展。于是每个并行子任务都会有一个自己的逻辑时钟，它的前进是靠数据的时间戳来驱动的。

在 Flink 中，这种用来衡量事件时间（Event Time）进展的标记，就被称作“水位线”（Watermark）。

乱序流的处理：可以在数据的时间戳基础上加一些延迟来保证不丢数据

本质：当前时间之前的数据，都已经到齐了

水位线在上下游任务之间的传递：木桶原理

默认计算公式：
```水位线 = 观察到的最大事件时间 –  最大延迟时间 – 1 毫秒```

#### 窗口
窗口并不是静态准备好的，而是动态创建——当有落在这个窗口区间范围的数据达到时，才创建对应的窗口。

##### 窗口的分类
按照驱动类型分类

- 时间窗口（Time Window）
- 计数窗口（Count Window）

按照窗口分配数据的规则分类

- 滚动窗口（Tumbling  Window）
  首尾相接，滚动窗口也可以看作是一种特殊的滑动窗口
- 滑动窗口（Sliding Window）
  不是首尾相接
- 会话窗口（Session Window）
  数据来了之后就开启一个会话窗口，如果接下来还有数据陆续到来， 那么就一直保持会话；如果一段时间一直没收到数据，那就认为会话超时失效，窗口自动关闭。
- 全局窗口（Global Window）


### 一些核心概念
#### 并行度
一个特定算子的子任务（subtask）的个数被称之为其并行度（parallelism）。

#### 任务槽
slot 目前仅仅用来隔离内存，不会涉及 CPU 的隔离。

默认情况下，允许子任务共享 slot

当我们将资源密集型和非密集型的任务同时放到一个 slot 中，它们就可以自行分配对资源占用的比例，从而保证最重的活平均分配给所有的TaskManager。


并行度如果小于等于集群中可用 slot 的总数，程序是可以正常执行的，因为 slot 不一定要全部占用，有十分力气可以只用八分；
而如果并行度大于可用 slot 总数，导致超出了并行能力上限，那么心有余力不足，程序就只好等待资源管理器分配更多的资源了

