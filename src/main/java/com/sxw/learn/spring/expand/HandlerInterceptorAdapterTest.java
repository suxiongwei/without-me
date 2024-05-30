package com.sxw.learn.spring.expand;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring mvc拦截器的顶层接口是：HandlerInterceptor，包含三个方法：
 *
 * preHandle 目标方法执行前执行
 * postHandle 目标方法执行后执行
 * afterCompletion 请求完成时执行
 *
 * 为了方便我们一般情况会用HandlerInterceptor接口的实现类HandlerInterceptorAdapter类。
 * 假如有权限认证、日志、统计的场景，可以使用该拦截器。
 *
 * 定义完之后还需要注册到容器中
 */
public class HandlerInterceptorAdapterTest extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
