## 窗口函数
mysql8.0内置函数支持各种排名问题：

> 以力扣177. 第N高的薪水为例子<br/>
> Create table If Not Exists Employee (Id int, Salary int) <br/>
> Truncate table Employee<br/>
> insert into Employee (id, salary) values ('1', '100')<br/>
> insert into Employee (id, salary) values ('2', '200')<br/>
> insert into Employee (id, salary) values ('3', '300')

计算排名的时候可以用以下函数：
- row_number(): 同薪不同名，相当于行号，例如300、200、200、100排名后为1、2、3、4
- rank(): 同薪同名，有跳级，例如300、200、200、100排名后为1、2、2、4
- dense_rank(): 同薪同名，无跳级，例如300、200、200、100排名后为1、2、2、3
- ntile(): 分桶排名，即首先按桶的个数分出第一二三桶，然后各桶内从1排名，实际不是很常用

显然，本题是要用第三个函数。 

另外这三个函数必须要要与其搭档over()配套使用，over()中的参数常见的有两个，分别是 partition by，按某字段切分
order by，与常规order by用法一致，也区分ASC(默认)和DESC，因为排名总得有个依据

```sql
mysql> select
    -> salary
    -> ,row_number() over(ORDER BY salary DESC) as rank1
    -> ,rank() over(ORDER BY salary DESC) as rank2
    -> ,dense_rank() over(ORDER BY salary DESC) as rank3
    -> from employee;
+--------+-------+-------+-------+
| salary | rank1 | rank2 | rank3 |
+--------+-------+-------+-------+
|    300 |     1 |     1 |     1 |
|    200 |     2 |     2 |     2 |
|    200 |     3 |     2 |     2 |
|    100 |     4 |     4 |     3 |
+--------+-------+-------+-------+
```