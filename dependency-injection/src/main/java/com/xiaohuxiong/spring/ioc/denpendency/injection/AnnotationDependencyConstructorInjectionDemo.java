package com.xiaohuxiong.spring.ioc.denpendency.injection;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于 Java 注解的依赖 Constructor 注入示例
 * @author: huwl
 * @date: 2021/3/22 21:00
 **/
public class AnnotationDependencyConstructorInjectionDemo {


    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找并且创建 Bean
        PersonHold personHolder = applicationContext.getBean(PersonHold.class);
        System.out.println(personHolder);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean
    public PersonHold personHold(Person person){
        PersonHold personHold = new PersonHold();
        personHold.setPerson(person);
        return personHold;
    }

}
