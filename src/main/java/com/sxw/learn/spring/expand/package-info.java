package com.sxw.learn.spring.expand;
/**
 * Spring框架的常用扩展点
 * https://juejin.cn/post/7145084738775023646
 *
 * 1、SpringMVC 自定义拦截器
 * 2、获取容器对象
 * 3、全局异常处理  @RestControllerAdvice
 * 4、导入配置 @Import注解
 * 5、项目启动
 * CommandLineRunner
 * ApplicationRunner
 *
 * 6、修改BeanDefinition 实现BeanFactoryPostProcessor
 * 每一个bean类型都会对应一个或多个BeanDefinition
 *
 * 7、初始化Bean前后 实现BeanPostProcessor接口，对所有bean生效
 *
 * 8、初始化方法 针对于单个bean
 * 使用@PostConstruct注解
 * 实现InitializingBean接口
 *
 * 9、关闭容器前 针对于单个bean
 * 实现DisposableBean接口
 *
 *
 * 附：
 * 🤔 BeanDefinition（豆定义）是在 Spring 框架中用于描述和定义 Bean 对象的元数据。它提供了一种机制，用于告诉 Spring 容器如何创建、配置和管理 Bean。
 *
 * BeanDefinition 的作用如下：
 * 1️⃣ 资源描述：BeanDefinition 描述了一个 Bean 的属性，包括其类名、依赖关系、初始化方法、销毁方法等。通过 BeanDefinition，Spring 容器能够获取到关于 Bean 的详细信息，并根据这些信息来实例化和管理 Bean。
 * 2️⃣ 配置灵活性：BeanDefinition 允许使用者通过配置文件或注解的方式定义 Bean。这样可以将对象的创建和配置与代码解耦，提供更大的灵活性和可维护性。
 * 3️⃣ 创建控制：通过配置 BeanDefinition，可以控制 Bean 的作用域（如单例或原型）、延迟初始化、依赖关系等。这样，可以在应用程序中灵活地管理和使用 Bean 实例。
 * 4️⃣ 解耦和懒加载：BeanDefinition 可以将 Bean 实例的创建和获取解耦，使得程序只关注 Bean 的使用而不需要关心具体的创建细节。此外，通过懒加载的方式，BeanDefinition 可以延迟实例化 Bean，提升系统性能和资源利用。
 *
 * 总的来说，BeanDefinition 提供了一种机制，用于描述和配置 Bean。它使得 Spring 容器能够根据定义的元数据来创建和管理 Bean 实例，实现了对象的解耦、配置的灵活性以及创建控制的能力。
 *
 *
 */