package com.xiaohuxiong.ioc.dependency.lookup;

import com.xiaohuxiong.ioc.annotation.Super;
import com.xiaohuxiong.ioc.bean.Person;
import com.xiaohuxiong.ioc.bean.SuperPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/dependency-lookup-context.xml");
        //根据注解查找
        lookupByAnnotation(beanFactory);
        //按照类型查找结合对象
        lookupCollectionByType(beanFactory);
        //类型查找
        LookupByType(beanFactory);
        //实时查找
        LookupRealTime(beanFactory);
        //延迟查找
        LookupLazy(beanFactory);

    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =(ListableBeanFactory)beanFactory;
            Map<String, Person> personMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找所有标注@Super的person对象 ："+personMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =(ListableBeanFactory)beanFactory;
            Map<String, Person> personMap = listableBeanFactory.getBeansOfType(Person.class);
            System.out.println("查找所有的集合对象："+personMap);
        }
    }

    private static void LookupByType(BeanFactory beanFactory) {
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);
    }

    private static void LookupLazy(BeanFactory beanFactory) {
        ObjectFactory<Person> objectFactory = (ObjectFactory<Person>)beanFactory.getBean("objectFactory");
        Person object = objectFactory.getObject();
        System.out.println("延迟查找："+object);
    }

    private static void LookupRealTime(BeanFactory beanFactory) {
        Person person = (Person) beanFactory.getBean("person");
        System.out.println("实时查找："+person);
    }
}
