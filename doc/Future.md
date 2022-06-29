FutureTask get容易发生阻塞，一般放在程序最后面, 如果使用推荐下面轮询的方式使用
Future的缺点：对于结果的获取不是很友好，只能通过轮询或者阻塞的方式得到任务的结果，因此引出了CompletableFuture

## 代码实例
[FutureDemo](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/juc/future/FutureDemo.java)

