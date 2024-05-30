package com.sxw.learn.spring.expand;

import com.sxw.learn.reflect.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerTest implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext applicationContext;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.applicationContext = event.getApplicationContext();
    }

    public void test() {
        Person person = (Person) applicationContext.getBean("person");
    }
}
