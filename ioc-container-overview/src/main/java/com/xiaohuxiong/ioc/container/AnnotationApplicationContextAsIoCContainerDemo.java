package com.xiaohuxiong.ioc.container;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文  重点
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory =(ListableBeanFactory)beanFactory;
            Map<String, Person> personMap = listableBeanFactory.getBeansOfType(Person.class);
            System.out.println("查找所有的集合对象："+personMap);
        }
    }

    /**
     * 通过 Java 注解的方式，定义了一个 Bean
     */
    @Bean
    public Person person() {
        Person person = new Person();
        person.setAge(18);
        person.setName("huwl");
        return person;
    }

}
