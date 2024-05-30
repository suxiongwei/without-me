package com.sxw.learn.spring.expand;

import com.sxw.learn.reflect.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryAwareTest implements BeanFactoryAware {
    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void test() {
        Person person = (Person) beanFactory.getBean("person");
    }
}
