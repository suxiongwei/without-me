# Spring 与数据访问

[首页](../README.md) · [阅读路线](LEARNING_PATHS.md) · [全部问答](技术学习笔记.md)

前置知识：Java 方法调用和异常。先理解容器与代理，再学习事务、数据访问和 Web 调用链。

**版本与前提：** 工程 Spring Boot 2.2.6.RELEASE，事务和容器参考 Spring Framework 5.2；相关差异见版本资料。

## 推荐阅读

- [Q07 Spring 事务为什么会看起来不生效](topics/spring-data-access.md#q07-spring-事务为什么会看起来不生效)
- [Q08 REQUIRED 与 REQUIRES_NEW 有什么区别](topics/spring-data-access.md#q08-required-与-requires_new-有什么区别)
- [Q09 Spring AOP 代理有什么边界](topics/spring-data-access.md#q09-spring-aop-代理有什么边界)
- [Q10 MyBatis 中参数绑定 缓存与查询数量怎么检查](topics/spring-data-access.md#q10-mybatis-中参数绑定-缓存与查询数量怎么检查)

## 配套专题与练习

- [注入注解比较](@Autowired和@Resource注解的区别.md)
- [自动装配原理](@Autowired的实现原理.md)
- [配置类与组件](ConfigurationAndComponent.md)
- [Filter 与 Interceptor](FILTERANDINTERCEPTOR.md)
- [多数据源与事务](spring_dynamic_datasource.md)

## 补充笔记与代码

- [SpringBoot启动时自动执行代码的几种方式](../src/main/java/com/sxw/learn/spring/startrun/package-info.java)

### 单例作用域与共享状态

Spring 容器中的 singleton 表示每个容器、每个相应 Bean 定义的共享实例，不等同于整个 JVM 的全局唯一对象。共享实例有利于复用，但不会自动提供线程安全；请求相关的可变字段需要避免共享或单独协调。

### Spring Boot 与自动配置

工程基线为 Spring Boot 2.2.6.RELEASE。自动配置根据类路径、已有 Bean、配置项等条件尝试提供默认组件，应用可以显式配置覆盖或排除。

`@SpringBootApplication` 组合配置、自动配置与组件扫描等能力。组件扫描与 AutoConfigurationPackages 的包登记不是同一件事，不能把 `@AutoConfigurationPackage` 描述为“扫描并注册所有组件”。

Boot 2.2 的候选加载涉及 `spring.factories` 和自动配置导入选择；新版本的导入元数据与机制需重新核对，不能只背一个文件名概括所有版本。

参考：[Spring Boot 2.2.6 自动配置](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/html/using-spring-boot.html#using-boot-auto-configuration)。
