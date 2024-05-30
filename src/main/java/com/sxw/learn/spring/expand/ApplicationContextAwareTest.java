package com.sxw.learn.spring.expand;

import com.sxw.learn.reflect.Person;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test() {
        Person person = (Person) applicationContext.getBean("person");
    }
}
