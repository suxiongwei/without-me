> 区别：
> 1、@Autowired注解由Spring提供，只按照byType注入；@resource注解由J2EE提供，默认按照byName自动注入。
> 2、@Autowired默认按类型进行装配，@Resource默认按照名称进行装配。

1、@Autowired

由Spring提供，只按照byType注入

2、@Resource

由J2EE提供，默认按照byName自动注入

@Resource有两个重要的属性：name和type

Spring将@Resource注解的name属性解析为bean的名字，type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。

@Resource装配顺序：

（1）如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常

（2）如果指定了name，则从Spring上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常

（3）如果指定了type，则从Spring上下文中找到类型匹配的唯一bean进行装配，找不到或找到多个，都抛出异常

（4）如果既没指定name，也没指定type,则自动按照byName方式进行装配。如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配。

@Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入。

3、使用区别

（1）@Autowired与@Resource都可以用来装配bean，都可以写在字段或setter方法上

（2）@Autowired默认按类型装配，默认情况下必须要求依赖对象存在，如果要允许null值，可以设置它的required属性为false。如果想使用名称装配可以结合@Qualifier注解进行使用。

（3）@Resource，默认按照名称进行装配，名称可以通过name属性进行指定，如果没有指定name属性，当注解写在字段上时，默认取字段名进行名称查找。如果注解写在setter方法上默认取属性名进行装配。当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。

推荐使用@Resource注解在字段上，这样就不用写setter方法了，并且这个注解是属于J2EE的，减少了与Spring的耦合。