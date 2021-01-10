package com.xiaohuxiong.ioc.dependency.injection;

import com.xiaohuxiong.ioc.annotation.Super;
import com.xiaohuxiong.ioc.bean.Person;
import com.xiaohuxiong.ioc.repository.PersonRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖查找
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/dependency-injection-context.xml");

        PersonRepository repository = (PersonRepository)beanFactory.getBean("people");

        //定义bean 依赖的来源
        //System.out.println(repository.getPeople());
        //内建bean 依赖的来源
        //System.out.println(repository.getBeanFactory()==beanFactory);
        //System.out.println(repository.getBeanFactory());

        //No qualifying bean of type 'org.springframework.beans.factory.BeanFactory'
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        System.out.println(repository.getPersonObjectFactory());

        //内建依赖 依赖的来源
        ObjectFactory<ApplicationContext> applicationContextObjectFactory =
                repository.getPersonObjectFactory();
        System.out.println(applicationContextObjectFactory.getObject());

        System.out.println(applicationContextObjectFactory.getObject()==beanFactory);

        //容器内建bean
        Environment bean = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 的类型 Bean:" + bean);
    }

    private static void whoIsIocContainer(PersonRepository repository,ApplicationContext applicationContext){
        //ConfigurableApplicationContext#getBean() <- ApplicationContext <- BeanFactory

        System.out.println(repository.getBeanFactory()==applicationContext);
    }
}
