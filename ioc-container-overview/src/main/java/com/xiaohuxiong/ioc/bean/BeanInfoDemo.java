package com.xiaohuxiong.ioc.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        //BeanInfo beanInfo = Introspector.getBeanInfo(com.xiaohuxiong.ioc.bean.Person.class);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);
            //PropertyDescriptor 允许添加属性编辑器  -- PropertyEditor
            Class<?> propertyType = propertyDescriptor.getPropertyType();

            String name = propertyDescriptor.getName();
            if ("age".equals(name)){
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                //PropertyEditor propertyEditor = propertyDescriptor.createPropertyEditor(com.xiaohuxiong.ioc.bean.Person.class);
            }
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{

        public void setAsText(String text) throws IllegalArgumentException {
            Integer valueOf = Integer.valueOf(text);
            setValue(valueOf);
        }
    }
}
