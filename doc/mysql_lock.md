# 乐观更新、悲观锁与库存约束

[数据库分类](interview_mysql.md) · [MVCC 与锁](topics/database-sql.md) · [版本与资料](references.md)

**适用版本与前提：** MySQL 8.x / InnoDB，`items.id` 是唯一键，`quantity` 和 `version` 非空。下面的 SQL 是独立示例，没有在数据库执行。

## 悲观锁：先锁定，再修改

```sql
START TRANSACTION;
SELECT quantity FROM items WHERE id = 1 FOR UPDATE;
-- 在同一事务连接中，确认数量和业务规则后执行修改。
UPDATE items SET quantity = 2 WHERE id = 1;
COMMIT;
```

显式事务让锁定与修改处于同一事务范围；也可以采用其他明确的事务管理方式，不必把全局关闭 autocommit 当成唯一前提。另一个事务通常仍能开始，但访问相同冲突记录时可能等待。多行锁顺序不一致仍可能导致死锁，失败后应回滚并按业务规则处理。

## 乐观更新：用版本条件检测覆盖

假设刚读取到 `version = 1`，尝试：

```sql
UPDATE items
SET quantity = 2, version = version + 1
WHERE id = 1 AND version = 1;
```

影响 1 行表示该条件下修改成功；影响 0 行要区分记录不存在、版本变化或额外条件不满足。版本字段必须由所有相关写入路径正确维护。仅比较数量可能遗漏数量改变后又改回的过程，即 ABA 问题。

乐观更新依然由数据库执行 UPDATE，仍涉及数据库锁和事务；不能概括为“不加锁、不会死锁”。

## 单条语句维护库存下限

```sql
UPDATE items
SET quantity = quantity - 1
WHERE id = 1 AND quantity >= 1;
```

这条语句允许从 1 扣到 0，前提是业务允许售罄；影响行数必须检查。它只能保护该行的相应约束，订单落库、金额和其他资源还需要放进合适的事务或一致性方案中。MySQL 没有一个能概括所有访问的“默认乐观锁”模式。

参考：[MySQL 8.4 InnoDB Locking](https://dev.mysql.com/doc/refman/8.4/en/innodb-locking.html)。
