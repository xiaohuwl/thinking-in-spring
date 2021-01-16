package com.xiaohuxiong.bean.factory;

import com.xiaohuxiong.ioc.bean.Person;

public interface PersonFactory {

    default Person createPerson() {
        return Person.createPerson();
    }
}
