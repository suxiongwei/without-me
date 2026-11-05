# Autowired 自动装配实现

[首页](../README.md) · [版本与资料](references.md)

[Spring 分类](interview_spring.md) · [依赖注入规则](@Autowired和@Resource注解的区别.md)

**适用版本：** Spring Framework 5.2。下面是调用阶段的简化模型，具体内部方法按源码版本核对。

## 从实例创建到依赖注入

`AutowiredAnnotationBeanPostProcessor` 参与候选构造器识别和字段、方法注入。对象实例创建后，属性填充阶段调用相关后置处理逻辑，解析注入点，再委托容器解析依赖。

较新版本常见入口为 `postProcessProperties`；旧笔记中的 `postProcessPropertyValues` 不能当成跨版本唯一入口。内置处理器的注册数量也不应作为容器工作的固定契约。

## 解析与失败

先根据类型找到候选，再考虑限定信息、主候选等选择规则；精确顺序受注解、注入位置与版本影响。无候选、多候选或循环依赖都可能使创建失败。依赖解析完成不代表整个 Bean 生命周期结束，还需继续检查初始化与代理阶段。

参考：[Spring 5.2 自动装配](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/core.html#beans-autowired-annotation)。
