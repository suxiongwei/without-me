package com.sxw.learn.spring.test1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Component("student")
public class StudentImpl implements Person, InitializingBean, DisposableBean, ApplicationContextAware {

    private String name;

    @Override
    public void sayHello() {
        log.info("Hello World, " + this.name);
    }

    @PostConstruct
    public void init() {
        this.name = "student";
    }

    @Override
    public String toString() {
        return "HelloWorldImpl{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean destroy, name:" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean afterPropertiesSet, name:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        log.info("setApplicationContext:" + Arrays.toString(beanDefinitionNames));
    }
}
