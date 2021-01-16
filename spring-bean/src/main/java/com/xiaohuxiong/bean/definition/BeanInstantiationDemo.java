package com.xiaohuxiong.bean.definition;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        Person person = beanFactory.getBean("person-by-static-method", Person.class);
        Person personByInstanceMethod = beanFactory.getBean("person-by-instance-method", Person.class);
        Person personByFactoryBean = beanFactory.getBean("person-by-factory-bean", Person.class);
        System.out.println(person);
        System.out.println(personByInstanceMethod);
        System.out.println(personByFactoryBean);

        System.out.println(person == personByFactoryBean);
        System.out.println(person == personByInstanceMethod);
    }
}
