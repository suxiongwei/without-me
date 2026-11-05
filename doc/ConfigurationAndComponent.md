# 配置类与普通组件中的 Bean 方法

[首页](../README.md) · [版本与资料](references.md)

[Spring 分类](interview_spring.md) · [Spring 事务与代理](topics/spring-data-access.md)

**适用版本：** Spring Framework 5.2。这里讨论容器管理的配置实例与普通 Java 方法调用。

## 核心区别

默认的 `@Configuration(proxyBeanMethods = true)` 会增强配置类，拦截配置类内部的 Bean 方法调用，使其遵守容器中对应 Bean 的作用域与生命周期。

`@Component` 中的 Bean 方法，以及 `@Configuration(proxyBeanMethods = false)`，属于不采用这种配置类方法代理的方式。方法内部直接调用另一个 Bean 方法，遵循普通 Java 调用语义。

## 不能推导出的结论

不能把它概括成“Configuration 一定返回同一个对象、Component 一定创建新对象”。从容器获取单例 Bean、直接调用工厂方法，以及 prototype 等作用域，是不同的问题。需要依赖其他 Bean 时，使用参数注入可以减少对配置类内部方法拦截的依赖。

参考：[Spring 5.2 Java-based Configuration](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/core.html#beans-java-basic-concepts)。
