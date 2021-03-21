package com.xiaohuxiong.spring.ioc.denpendency.injection;

import com.xiaohuxiong.ioc.bean.Person;

/**
 * @author: huwl
 * @date: 2021/3/21 15:42
 **/
public class PersonHold {

    private Person person;

    public PersonHold() {
    }

    public PersonHold(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonHold{" +
                "person=" + person +
                '}';
    }
}
