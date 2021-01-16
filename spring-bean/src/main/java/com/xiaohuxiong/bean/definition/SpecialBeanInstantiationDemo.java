package com.xiaohuxiong.bean.definition;

import com.xiaohuxiong.bean.factory.DefaultPersonFactory;
import com.xiaohuxiong.bean.factory.PersonFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        demoServiceLoader();
        System.out.println("=====demoServiceLoader end=========");
        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<PersonFactory> serviceLoader = beanFactory.getBean("personFactoryServiceLoader",
                ServiceLoader.class);

        displayServiceLoader(serviceLoader);
        System.out.println("=====displayServiceLoader end=========");

        // 创建 personFactory 对象，通过 AutowireCapableBeanFactory
        PersonFactory personFactory = beanFactory.createBean(DefaultPersonFactory.class);
        System.out.println(personFactory.createPerson());

    }

    public static void demoServiceLoader() {
        ServiceLoader<PersonFactory> serviceLoader = load(PersonFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<PersonFactory> serviceLoader) {
        Iterator<PersonFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            PersonFactory personFactory = iterator.next();
            System.out.println(personFactory.createPerson());
        }
    }
}
