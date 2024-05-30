### kafka维护消费状态跟踪的方法
大部分消息系统在broker端的维护消息被消费的记录：

一个消息被分发到consumer后broker就马上进行标记或者等待customer的通知后进行标记。这样也可以在消息在消费后立马就删除以减少空间占用。

但是这样会不会有什么问题呢？如果一条消息发送出去之后就立即被标记为消费过的，一旦consumer处理消息时失败了（比如程序崩溃）消息就丢失了。

为了解决这个问题，很多消息系统提供了另外一个个功能：当消息被发送出去之后仅仅被标记为已发送状态，当接到consumer已经消费成功的通知后才标记为已被消费的状态。

这虽然解决了消息丢失的问题，但产生了新问题，首先如果consumer处理消息成功了但是向broker发送响应时失败了，这条消息将被消费两次。
第二个问题时，broker必须维护每条消息的状态，并且每次都要先锁住消息然后更改状态然后释放锁。
这样麻烦又来了，且不说要维护大量的状态数据，比如如果消息发送出去但没有收到消费成功的通知，这条消息将一直处于被锁定的状态。

**Kafka采用了不同的策略。Topic被分成了若干分区，每个分区在同一时间只被一个consumer消费。

这意味着每个分区被消费的消息在日志中的位置仅仅是一个简单的整数：offset**。

这样就很容易标记每个分区消费状态就很容易了，仅仅需要一个整数而已。这样消费状态的跟踪就很简单了。

这带来了另外一个好处：consumer可以把offset调成一个较老的值，去重新消费老的消息。
这对传统的消息系统来说看起来有些不可思议，但确实是非常有用的，谁规定了一条消息只能被消费一次呢？

### kafka分布式（不是单机）的情况下，如何保证消息的顺序消费？
- 所有消息都发送到同一个partition
- 利用key分流到不同的partition

Kafka分布式的单位是partition，同一个partition用一个write ahead log组织，所以可以保证FIFO的顺序。
不同partition之间不能保证顺序。但是绝大多数用户都可以通过message key来定义，因为同一个key的Message可以保证只发送到同一个partition。

Kafka中发送1条消息的时候，可以指定(topic, partition, key) 3个参数。partition和key是可选的。如果你指定了partition，那就是所有消息发往同1个partition，就是有序的。

并且在消费端，Kafka保证，1个partition只能被1个consumer消费。

或者你指定key（比如order id），具有同1个key的所有消息，会发往同1个partition。

### 一些实践经验
- 不同Consumer Group的消费者的offset不同，有可能直接从最初位置开始消费了
- consumer 扩容：新起一个进程，同一个group，partition的数量大于等于consumer的数量
- 同一Consumer Group中的多个Consumer实例，不同时消费同一个partition，等效于队列模式。

### 一些命令
```shell
--  查看所有的topic
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

-- 查看单个Topic信息
bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic mrp-web-analyze

-- 查看消费组的消费情况
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group mrp-web-analyze-consumer-group

-- 修改partition数量
bin/kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic mrp-web-analyze --partitions 2



➜ kafka_2.13-3.5.0 bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
__consumer_offsets
mrp-web-analyze
mrp-web-etl
➜ kafka_2.13-3.5.0 bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic mrp-web-analyze
Topic: mrp-web-analyze	TopicId: eBNxLPR1TPOJA2mAHNVMZQ	PartitionCount: 3	ReplicationFactor: 1	Configs: segment.bytes=1073741824
	Topic: mrp-web-analyze	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
	Topic: mrp-web-analyze	Partition: 1	Leader: 1	Replicas: 1	Isr: 1
	Topic: mrp-web-analyze	Partition: 2	Leader: 1	Replicas: 1	Isr: 1
➜ kafka_2.13-3.5.0 bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group mrp-web-analyze-consumer-group

GROUP                          TOPIC           PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID                                                                    HOST            CLIENT-ID
mrp-web-analyze-consumer-group mrp-web-etl     0          5               5               0               consumer-mrp-web-analyze-consumer-group-2-a3eb62ad-3061-4e1d-b062-af0901538e6f /127.0.0.1      consumer-mrp-web-analyze-consumer-group-2
mrp-web-analyze-consumer-group mrp-web-analyze 0          5               5               0               consumer-mrp-web-analyze-consumer-group-1-3d7465b1-f600-4be6-8df5-8d8c7ef2cb48 /127.0.0.1      consumer-mrp-web-analyze-consumer-group-1
```
