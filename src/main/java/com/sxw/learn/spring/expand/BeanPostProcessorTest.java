package com.sxw.learn.spring.expand;

import com.sxw.learn.reflect.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 对于应用程序上下文都是全局的，所以它们会对整个应用中的所有 Bean 进行处理。
 *
 * 其实，我们经常使用的注解，比如：@Autowired、@Value、@Resource、@PostConstruct等，是通过AutowiredAnnotationBeanPostProcessor和CommonAnnotationBeanPostProcessor实现的。
 */
public class BeanPostProcessorTest implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person){
            Person person = (Person) bean;
            person.setUserName("苏雄伟");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
