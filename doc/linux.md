# 工具、命令与运行诊断

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

按症状收集证据：请求标识与耗时 → 线程/连接池 → JVM → SQL 与消息链路。命令先核对系统与权限。

**版本与前提：** 诊断主题以 Linux 与 JDK 8 为基线；命令、权限、工具可用性和有副作用的操作按实际环境确认。

## 推荐阅读

- [Q11 Java 进程 CPU 高或内存持续增长 怎么排查](topics/runtime-diagnostics.md#q11-java-进程-cpu-高或内存持续增长-怎么排查)
- [Q12 接口很慢 但数据库不慢 怎么定位](topics/runtime-diagnostics.md#q12-接口很慢-但数据库不慢-怎么定位)

## 配套专题与练习

- [容量与性能评估](常见软件的QPS.md)
- [Kafka 排查命令](kafka.md)
- [技术边界速查](quick-reference.md)

## 补充笔记与代码

- 统计行数：wc -l

**awk命令**

参考资料：[zhuanlan.zhihu.com](https://zhuanlan.zhihu.com/p/348210420)

参考资料：[www.cnblogs.com](https://www.cnblogs.com/hider/p/11834706.html)

awk 命令默认是以「空格」为分隔符，由于访问时间在日志里的第 4 列，因此可以使用 awk '{print $4}' access.log 命令把访问时间的信息过滤出来

```shell
awk '{print $2}' davinci.2023-01-16.log
cat davinci.2023-01-16.log | grep '2023-01-16' | awk '{print substr($2,1,2)}' | sort | uniq -c | sort -rn | head -n 3
注意，使用 uniq -c 命令前，先要进行 sort 排序，因为 uniq 去重的原理是比较相邻的行，然后除去第二行和该行的后续副本，因此在使用 uniq 命令之前，请使用 sort 命令使所有重复行相邻。

```
sort -rn（r 表示逆向排序， n 表示按数值排序） 对统计的结果排序

head -n 3 分析 TOP3

**切割CSV文件，大文件切割为小文件**
```shell
vim split_file_to_part_based_on_line.sh

#!/bin/bash

:<<!
参数说明：
$0      脚本文件名
$1      待拆分文件名
$2      拆分后的文件的行数
$3      拆分后的文件的前缀
!

echo "---- start ----"
echo "FILE_NAME: $1"

total_lines=`cat $1 | wc -l`
floor=`echo "scale=0;$total_lines/$2"|bc -l ` # 向下取整
flag=`awk -v num1=$floor -v num2=$1 'BEGIN{print(num1<num2)?"1":"0"}'`
num=`expr $floor + $flag`
filename=$1
extension="${filename##*.}"

split $1 -l $2 --verbose -d -a ${#num} $3_&&ls|grep $3|xargs -n1 -i{} mv {} {}.${extension}

last_file_line=`cat $3_$floor.${extension} | wc -l`

echo "FILE_EXT: ${extension}"
echo "FILE_LINES: $total_lines"
echo "FILE_NUMBER: $num"
echo "LAST_FILE_LINE: ${last_file_line}"

使用示例：
./split_file_to_part_based_on_line.sh xxx.csv 40000000 xxx
```

**替换文件内容**
```shell
sed -i 's/"//g' tkt_1.csv
```
