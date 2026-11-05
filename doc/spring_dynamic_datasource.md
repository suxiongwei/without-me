# Spring 多数据源与事务边界

[首页](../README.md) · [版本与资料](references.md)

[Spring 分类](interview_spring.md) · [事务与代理专题](topics/spring-data-access.md)

**适用范围：** 常规线程绑定的本地 JDBC 事务；具体动态数据源组件实现和版本需单独核对。

## 为什么事务内切换数据源可能不生效

路由数据源通常依据线程上下文中的 key 选择目标数据源。事务管理器开始本地事务后，会将相应连接资源绑定到当前线程；后续访问可能复用已绑定连接。

因此“修改路由 key”与“切换当前事务正在使用的物理连接”不是同一件事。检查切面顺序、连接获取时机、事务传播和实际事务管理器，不能只看 ThreadLocal 中的 key 是否改变。

## 本地事务与跨库方案

代理连接可能改变 commit、rollback、close 的处理方式，但它本身不能证明多个数据库可以原子提交。采用动态数据源组件时，先明确是单库事务、分库独立提交、补偿方案还是协调式事务协议，再核对失败与恢复路径。

历史阅读资料：[路由与事务分析](https://www.cnblogs.com/wtzbk/p/17157708.html)、[组件实现笔记](https://blog.csdn.net/Wu_Shang001/article/details/121182437)。原理参考 [Spring 5.2 事务资源同步](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/data-access.html#transaction-resources)。
