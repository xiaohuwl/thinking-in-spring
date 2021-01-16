package com.xiaohuxiong.bean.definition;

import com.xiaohuxiong.bean.factory.DefaultPersonFactory;
import com.xiaohuxiong.bean.factory.PersonFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 创建一个外部 PersonFactory 对象
        PersonFactory personFactory = new DefaultPersonFactory();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        // 注册外部单例对象
        singletonBeanRegistry.registerSingleton("personFactory", personFactory);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 UserFactory
        PersonFactory userFactoryByLookup = applicationContext.getBean("personFactory", PersonFactory.class);
        System.out.println("personFactory  == personFactoryByLookup : " + (personFactory == userFactoryByLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }
}
