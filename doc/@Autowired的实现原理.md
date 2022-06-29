> @Autowired注解的实现是通过后置处理器AutowiredAnnotationBeanPostProcessor类的postProcessPropertyValues()方法实现的。
## 源码分析
### 实现原理:AutowiredAnnotationBeanPostProcessor
### AutowiredAnnotationBeanPostProcessor何时被加入
容器启动会注册7个Spring内置的Bean，其中就包括AutowiredAnnotationBeanPostProcessor

### AutowiredAnnotationBeanPostProcessor何时被调用
- Spring在创建bean的过程中，最终会调用到doCreateBean()方法，
- 在doCreateBean()方法中会调用populateBean()方法，来为bean进行属性填充，完成自动装配等工作。
- populateBean()方法的会调用后置处理器相关代码。


## 总结
1. @Autowired注解的实现是通过后置处理器AutowiredAnnotationBeanPostProcessor类的postProcessPropertyValues()方法实现的。
2. 当自动装配时，从容器中如果发现有多个同类型的属性时，@Autowired注解会先根据类型判断，然后根据@Primary、@Priority注解判断，最后根据属性名与beanName是否相等来判断，如果还是不能决定注入哪一个bean时，就会抛出NoUniqueBeanDefinitionException异常。
3. @Autowired自动装配中byName、byType与自动装配的模型中的byName、byTYpe没有任何关系，两者含义完全不一样，前者是实现技术的手段，后者是用来定义BeanDefiniton中autowireMode属性的值的类型。


参考资料:https://juejin.cn/post/6844903957135884295