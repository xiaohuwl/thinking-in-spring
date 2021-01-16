package com.xiaohuxiong.bean.definition;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 xiaomage-user 获取曾用名 user 的 bean
        Person person = beanFactory.getBean("person", Person.class);
        Person huwlperson = beanFactory.getBean("huwl-person", Person.class);
        System.out.println("huwl-person 是否与 person Bean 相同：" + (person == huwlperson));
    }
}
