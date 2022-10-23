> MySQL事务提交的时候，需要同时完成redo log和binlog的提交，为了保证两个日志的一致性，
> 需要用到两阶段提交（与分布式的两阶段提交不同，这里的两阶段提交是发生在数据库内部）

## 两阶段流程
在最后提交事务的时候，需要有3个步骤：

1. 写入redo log，处于prepare状态
2. 写binlog
3. 修改redo log状态为commit

_ps: redo log的提交分为prepare和commit两个阶段，所以称之为两阶段提交_ 

## 为什么需要两阶段提交？
在MySQL进程异常重启后需要用到redo log **或** binlog来完成数据的恢复，
如果不使用“两阶段提交”，那么数据库的状态就有可能和用它的日志恢复出来的库的状态不一致（一种情况是主从不一致）。


https://cloud.tencent.com/developer/article/1790507