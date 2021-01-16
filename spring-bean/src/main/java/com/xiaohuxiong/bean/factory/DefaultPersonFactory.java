package com.xiaohuxiong.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultPersonFactory implements PersonFactory, InitializingBean, DisposableBean {

    // 1. 基于 @PostConstruct 注解
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct : PersonFactory 初始化中...");
    }

    public void initPersonFactory() {
        System.out.println("自定义初始化方法 initPersonFactory() : PersonFactory 初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet() : PersonFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy : PersonFactory 销毁中...");
    }

    public void destroy() {
        System.out.println("DisposableBean#destroy()  : PersonFactory 销毁中...");
    }

    public void doDestroy() {
        System.out.println("自定义销毁方法 doDestroy()  : PersonFactory 销毁中...");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前 DefaultPersonFactory 对象正在被垃圾回收...");
    }
}
