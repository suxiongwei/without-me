## Spring多数据源&Spring事务

### 添加了事务后数据源切换失效
Spring事务是基于AOP动态代理实现的，被增强后connection是从缓存中获取的，因此动态数据源自然也就失效了
> DataSourceTransactionManager负责管理整体的事务，执行中拦截Service中的方法后，每次执行Service方法前后会开启一个事务，
> 并且同时会缓存DataSource、SqlSessionFactory、Connection，，因为DataSource、Conneciton都是从缓存中(ThradLocal)拿的，因此我们怎么切换数据源也没用

参考文章：
- https://www.cnblogs.com/wtzbk/p/17157708.html

### dynamic-datasource-spring-boot-starter的实现方式
内部使用Map保存多个数据源，获取connection时，根据ThreadLocal中的dsKey获取对应的数据源

对于事务的实现来说，会返回一个ConnectionProxy（不会执行commit、rollback、close操作事务相关的方法）

参考文章：
- https://blog.csdn.net/Wu_Shang001/article/details/121182437
