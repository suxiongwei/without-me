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

### 一些题目
[180. 连续出现的数字](https://leetcode.cn/problems/consecutive-numbers/)
```sql
表：Logs

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id 是这个表的主键。

编写一个 SQL 查询，查找所有至少连续出现三次的数字。
返回的结果表中的数据可以按 任意顺序 排列。

SQL:
select 
distinct log1.num as ConsecutiveNums
from 
logs as log1
inner join logs log2 on log1.id = (log2.id - 1) and log1.num = log2.num
inner join logs log3 on log2.id = (log3.id - 1) and log2.num = log3.num
```

[185. 部门工资前三高的所有员工](https://leetcode.cn/problems/department-top-three-salaries/description/)

```sql
# Write your MySQL query statement below
-- 解法1：使用子查询
# SELECT 
# d1.name as Department
# ,e1.name as Employee
# ,e1.salary as Salary
# FROM 
# Employee e1 
# INNER JOIN Department d1 on e1.departmentId = d1.id
# -- 代表超过当前员工工资的人数少于3个
# WHERE 3 > (
#     SELECT count(distinct salary) 
#     FROM Employee e2
#     WHERE e2.salary > e1.salary AND e1.departmentId = e2.departmentId
# )
-- 解法2：使用窗口函数
SELECT
d.name as Department
,e.name as Employee
,e.salary as Salary
FROM(
    SELECT 
    *
    ,dense_rank() over(PARTITION BY departmentId ORDER BY salary DESC) as rnk
    FROM 
    Employee
) e
INNER JOIN Department d on e.departmentId = d.id
WHERE rnk <= 3

涉及到“既要分组，又要排序”的情况，要能想到用窗口函数来实现。
# topN问题 sql模板
select *
from (
   select *, 
          row_number() over (partition by 要分组的列名
                       order by 要排序的列名 desc) as 排名
   from 表名) as a
where 排名 <= N;

```