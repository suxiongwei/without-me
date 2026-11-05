# Future 与异步结果获取

[首页](../README.md) · [版本与资料](references.md)

[Java 分类](interview_java.md) · [线程池与 CompletableFuture](topics/java-concurrency.md)

**适用版本：** Java 8。

## 为什么 get 可能阻塞

`Future.get()` 等待任务完成；是否在最后调用取决于依赖关系和并行工作安排。`get(timeout, unit)` 限制调用方等待时间，超时本身不会证明底层任务已经终止。

不建议用忙轮询统一替代阻塞等待：轮询会消耗 CPU，也需要自行处理超时、异常和取消。多个任务可考虑 CompletionService 按完成顺序取结果；依赖编排可阅读 CompletableFuture。

## 代码与边界

- [FutureDemo](../src/main/java/com/sxw/learn/juc/future/FutureDemo.java)
- [CompletableFuture 示例](../src/main/java/com/sxw/learn/juc/future/CompletableFutureApiDemo.java)

取消可能发出中断请求，任务是否及时退出取决于实现和阻塞操作；异常也需要沿调用链处理，不能因为用了异步就忽略失败。

参考：[Java 8 Future](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html)。
