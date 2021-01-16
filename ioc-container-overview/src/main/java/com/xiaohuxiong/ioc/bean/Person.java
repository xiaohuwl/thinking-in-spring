package com.xiaohuxiong.ioc.bean;

/**
 * setter/getter
 * 可写   可读
 *
 */
public class Person {

    private  String name;
    private  int  age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.xiaohuxiong.ioc.bean.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Person createPerson(){
        Person person = new Person();
        person.setAge(18);
        person.setName("huwl");
        return person;
    }
}
