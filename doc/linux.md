- 统计行数：wc -l

**awk命令**

https://zhuanlan.zhihu.com/p/348210420

https://www.cnblogs.com/hider/p/11834706.html

awk 命令默认是以「空格」为分隔符，由于访问时间在日志里的第 4 列，因此可以使用 awk '{print $4}' access.log 命令把访问时间的信息过滤出来

```shell
awk '{print $2}' davinci.2023-01-16.log
cat davinci.2023-01-16.log | grep '2023-01-16' | awk '{print substr($2,1,2)}' | sort | uniq -c | sort -rn | head -n 3
注意，使用 uniq -c 命令前，先要进行 sort 排序，因为 uniq 去重的原理是比较相邻的行，然后除去第二行和该行的后续副本，因此在使用 uniq 命令之前，请使用 sort 命令使所有重复行相邻。


```
sort -rn（r 表示逆向排序， n 表示按数值排序） 对统计的结果排序

head -n 3 分析 TOP3