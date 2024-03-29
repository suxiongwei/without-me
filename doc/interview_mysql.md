## MySQL

- [事务的特性(ACID)](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/%E6%95%B0%E6%8D%AE%E5%BA%93ACID%E5%9B%9B%E5%A4%A7%E7%89%B9%E6%80%A7.md)
- [红黑树和二叉平衡树的特点和区别](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/tree/%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91%26%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91%26%E7%BA%A2%E9%BB%91%E6%A0%91%26B-%E6%A0%91%26B%2B%E6%A0%91%E6%80%A7%E8%83%BD%E5%AF%B9%E6%AF%94.md)
- [MySQL悲观锁和乐观锁](https://github.com/suxiongwei/without-me/blob/main/doc/mysql_lock.md)
- [redolog与binlog为什么需要两阶段提交？](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/leetcode/md/redolog%E4%B8%8Ebinlog%E4%B8%BA%E4%BB%80%E4%B9%88%E9%9C%80%E8%A6%81%E4%B8%A4%E9%98%B6%E6%AE%B5%E6%8F%90%E4%BA%A4%EF%BC%9F.md)

##### B-树和B+树的区别
<details>
<summary>展开</summary>
https://www.jianshu.com/p/ace3cd6526c4<br/>
1. B+树内节点不存储数据，所有 data 存储在叶节点导致查询时间复杂度固定为 log n。而B-树查询时间复杂度不固定，与 key 在树中的位置有关，最好为O(1)。
2. B+树叶节点两两相连可大大增加区间访问性，可使用在范围查询等，而B-树每个节点 key 和 data 在一起，则无法区间查找。
3. B+树更适合外部存储。由于内节点无 data 域，每个节点能索引的范围更大更精确
</details>

##### MySQL意向锁的作用是什么？
<details>
<summary>展开</summary>
因为 mysql 存在行锁，而行锁与表锁存在互斥的关系，当执行一条 sql 语句出现行锁时，会修改表头的一个标志位，也就是所谓的意向锁。
此时，如果需要锁表时，会去判断标志位，从而迅速知道能否锁表。

##### 意向锁和哪些锁有互斥关系？

https://juejin.cn/post/6844903666332368909 <br/>
意向锁和自家兄弟互相兼容，但是它会与普通的排他/共享锁互斥(表锁)<br/>
*意向锁不会与行级的共享 / 排他锁互斥！！！*
</details>

##### 什么是间隙锁(Gap Locks)？
<details>
<summary>展开</summary>
间隙锁，它封锁索引记录中的间隔，或者第一条索引记录之前的范围，又或者最后一条索引记录之后的范围。<br/>
在 InnoDB，RR 条件下：<br/>
```sql
select * from lock_example where id between 8 and 15 for update;
```
这个SQL语句会封锁区间(8，15)，以阻止其他事务插入id位于该区间的记录。<br/>
间隙锁的主要目的，就是为了防止其他事务在间隔中插入数据，以导致“不可重复读”。<br/>
如果把事务的隔离级别降级为读提交(Read Committed， RC)，间隙锁则会自动失效。
</details>

##### 什么是MVCC？
<details>
<summary>展开</summary>
https://zhuanlan.zhihu.com/p/52977862<br/>
核心：
- 事务版本号
- 表的隐藏列
- undo log
- read view

MVCC是在并发访问数据库时，通过对数据做多版本管理，避免因为写数据时要加写锁而阻塞读取数据的请求，造成写数据时无法读取数据的问题。<br/>
通俗的讲就是MVCC通过保存数据的历史版本(undo log)，根据比较**数据的版本号**来决定数据的是否显示(MVCC快照读：根据版本号获取快照数据版本)，
在不需要加读锁的情况就能达到事务的隔离效果，最终可以在读取数据的时候可以同时进行修改，修改数据时候可以同时读取，极大的提升了事务的并发性能。
</details>

##### MVCC是否有解决幻读问题？
<details>
<summary>展开</summary>
快照读的情况下可以避免幻读问题，在当前读的情况下则需要使用间隙锁来解决幻读问题的
</details>

##### MySQL 行锁和表锁的含义及区别
<details>
<summary>展开</summary>

**MyISAM只支持表锁**，MyISAM在执行查询语句（select）前，会自动给涉及的所有表加读锁，在执行增删改操作前，会自动给涉及的表加写锁。

**InnoDB引擎支持行锁**

行锁是通过索引加载的，也就是说，行锁是加在索引响应的行上的，要是对应的SQL语句没有走索引，则会全表扫描，行锁则无法实现，取而代之的是表锁，此时其它事务无法对当前表进行更新或插入操作。

insert，delete，update在事务中都会自动默认加上排它锁。

https://segmentfault.com/a/1190000023662810
</details>