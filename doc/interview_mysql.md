# MySQL 与数据库原理

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

先读执行计划与索引，再比较快照读、锁和约束；最后学习分页、数据修复与报表粒度。

**版本与前提：** 主要参考 MySQL 8.x / InnoDB，执行计划与锁机制参考 8.4 手册；Oracle 差异单列。

## 推荐阅读

- [Q13 一条慢 SQL 你会怎么优化](topics/database-sql.md#q13-一条慢-sql-你会怎么优化)
- [Q14 联合索引如何设计 为什么有索引也没用上](topics/database-sql.md#q14-联合索引如何设计-为什么有索引也没用上)
- [Q15 MVCC 隔离级别和锁是什么关系](topics/database-sql.md#q15-mvcc-隔离级别和锁是什么关系)
- [Q16 乐观锁 悲观锁与唯一约束分别解决什么](topics/database-sql.md#q16-乐观锁-悲观锁与唯一约束分别解决什么)
- [Q17 深分页和大批量导出怎么设计](topics/database-sql.md#q17-深分页和大批量导出怎么设计)
- [Q18 Oracle 和 MySQL 的关键行为差异是什么](topics/database-sql.md#q18-oracle-和-mysql-的关键行为差异是什么)
- [Q19 如何修复线上错误数据](topics/database-sql.md#q19-如何修复线上错误数据)
- [Q20 报表金额为什么可能被关联查询放大](topics/database-sql.md#q20-报表金额为什么可能被关联查询放大)

## 配套专题与练习

- [不停机数据库迁移、切换与回退](topics/online-database-migration.md)
- [稀疏索引](../src/main/java/com/sxw/learn/leetcode/md/稀疏索引.md)
- [SQL 与窗口函数](SQL.md)
- [锁与并发更新](mysql_lock.md)
- [行存与列存对比](column-based.md)

## 补充笔记与代码

- [ACID 基础](../src/main/java/com/sxw/learn/leetcode/md/数据库ACID四大特性.md)
- [树结构对比](../src/main/java/com/sxw/learn/leetcode/tree/二叉查找树&平衡二叉树&红黑树&B-树&B+树性能对比.md)
- [乐观锁与悲观锁](mysql_lock.md)
- [redo log 与 binlog 两阶段提交](../src/main/java/com/sxw/learn/leetcode/md/redolog与binlog为什么需要两阶段提交？.md)

### B 树与 B+ 树

B+ 树的内节点通常保存索引信息，叶节点保存记录或定位信息，并通过有序连接支持范围扫描。它和 B 树的查找通常都需要沿树高访问，不能概括为一个固定 O(1)、另一个固定 O(log n)。磁盘页大小、记录宽度和缓存命中共同影响实际访问成本。

### 意向锁

InnoDB 的 IS / IX 是表级意向锁，用于表达事务准备获取更细粒度的共享或排他锁。IS 与 IX 彼此通常兼容，但与表级 S / X 锁存在相应兼容规则，不能概括成“意向锁与所有表锁都冲突”。

### 锁范围与访问路径

```sql
select * from lock_example where id between 8 and 15 for update;
```

仅有这条 SQL 不能确定精确锁区间，还要看索引、已有键值、唯一性与隔离级别。RR 下范围搜索可能使用 next-key lock，包含记录与间隙；RC 下多数搜索间隙锁会减少，但外键和重复键检查等场景仍需区分。

未走合适索引可能扫描并锁住更多索引记录，不能直接推导为“InnoDB 自动改用表锁”。快照读与当前读详见 [Q15](topics/database-sql.md#q15-mvcc-隔离级别和锁是什么关系)。

参考：[MySQL 8.4 InnoDB Locking](https://dev.mysql.com/doc/refman/8.4/en/innodb-locking.html)。
