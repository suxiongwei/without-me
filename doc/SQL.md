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
[626. 换座位](https://leetcode.cn/problems/exchange-seats/description/)
```sql
SELECT 
  (
    CASE 
    WHEN MOD(id, 2) != 0 AND counts != id THEN id + 1 
    WHEN MOD(id, 2) != 0 AND counts = id THEN id 
    ELSE id - 1 
    END
  ) AS id, 
  student 
FROM 
  seat, 
  (
    SELECT 
      COUNT(*) AS counts 
    FROM 
      seat
  ) AS seat_counts 
ORDER BY 
  id ASC;
```

你的平均薪水是多少？
```sql
薪水表的字段分别为：
- 雇员编号
- 部门编号
- 薪水

问题：查询出每个部门除去最高、最低薪水后的平均薪水，并保留整数

select
    `部门编号`
    ,avg(`薪水`) as `平均薪水`
from (
    select
        *
        ,dense_rank() over (partition by `部门编号` order by `薪水` desc) as rank1 # rank1 = 1 是薪水最高的
        ,dense_rank() over (partition by `部门编号` order by `薪水` asc) as rank2 # rank2 = 1 是薪水最低的
    from
    `薪水表`
) as tmp_a
where 
rank1 > 1
and rank2 > 1
group by `部门编号`

```

如何查找第 N 高的数据？
```sql
【题目】
现在有 “课程表”，记录了学生选修课程的名称以及成绩。
现在需要找出语文课中成绩第二高的学生成绩。如果不存在第二高成绩的学生，那么查询应返回 null。

解法1:
select max(distinct 成绩) 
from 成绩表
where 课程='语文' and
      成绩 < (select max(distinct 成绩) 
              from 成绩表 
              where 课程='语文');
              
解法2:
select distinct 成绩  
from 成绩表
where 课程='语文'
order by 课程,成绩 desc
limit 1,1;

考虑特殊情况：
题目要求，如果没有第二高的成绩，返回空值，所以这里用判断空值的函数（ifnull）函数来处理特殊情况。
ifnull(a,b) 函数解释：
如果 value1 不是空，结果返回 a
如果 value1 是空，结果返回 b

因此：对于本题的 sql 就是：
select ifnull(第2步的sql,null) as '语文课第二名成绩';

```
如何交换数据？
```sql
【题目】
小明是一所学校的老师，她有一张 “学生表”，平时用来存放座位号和学生的信息。其中，座位号是连续递增的。总的座位数是偶数。
现在，小明想改变相邻俩学生的座位。你能不能帮她写一个 sql 查来输出想要的结果呢？

select
      (case
             when mod(座位号, 2) != 0  then 座位号 + 1
             when mod(座位号, 2)  = 0  then 座位号 - 1
      end)  as  '交换后座位号',
      姓名
from 学生表;
```
统计每个班同学各科成绩平均分大于 80 分的人数和人数占比?
```sql
“学生表” 里记录了学生的学号、入学时间等信息。“成绩表” 里是学生选课成绩的信息。两个表中的学号一一对应

学生表(姓名、学号、班级、入学时间、年龄、专业)
成绩表(学号、课程号、分数)

select 
    a.班级,
    sum(
        case when b.平均成绩>80 
        then 1
        else 0 
        end
    ) as 人数,
    sum(
        case when b.平均成绩>80 
        then 1
        else 0 
        end
    )/count(a.学号) as 人数占比
from 学生表 as a left join(
    select 
        学号
        ,avg(分数) as 平均成绩
    from 成绩表
    group by 学号
) as b
on a.学号=b.学号
group by 班级
```