### @Configuration 和 @Component 的区别 ！ 

> 一句话概括就是 @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例。 
> 
> 理解：调用@Configuration类中的@Bean注解的方法，返回的是同一个实例；而调用@Component类中的@Bean注解的方法，返回的是一个新的实例。


https://mp.weixin.qq.com/s/-_h5Hz6MOBb8TK3qm9gBog