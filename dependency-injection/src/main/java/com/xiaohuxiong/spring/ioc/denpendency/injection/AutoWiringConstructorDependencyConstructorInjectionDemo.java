package com.xiaohuxiong.spring.ioc.denpendency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * "constructor" Autowiring 依赖构造器注入示例
 * @author: huwl
 * @date: 2021/3/22 20:57
 **/
public class AutoWiringConstructorDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        String xmlResourcePath = "classpath:/META-INF/autowiring-dependency-constructor-injection.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);
        // 依赖查找并且创建 Bean
        PersonHold personHolder = beanFactory.getBean(PersonHold.class);
        System.out.println(personHolder);
    }
}
