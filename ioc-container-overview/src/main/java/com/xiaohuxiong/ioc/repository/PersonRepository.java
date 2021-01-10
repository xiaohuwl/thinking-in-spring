package com.xiaohuxiong.ioc.repository;

import com.xiaohuxiong.ioc.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class PersonRepository {

    //定义bean
    private Collection<Person> people;

    //内建bean
    private BeanFactory beanFactory;

    private ObjectFactory<Person> personObjectFactory;

    //内建bean
    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getPersonObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }
}
