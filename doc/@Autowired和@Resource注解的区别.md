# Autowired 与 Resource 的依赖注入规则

[首页](../README.md) · [版本与资料](references.md)

[Spring 分类](interview_spring.md) · [自动装配实现](@Autowired的实现原理.md)

**适用版本：** 以 Spring Framework 5.2 与 `javax.annotation.Resource` 为基线；升级至使用 `jakarta.annotation` 的环境时核对依赖与处理器。

## 候选选择

| 注解 | 常规起点 | 多个候选时怎么明确 |
| --- | --- | --- |
| `@Autowired` | 按类型查找 | 使用 Qualifier、Primary 等规则；名称也可能参与候选消歧，不能理解成只看类型 |
| `@Resource` | 未显式指定 name 时，通常使用字段或属性名 | 显式 name 按名称解析；默认名称未匹配时，Spring 处理器可能按类型回退 |

## 使用边界

`@Autowired` 的 required、Optional 和可空配置影响缺少候选时的行为；`@Resource` 的 name、type 和使用位置需要结合处理器规则理解。不能把两者简单等同于 XML 的 byType / byName 自动装配模式。

构造器注入便于表达必需依赖，也便于直接构造对象进行使用；字段、setter 与构造器各有场景，注解名称本身不能证明设计优劣。

参考：[Spring 5.2 注解容器配置](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/core.html#beans-annotation-config)。
