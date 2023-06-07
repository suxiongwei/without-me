## 一些面试题-Spring

- [@Autowired和@Resource注解的区别](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E5%92%8C%40Resource%E6%B3%A8%E8%A7%A3%E7%9A%84%E5%8C%BA%E5%88%AB.md)
- [@Autowired的实现原理](https://github.com/suxiongwei/without-me/blob/main/doc/%40Autowired%E7%9A%84%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86.md)
- [拦截器与过滤器](https://github.com/suxiongwei/without-me/blob/main/doc/FILTERANDINTERCEPTOR.md)
- [@Configuration和@Component 的区别](https://github.com/suxiongwei/without-me/blob/main/doc/ConfigurationAndComponent.md)
- [SpringBoot启动时自动执行代码的几种方式](https://github.com/suxiongwei/without-me/blob/main/src/main/java/com/sxw/learn/spring/startrun/package-info.java)

#### Spring中的bean为什么默认设置为单例的
<details>
<summary>展开</summary>
首先 单例的性能好，开销低

其次 一般业务系统的组件以无状态的组件居多，这些组件比初始化是有一定开销的，基于这些bean的使用场景单例的系统开销最小，占据了bean的绝大多数配置场景，其他scope级别的使用场景是极其有限的。

基于以上的客观事实，默认配置为单例很大程度上还是为了减少人工确认配置的工作量，防止人工配置遗漏而带来的不必要的系统开销和风险，方便使用。
</details>


#### SpringBoot是什么&特点
<details>
<summary>展开</summary>
是什么：
为了简化Spring繁琐的XML配置，本质上还是Spring，理念是约定大于配置

特点：
- 供了固定的配置来简化配置，即约定大于配置
- 尽可能地自动配置 Spring 和第三方库，即能自动装配
</details>


#### SpringBoot自动配置的原理
<details>
<summary>展开</summary>
@SpringBootApplication里的核心注解，包含以下两部分：

- @SpringBootConfiguration（里面就是@Configuration，标注当前类为配置类，其实只是做了一层封装改了个名字而已）
- @EnableAutoConfiguration（开启自动配置）

@EnableAutoConfiguration 是SpringBoot中的重点部分，包含以下两部分：

- @AutoConfigurationPackage（将主配置类（@SpringBootApplication 标注的类）所在的包下面所有的组件都扫描注冊到 spring 容器中）
- @Import({AutoConfigurationImportSelector.class})（自动配置类的导入选择器，有选择的导入类）

SpringFactoriesLoader工厂加载机制是Spring内部提供的一个约定俗成的加载方式，只需要在模块的META-INF下创建spring.factories文件，
这个Properties格式的文件中的key是接口、注解、或抽象类的全名，value是以逗号 “ , “ 分隔的实现类，使用SpringFactoriesLoader来实现相应的实现类注入Spirng容器中。

链接：https://juejin.cn/post/7046554366068654094
</details>