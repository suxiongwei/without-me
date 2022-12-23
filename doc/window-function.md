## 什么叫窗口函数
窗口函数也就是在满足某种条件的记录集合上执行的特殊函数。
- **静态窗口**：对于每条记录都要在此窗口内执行函数，窗口大小都是固定的
- **滑动窗口**：不同的记录对应着不同的窗口

基本语法：
```sql
函数名() over(partition by <要分列的组>
                order by <要排序的列> 
                rows between <数据范围>)     
```
其中 over是关键字，用来指定函数执行的窗口范围，包含三个分析子句：
- 分组(partition by)子句
- 排序(order by)子句
- 窗口(rows)子句，如果后面括号中什么都不写，则表示窗口包含满足where条件的所有行，窗口函数基于所有行计算。

## 窗口函数有哪几类?
主要包含三类：
- 排序函数
- 累计计算函数
- 偏移分析函数
- 滑动窗口函数

### 排序函数
- row_number()：赋予唯一的连续位次，有2条记录排在第1位时：1, 2, 3, 4, 5
```roomsql
SELECT
    name,
    department,
    month,
    salary,
    row_number() OVER w AS row_number
FROM employee_salary_1
WINDOW w AS (PARTITION BY department ORDER BY salary DESC)
SETTINGS allow_experimental_window_functions = 1

Query id: 0db67c51-f2fd-4ee4-80bb-e4d29b7db4e8

┌─name────┬─department─┬──────month─┬─salary─┬─row_number─┐
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │          1 │
│ George  │ Finance    │ 2020-01-01 │  10000 │          2 │
│ Davd    │ Finance    │ 2020-01-01 │   8000 │          3 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │          1 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │          2 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │          1 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │          2 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │          3 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │          4 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │          5 │
└─────────┴────────────┴────────────┴────────┴────────────┘
```
- rank()：计算排序时，如果存在相同位次的记录，则会跳过之后的位次，有2条记录排在第1位时：1, 1, 3, 4, 4, 6
```roomsql
SELECT
    name,
    department,
    month,
    salary,
    rank() OVER w AS rank
FROM employee_salary_1
WINDOW w AS (PARTITION BY department ORDER BY salary DESC)
SETTINGS allow_experimental_window_functions = 1

Query id: e69958d2-cd2b-47ca-b3b1-2bcf248bf057

┌─name────┬─department─┬──────month─┬─salary─┬─rank─┐
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │    1 │
│ George  │ Finance    │ 2020-01-01 │  10000 │    1 │
│ Davd    │ Finance    │ 2020-01-01 │   8000 │    3 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │    1 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │    2 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │    1 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │    2 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │    3 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │    3 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │    5 │
└─────────┴────────────┴────────────┴────────┴──────┘
```
- dense_rank()：同样是计算排序，即使存在相同位次的记录，也不会跳过之后的位次，有2条记录排在第1位时：1, 1, 2, 3, 3, 4
```roomsql
SELECT
    name,
    department,
    month,
    salary,
    dense_rank() OVER w AS dense_rank
FROM employee_salary_1
WINDOW w AS (PARTITION BY department ORDER BY salary DESC)
SETTINGS allow_experimental_window_functions = 1

Query id: 9a7aa206-2f38-4d77-8c56-1f8b46362fb3

┌─name────┬─department─┬──────month─┬─salary─┬─dense_rank─┐
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │          1 │
│ George  │ Finance    │ 2020-01-01 │  10000 │          1 │
│ Davd    │ Finance    │ 2020-01-01 │   8000 │          2 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │          1 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │          2 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │          1 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │          2 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │          3 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │          3 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │          4 │
└─────────┴────────────┴────────────┴────────┴────────────┘
```
### 累计计算函数
累计计算函数，也叫窗口聚合函数，常见的聚合函数有sum、avg、count、max、min。

他们跟窗口函数组合到一起，就会把聚合函数的功能和窗口函数组合在一起，只需要把聚合函数写在窗口函数的位置即可，
但是函数后面括号里面不能为空，需要指定聚合的列名。

```roomsql
SELECT
    name,
    department,
    month,
    salary,
    count(*) OVER w AS count,
    sum(salary) OVER w AS sum_wage,
    avg(salary) OVER w AS avg_wage,
    max(salary) OVER w AS max_wage,
    min(salary) OVER w AS min_wage
FROM employee_salary_1
WINDOW w AS (PARTITION BY department)
SETTINGS allow_experimental_window_functions = 1

Query id: 0d46dd1c-a4d9-4b65-a682-975cf0abb2d7

┌─name────┬─department─┬──────month─┬─salary─┬─count─┬─sum_wage─┬──────────avg_wage─┬─max_wage─┬─min_wage─┐
│ Davd    │ Finance    │ 2020-01-01 │   8000 │     3 │    28000 │ 9333.333333333334 │    10000 │     8000 │
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │     3 │    28000 │ 9333.333333333334 │    10000 │     8000 │
│ George  │ Finance    │ 2020-01-01 │  10000 │     3 │    28000 │ 9333.333333333334 │    10000 │     8000 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │     2 │    13000 │              6500 │     7000 │     6000 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │     2 │    13000 │              6500 │     7000 │     6000 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │     5 │    34000 │              6800 │     9000 │     5000 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │     5 │    34000 │              6800 │     9000 │     5000 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │     5 │    34000 │              6800 │     9000 │     5000 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │     5 │    34000 │              6800 │     9000 │     5000 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │     5 │    34000 │              6800 │     9000 │     5000 │
└─────────┴────────────┴────────────┴────────┴───────┴──────────┴───────────────────┴──────────┴──────────┘

注意：上面的PARTITION BY 后没有加ORDER BY，加上之后是这个结果：
┌─name────┬─department─┬──────month─┬─salary─┬─count─┬─sum_wage─┬──────────avg_wage─┬─max_wage─┬─min_wage─┐
│ Davd    │ Finance    │ 2020-01-01 │   8000 │     1 │     8000 │              8000 │     8000 │     8000 │
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │     3 │    28000 │ 9333.333333333334 │    10000 │     8000 │
│ George  │ Finance    │ 2020-01-01 │  10000 │     3 │    28000 │ 9333.333333333334 │    10000 │     8000 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │     1 │     6000 │              6000 │     6000 │     6000 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │     2 │    13000 │              6500 │     7000 │     6000 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │     1 │     5000 │              5000 │     5000 │     5000 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │     3 │    17000 │ 5666.666666666667 │     6000 │     5000 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │     3 │    17000 │ 5666.666666666667 │     6000 │     5000 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │     4 │    25000 │              6250 │     8000 │     5000 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │     5 │    34000 │              6800 │     9000 │     5000 │
└─────────┴────────────┴────────────┴────────┴───────┴──────────┴───────────────────┴──────────┴──────────┘
```

### 偏移分析函数
偏移分析函数中，用得较多的是lag和lead函数，这两个函数一般用于计算差值，最适用的场景是计算花费时间。

举个例子，有数据是每个用户浏览网页的时间记录，将记录的时间错位之后，进行两列相减就可以得到每个用户浏览每个网页实际花费的时间。

lag是用于统计窗口内往上第n行值，lead是用于统计窗口内往下第n行值。

_lag(上一个), lead(下一个)在clickhouse开窗中尚未支持，可通过间接方式实现，通过指定计算的行范围来实现，如下所示：_
```roomsql
SELECT
    department,
    month,
    name,
    salary,
    any(salary) OVER (PARTITION BY department ORDER BY salary DESC ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) AS lag,
    any(salary) OVER (PARTITION BY department ORDER BY salary DESC ROWS BETWEEN 1 FOLLOWING AND 1 FOLLOWING) AS lead
FROM employee_salary_1
SETTINGS allow_experimental_window_functions = 1

Query id: 50732fad-227d-4294-a0cb-05a2258c54ac

┌─department─┬──────month─┬─name────┬─salary─┬───lag─┬──lead─┐
│ Finance    │ 2020-01-01 │ Fancy   │  10000 │     0 │ 10000 │
│ Finance    │ 2020-01-01 │ George  │  10000 │ 10000 │  8000 │
│ Finance    │ 2020-01-01 │ Davd    │   8000 │ 10000 │     0 │
│ Marketing  │ 2020-01-01 │ Ilaja   │   7000 │     0 │  6000 │
│ Marketing  │ 2020-01-01 │ Haffman │   6000 │  7000 │     0 │
│ Sales      │ 2020-01-01 │ Elena   │   9000 │     0 │  8000 │
│ Sales      │ 2020-01-01 │ Joey    │   8000 │  9000 │  6000 │
│ Sales      │ 2020-01-01 │ Ali     │   6000 │  8000 │  6000 │
│ Sales      │ 2020-01-01 │ Bob     │   6000 │  6000 │  5000 │
│ Sales      │ 2020-01-01 │ Cindy   │   5000 │  6000 │     0 │
└────────────┴────────────┴─────────┴────────┴───────┴───────┘
```

### 滑动窗口函数
在写窗口函数时，order by后面可以有参数：rows/range，preceding，following，在组合使用这些参数后，窗口就会变成动态的滑动窗口

各种窗口参数含义：
- UNBOUNDED ：不受控的，无限的；
- PRECEDING ： 在…之前；
- FOLLOWING： 在…之后；

#### rows between的方式

使用格式：```rows between …… and ……```
- unbounded preceding 前面所有行
- unbounded following 后面所有行
- current row 当前行
- n following 后面n行
- n preceding 前面n行

```roomsql
SELECT
    name,
    department,
    month,
    salary,
    row_number() OVER w AS row,
    sum(salary) OVER w AS sum_wage,
    sum(salary) OVER (PARTITION BY department ORDER BY salary DESC ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS sum_wage_2
FROM employee_salary_1
WINDOW w AS (PARTITION BY department ORDER BY salary DESC)
SETTINGS allow_experimental_window_functions = 1

Query id: af06eb11-69ca-44b5-a16f-a1f13f0662a9

┌─name────┬─department─┬──────month─┬─salary─┬─row─┬─sum_wage─┬─sum_wage_2─┐
│ Fancy   │ Finance    │ 2020-01-01 │  10000 │   1 │    20000 │      10000 │
│ George  │ Finance    │ 2020-01-01 │  10000 │   2 │    20000 │      20000 │
│ Davd    │ Finance    │ 2020-01-01 │   8000 │   3 │    28000 │      28000 │
│ Ilaja   │ Marketing  │ 2020-01-01 │   7000 │   1 │     7000 │       7000 │
│ Haffman │ Marketing  │ 2020-01-01 │   6000 │   2 │    13000 │      13000 │
│ Elena   │ Sales      │ 2020-01-01 │   9000 │   1 │     9000 │       9000 │
│ Joey    │ Sales      │ 2020-01-01 │   8000 │   2 │    17000 │      17000 │
│ Ali     │ Sales      │ 2020-01-01 │   6000 │   3 │    29000 │      23000 │
│ Bob     │ Sales      │ 2020-01-01 │   6000 │   4 │    29000 │      29000 │
│ Cindy   │ Sales      │ 2020-01-01 │   5000 │   5 │    34000 │      34000 │
└─────────┴────────────┴────────────┴────────┴─────┴──────────┴────────────┘
```

#### range between
range between 按照列值限制窗口大小（在非条件表达式中等同于rows）

rows表示 行，就是前n行，后n行

而range表示的是具体的值，比这个值小n的行，比这个值大n的行

range between是以当前值为锚点进行计算

https://blog.csdn.net/liuyingying0418/article/details/120269624

## 窗口函数与group by的区别
1. 两个order by的区别，第一个窗口函数中的order by只是决定着窗口里的数据的排序方式，第二个普通的order by决定查询出的数据以什么样的方式整体排序；
2. 窗口函数可以在保留原表中的全部数据之后，可以对某些字段做分组排序或者计算，而group by只能保留与分组字段聚合的结果；
3. 在加入窗口函数的基础上SQL的执行顺序也会发生变化。

## 附
```sql
SELECT *
FROM employee_salary_1

Query id: f8909293-b931-43e5-b152-75315d62224b

┌──────month─┬─name────┬─department─┬─salary─┐
│ 2020-01-01 │ Ali     │ Sales      │   6000 │
│ 2020-01-01 │ Bob     │ Sales      │   6000 │
│ 2020-01-01 │ Cindy   │ Sales      │   5000 │
│ 2020-01-01 │ Davd    │ Finance    │   8000 │
│ 2020-01-01 │ Elena   │ Sales      │   9000 │
│ 2020-01-01 │ Fancy   │ Finance    │  10000 │
│ 2020-01-01 │ George  │ Finance    │  10000 │
│ 2020-01-01 │ Haffman │ Marketing  │   6000 │
│ 2020-01-01 │ Ilaja   │ Marketing  │   7000 │
│ 2020-01-01 │ Joey    │ Sales      │   8000 │
└────────────┴─────────┴────────────┴────────┘
```