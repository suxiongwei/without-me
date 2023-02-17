Filter（过滤器）作用于在Interceptor(拦截器)之前，不像Interceptor一样依赖于springmvc框架， 只需要依赖于Servlet。

拦截器不依赖servlet容器，过滤器依赖；

拦截器是基于java反射机制来实现的，过滤器基于回调

https://github.com/rbmonster/learning-note/blob/master/src/main/java/com/toc/FILTERANDINTERCEPTOR.md

