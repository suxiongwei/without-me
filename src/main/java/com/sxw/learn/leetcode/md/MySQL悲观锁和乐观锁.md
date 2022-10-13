## 悲观锁
引言：之所以叫做悲观锁，是因为这是一种对数据的修改抱有悲观态度的并发控制方式。我们一般认为数据被并发修改的概率比较大，所以需要在修改之前先加锁。

_使用悲观锁，需要关闭mysql的自动提交功能，将 set autocommit = 0;_<br/>

【例子】
```roomsql
//0.开始事务
begin;
//1.查询出商品库存信息
select quantity from items where id=1 for update;
//2.修改商品库存为2
update items set quantity=2 where id = 1;
//3.提交事务,事务提交时会释放事务过程中的锁,所以可能会死锁
commit;
```
以上，在对id = 1的记录修改前，先通过for update的方式进行加锁，然后再进行修改。这就是比较典型的悲观锁策略。

如果以上修改库存的代码发生并发，同一时间只有一个线程可以开启事务并获得id=1的锁，其它的事务必须等本次事务提交之后才能执行。这样我们可以保证当前的数据不会被其它事务修改。

## 乐观锁
引言：相对于悲观锁，在对数据库进行处理的时候，乐观锁并不会使用数据库提供的锁机制。一般的实现乐观锁的方式就是记录数据版本。

乐观锁是基于程序实现的，所以不存在死锁的情况

【例子】
```roomsql
//查询出商品库存信息，quantity = 3
select quantity from items where id=1
//修改商品库存为2
update items set quantity=2 where id=1 and quantity = 3;
```

以上，我们在更新之前，先查询一下库存表中当前库存数（quantity），然后在做update的时候，以库存数作为一个修改条件。当我们提交更新的时候，判断数据库表对应记录的当前库存数与第一次取出来的库存数进行比对，如果数据库表当前库存数与第一次取出来的库存数相等，则予以更新，否则认为是过期数据。

但是以上更新语句存在一个比较重要的问题，即ABA问题。

有一个比较好的办法可以解决ABA问题，那就是通过一个单独的可以顺序递增的version字段。

【优化1】
```roomsql
//查询出商品信息，version = 1
select version from items where id=1
//修改商品库存为2
update items set quantity=2,version = 3 where id=1 and version = 2;
```

以上SQL其实还是有一定的问题的，就是一旦高并发的时候，就只有一个线程可以修改成功，那么就会存在大量的失败。

【优化2】
```roomsql
//修改商品库存
update item
set quantity=quantity - 1
where id = 1 and quantity - 1 > 0
```
以上SQL语句中，如果用户下单数为1，则通过quantity - 1 > 0的方式进行乐观锁控制。

以上update语句，在执行过程中，会在一次原子操作中自己查询一遍quantity的值，并将其扣减掉1。

