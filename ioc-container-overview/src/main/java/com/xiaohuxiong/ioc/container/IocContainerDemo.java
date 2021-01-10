package com.xiaohuxiong.ioc.container;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class IocContainerDemo {

    public static void main(String[] args) {

        //创建bean
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String path="classpath:/META-INF/dependency-lookup-context.xml";
        //lookupCollectionByType(beanFactory);
        int i = reader.loadBeanDefinitions(path);
        System.out.println("当前加载bean的数量："+i);
        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =(ListableBeanFactory)beanFactory;
            Map<String, Person> personMap = listableBeanFactory.getBeansOfType(Person.class);
            System.out.println("查找所有的集合对象："+personMap);
        }
    }
}
