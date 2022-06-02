package com.sxw.learn.spring.startrun;
/**
 * SpringBoot 启动时自动执行代码的几种方式
 * https://mp.weixin.qq.com/s/FPU-T6lx_Cz0wsp0HLPqCw
 *
 * java自身的启动时加载方式
 * 1、static代码块
 *  static静态代码块，在类加载的时候即自动执行。
 * 2、构造方法
 *  在对象初始化时执行。执行顺序在static静态代码块之后。
 *
 * Spring启动时加载方式
 * 1、@PostConstruct注解
 *  PostConstruct注解使用在方法上，这个方法在对象依赖注入初始化之后执行。
 * 2、ApplicationRunner和CommandLineRunner
 *
 *
 * 测试结果：
 * 2022-05-18 14:41:42 [main] INFO  o.s.web.context.ContextLoader - Root WebApplicationContext: initialization completed in 1408 ms
 * TestPostConstruct 执行static方法
 * TestPostConstruct 执行构造方法
 * TestPostConstruct 执行@PostConstruct注解修饰的方法
 * 2022-05-18 14:41:42 [main] INFO  o.s.s.c.ThreadPoolTaskExecutor - Initializing ExecutorService 'applicationTaskExecutor'
 * 2022-05-18 14:41:42 [main] INFO  io.undertow - starting server: Undertow - 2.0.30.Final
 * 2022-05-18 14:41:42 [main] INFO  org.xnio - XNIO version 3.3.8.Final
 * 2022-05-18 14:41:42 [main] INFO  org.xnio.nio - XNIO NIO Implementation Version 3.3.8.Final
 * 2022-05-18 14:41:43 [main] INFO  o.s.b.w.e.u.UndertowServletWebServer - Undertow started on port(s) 8080 (http) with context path ''
 * 2022-05-18 14:41:43 [main] INFO  com.sxw.learn.Application - Started Application in 2.483 seconds (JVM running for 2.845)
 * TestApplicationRunner order1执行
 * TestApplicationRunner order2执行
 * TestCommandLineRunner执行
 *
 * 结论：
 * Spring应用启动过程中，肯定是要自动扫描有@Component注解的类，加载类并初始化对象进行自动注入。
 * 加载类时首先要执行static静态代码块中的代码，之后再初始化对象时会执行构造方法。
 * 在对象注入完成后，调用带有@PostConstruct注解的方法。当容器启动成功后，再根据@Order注解的顺序调用CommandLineRunner和ApplicationRunner接口类中的run方法。
 *
 * 因此，加载顺序为static>constructer>@PostConstruct>CommandLineRunner和ApplicationRunner.
 */